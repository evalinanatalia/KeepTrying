package com.example.widyabrigita.keeptrying;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;


import com.example.widyabrigita.keeptrying.Model.GasFiltered;
import com.example.widyabrigita.keeptrying.Network.NetworkService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HistoryActivity extends AppCompatActivity {
  private TextView thedate, sta_name;
  private ImageButton imgFilter;

  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_history);

//    thedate = (TextView) findViewById(R.id.date);
//    sta_name = (TextView) findViewById(R.id.sta_name);

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://polls.apiblueprint.org")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    NetworkService service = retrofit.create(NetworkService.class);
    Call<List<GasFiltered>> call = service.getHistory("Bearer 123", "application/json");
    call.enqueue(new Callback<List<GasFiltered>>() {
      @Override
      public void onResponse(Call<List<GasFiltered>> call, Response<List<GasFiltered>> response) {
        List<GasFiltered> list = response.body();
        //GasFiltered gasFiltered = null;
        //sta_name.setText(list.get(0).getStationName());
      }

      @Override
      public void onFailure(Call<List<GasFiltered>> call, Throwable t) {

      }
    });

//    Intent incoming = getIntent();
//    String date = incoming.getStringExtra("date");
//    thedate.setText(date);

    imgFilter = (ImageButton) findViewById(R.id.img_filter);
    imgFilter.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        /*Intent intent = new Intent(HistoryActivity.this, CalendarActivity.class);
        startActivity(intent);*/
        DialogReportHistory dirh = new DialogReportHistory(HistoryActivity.this);
        dirh.showDialog();
      }
    });
  }

  public void fetchHistory(final GasFiltered gasFiltered){

  }
}
