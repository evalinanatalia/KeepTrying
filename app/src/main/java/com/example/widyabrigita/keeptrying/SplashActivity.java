package com.example.widyabrigita.keeptrying;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;


public class SplashActivity extends Activity {
  private SessionUser sessionUser;
  Intent intent = null;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.splash);

    sessionUser = new SessionUser();

    Thread time = new Thread() {
      public void run() {
        try {
          sleep(3000);
          if(sessionUser != null) {
            if (sessionUser.getSession(SplashActivity.this).equals("")) {
              intent = new Intent(SplashActivity.this, LoginActivity.class);
            } else {
              intent = new Intent(SplashActivity.this, TabLayoutActivity.class);
            }
          }

//          intent = new Intent(SplashActivity.this, LoginActivity.class);
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
