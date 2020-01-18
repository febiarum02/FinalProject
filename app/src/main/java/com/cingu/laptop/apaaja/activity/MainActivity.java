package com.cingu.laptop.apaaja.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.cingu.laptop.apaaja.PreferenceLogin;
import com.cingu.laptop.apaaja.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonLogin;
    private Button buttonRegis;
    PreferenceLogin userSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userSession = PreferenceLogin.getInstance(getApplicationContext());
        if (userSession.isLogin()){
            finish();
            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
        }

        buttonLogin = (Button) findViewById(R.id.btn_login);
        buttonRegis = (Button) findViewById(R.id.btn_regis);

        buttonLogin.setOnClickListener(this);
        buttonRegis.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_login:
                Intent i=new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(i);
                break;
            case R.id.btn_regis:
                Intent a=new Intent(getApplicationContext(),RegisActivity.class);
                startActivity(a);
                break;
        }
    }
}
