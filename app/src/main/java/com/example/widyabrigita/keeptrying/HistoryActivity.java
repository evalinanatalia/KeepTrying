package com.example.widyabrigita.keeptrying;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.widyabrigita.keeptrying.Adapter.HistoryAdapter;
import com.example.widyabrigita.keeptrying.Model.GasFiltered;
import com.example.widyabrigita.keeptrying.Model.Track;
import com.example.widyabrigita.keeptrying.Network.NetworkService;
import com.example.widyabrigita.keeptrying.Remote.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HistoryActivity extends AppCompatActivity {
  private ListView list;
  private ImageButton imgFilter;
  ActionBar actionBar;

  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //getSupportActionBar().setTitle("fjkdgj");
    //actionBar.setTitle("jkfgjkfd");
    setContentView(R.layout.activity_history_view);

    list = (ListView) findViewById(R.id.recycle);
    imgFilter = (ImageButton) findViewById(R.id.img_filter);

    NetworkService service = RetrofitClient.getClient().create(NetworkService.class);
    Call<Track> call = service.getHistory();
    final ProgressDialog progressDoalog;
    progressDoalog = new ProgressDialog(HistoryActivity.this);
    progressDoalog.setMax(100);
    progressDoalog.setMessage("Loading data....");
    progressDoalog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
    // show it
    progressDoalog.show();
    call.enqueue(new Callback<Track>() {
      @Override
      public void onResponse(Call<Track> call, Response<Track> response) {
        Track track = response.body();
        List<GasFiltered> hist = track.getData();
        //sta_name.setText(hist.get(0).getStationName());
        HistoryAdapter hAdapter = new HistoryAdapter(HistoryActivity.this, hist);

        list.setAdapter(hAdapter);
        progressDoalog.dismiss();
      }

      @Override
      public void onFailure(Call<Track> call, Throwable t) {
        Toast.makeText(HistoryActivity.this, "gagal",Toast.LENGTH_LONG).show();
        progressDoalog.dismiss();
      }
    });

//    Intent incoming = getIntent();
//    String date = incoming.getStringExtra("date");
//    thedate.setText(date);

    imgFilter.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
       /* Intent intent = new Intent(HistoryActivity.this, CalendarActivity.class);
        startActivity(intent);*/
        DialogReportHistory dirh = new DialogReportHistory(HistoryActivity.this);
        dirh.showDialog();
        dirh.callBack(new OnCallback() {
          @Override
          public void setOnCallback(Object object) {
            String tgl = (String) object;

            NetworkService service = RetrofitClient.getClient().create(NetworkService.class);
            Call<Track> call = service.getHistoryByDate("09/11/2017", "20/11/2017");
            final ProgressDialog progressDoalog;
            progressDoalog = new ProgressDialog(HistoryActivity.this);
            progressDoalog.setMax(100);
            progressDoalog.setMessage("Loading data....");
            progressDoalog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            // show it
            progressDoalog.show();
            call.enqueue(new Callback<Track>() {
              @Override
              public void onResponse(Call<Track> call, Response<Track> response) {
                Track track = response.body();
                List<GasFiltered> hist = track.getData();
                HistoryAdapter hAdapter = new HistoryAdapter(HistoryActivity.this, hist);

                list.setAdapter(hAdapter);
                progressDoalog.dismiss();
              }

              @Override
              public void onFailure(Call<Track> call, Throwable t) {
                Toast.makeText(HistoryActivity.this, "gagal",Toast.LENGTH_LONG).show();
                progressDoalog.dismiss();
              }
            });
          }
        });
      }
    });
  }

  public void fetchHistory(final GasFiltered gasFiltered){

  }
}
