package com.cingu.laptop.apaaja;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceRegis {

    private static PreferenceRegis INSTANCE;
    private SharedPreferences sharedPreferences;

    private PreferenceRegis(Context context){
        sharedPreferences = context
                .getApplicationContext()
                .getSharedPreferences("simple.android.app", Context.MODE_PRIVATE);
    }

    public static PreferenceRegis getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = new PreferenceRegis(context);
        }
        return INSTANCE;
    }

    public SharedPreferences Pref(){
        return sharedPreferences;
    }

    public Boolean isRegis(){
        return sharedPreferences.getBoolean("isRegis", false);
    }

    public void setRegis(Boolean isRegis) {
        sharedPreferences.edit().putBoolean("isRegis", isRegis).apply();
    }

    public void setNama(String namaRegis) {
        sharedPreferences.edit().putString("namaRegis", namaRegis).apply();
    }

    public String getNama(){
        return sharedPreferences.getString("namaRegis", " ");
    }

    public void setEmail(String emailRegis) {
        sharedPreferences.edit().putString("emailRegis", emailRegis).apply();
    }

    public String getEmail(){
        return sharedPreferences.getString("emailRegis", " ");
    }

    public void setUser(String userRegis) {
        sharedPreferences.edit().putString("userRegis", userRegis).apply();
    }

    public String getUser(){
        return sharedPreferences.getString("userRegis", " ");
    }

    public void setPassR(String passRegis) {
        sharedPreferences.edit().putString("rPass", passRegis).apply();
    }

    public String getPassR(){
        return sharedPreferences.getString("rPass", " ");
    }
}
