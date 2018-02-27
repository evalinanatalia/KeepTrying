package com.example.widyabrigita.keeptrying;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

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
        Intent intent = new Intent(LoginActivity.this, AccountActivity.class);
        startActivity(intent);
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
