package com.example.widyabrigita.keeptrying;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class AccountActivity extends AppCompatActivity {

  Button btnLogout, btnEdit, btnChangePwd;
  private SessionUser sessionUser;

  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_account);

    sessionUser = new SessionUser();

    btnLogout = (Button)findViewById(R.id.btn_logout);
    btnLogout.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        sessionUser.setSession(AccountActivity.this, "");
        Intent intent = new Intent(AccountActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
      }

    });

    btnEdit = (Button)findViewById(R.id.btn_edit_profile);
    btnEdit.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(AccountActivity.this, EditProfileActivity.class);
        startActivity(intent);
      }
    });

    btnChangePwd = (Button)findViewById(R.id.btn_change_pwd);
    btnChangePwd.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Intent intent = new Intent(AccountActivity.this, ResetPasswordActivity.class);
        startActivity(intent);
      }
    });

  }
}
