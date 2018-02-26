package com.example.widyabrigita.keeptrying;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CalendarView;

public class CalendarActivity extends AppCompatActivity {

  private CalendarView mCalendarView;
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.calendar_layout);
    mCalendarView = (CalendarView) findViewById(R.id.calendarView);
    mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
      @Override
      public void onSelectedDayChange(CalendarView calendarView, int year, int month, int dayOfMonth) {
        String date = year + "/" + month + "/"+ dayOfMonth ;
        Log.d("CalendarActivity", "onSelectedDayChange: yyyy/mm/dd:" + date);
        Intent intent = new Intent(CalendarActivity.this, HistoryActivity.class);
        intent.putExtra("date",date);
        startActivity(intent);
      }
    });
  }
}
