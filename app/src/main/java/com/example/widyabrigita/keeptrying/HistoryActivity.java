package com.example.widyabrigita.keeptrying;

import android.content.Intent;
import android.os.Bundle;
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

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HistoryActivity extends AppCompatActivity {
  private ListView list;
  private ImageButton imgFilter;

  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_history_view);

    list = (ListView) findViewById(R.id.recycle);
    imgFilter = (ImageButton) findViewById(R.id.img_filter);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://private-276a7f-pertaminago1.apiary-mock.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    NetworkService service = retrofit.create(NetworkService.class);
    Call<Track> call = service.getHistory();
    call.enqueue(new Callback<Track>() {
      @Override
      public void onResponse(Call<Track> call, Response<Track> response) {
        Track track = response.body();
        List<GasFiltered> hist = track.getData();
        //sta_name.setText(hist.get(0).getStationName());
        HistoryAdapter hAdapter = new HistoryAdapter(HistoryActivity.this, hist);
        list.setAdapter(hAdapter);
      }

      @Override
      public void onFailure(Call<Track> call, Throwable t) {
        Toast.makeText(HistoryActivity.this, "gagal",Toast.LENGTH_LONG).show();
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
      }
    });
  }

  public void fetchHistory(final GasFiltered gasFiltered){

  }
}
