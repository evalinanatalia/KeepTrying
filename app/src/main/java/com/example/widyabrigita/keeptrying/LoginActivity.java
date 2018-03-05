package com.example.widyabrigita.keeptrying;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.widyabrigita.keeptrying.Model.Login;
import com.example.widyabrigita.keeptrying.Model.Track;
import com.example.widyabrigita.keeptrying.Network.NetworkService;
import com.example.widyabrigita.keeptrying.Remote.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
  private SessionUser sessionUser;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    sessionUser = new SessionUser();

    TextView textView = (TextView) findViewById(R.id.text_register);
    textView.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
        startActivity(intent);
      }

    });

    Button button = (Button)findViewById(R.id.btn_login);
    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        NetworkService service = RetrofitClient.getClient().create(NetworkService.class);
        Call<Login> call = service.postLogin();

        call.enqueue(new Callback<Login>() {
          @Override
          public void onResponse(Call<Login> call, Response<Login> response) {
            sessionUser.setSession(LoginActivity.this, "login");
            Intent intent = new Intent(LoginActivity.this, TabLayoutActivity.class);
            startActivity(intent);
            finish();
          }

          @Override
          public void onFailure(Call<Login> call, Throwable t) {
            Toast.makeText(LoginActivity.this, "gagal",Toast.LENGTH_LONG).show();
          }
        });

      }
    });

    TextView textGetHelp = (TextView) findViewById(R.id.text_get_help);
    textGetHelp.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        final Dialog dialog = new Dialog(LoginActivity.this);
        dialog.setContentView(R.layout.dialog_email);

        Button dialogButton = (Button) dialog.findViewById(R.id.btn_submit);
        dialogButton.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
            dialog.dismiss();
          }
        });

        dialog.show();
      }

    });

  }

}
