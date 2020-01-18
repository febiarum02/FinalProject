package com.cingu.laptop.apaaja.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cingu.laptop.apaaja.PreferenceLogin;
import com.cingu.laptop.apaaja.PreferenceRegis;
import com.cingu.laptop.apaaja.R;

public class RegisActivity extends AppCompatActivity {

    private Button btn_regis;
    EditText nama;
    EditText email;
    EditText username;
    EditText pass;
    PreferenceRegis instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regis);

        nama = (EditText) findViewById(R.id.et_nama);
        email = (EditText) findViewById(R.id.et_email);
        username = (EditText) findViewById(R.id.et_r_username);
        pass = (EditText) findViewById(R.id.et_r_password);
        instance = PreferenceRegis.getInstance(getApplicationContext());

        btn_regis = (Button) findViewById(R.id.regis);
        btn_regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    String namaRegis = nama.getText().toString();
                    String emailRegis = email.getText().toString();
                    String userRegis = username.getText().toString();
                    String passRegis = pass.getText().toString();
                    Toast.makeText(getApplicationContext(), "Berhasil Login", Toast.LENGTH_SHORT).show();
                    instance.setRegis(true);
                    instance.setNama(namaRegis);
                    instance.setEmail(emailRegis);
                    instance.setUser(userRegis);
                    instance.setPassR(passRegis);

                    startActivity(new Intent(RegisActivity.this, MainActivity.class));
                }
        });
    }
}
