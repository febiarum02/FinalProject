package com.cingu.laptop.apaaja.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cingu.laptop.apaaja.PreferenceLogin;
import com.cingu.laptop.apaaja.R;

public class LoginActivity extends AppCompatActivity {

    EditText UserLogin, PassLogin;
    PreferenceLogin userSession;
    private Button btn_signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        UserLogin = (EditText) findViewById(R.id.et_username);
        PassLogin = (EditText) findViewById(R.id.et_password);

        userSession = PreferenceLogin.getInstance(getApplicationContext());

        btn_signin = (Button) findViewById(R.id.btn_signin);
        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String User = UserLogin.getText().toString();
                    String Pass = PassLogin.getText().toString();
                    Toast.makeText(getApplicationContext(), "Berhasil Login", Toast.LENGTH_SHORT).show();
                    userSession.setLogin(true);
                    userSession.setName(User);
                    userSession.setPass(Pass);

                    finish();
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                }
            });
    }
}
