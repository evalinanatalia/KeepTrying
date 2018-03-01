package com.example.widyabrigita.keeptrying;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by BRI on 2/26/2018.
 */

public class SplashScreenActivity  extends AppCompatActivity {
    private ProgressBar mProgress;
    private int mProgressStatus = 0;

    private Handler mHandler = new Handler();
    private String version;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Intent historyIntent = new Intent(this, TabLayoutActivity.class);
        startActivity(historyIntent);

    }
}
