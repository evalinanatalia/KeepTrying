package com.example.widyabrigita.keeptrying;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

public class SplashActivity extends Activity {
  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.splash);

    Thread time = new Thread() {
      public void run() {
        try {
          sleep(3000);
          Intent intent = new Intent(SplashActivity.this, TabLayoutActivity.class);
          startActivity(intent);
        } catch (InterruptedException e) {
          e.printStackTrace();
        } finally {
          finish();
        }
      }
    };
    time.start();
  }

}
