package com.cingu.laptop.apaaja.fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.cingu.laptop.apaaja.PreferenceLogin;
import com.cingu.laptop.apaaja.PreferenceRegis;
import com.cingu.laptop.apaaja.R;
import com.cingu.laptop.apaaja.activity.LoginActivity;
import com.cingu.laptop.apaaja.activity.MainActivity;

import java.util.prefs.Preferences;

public class UserFragment extends Fragment {
    PreferenceLogin login;
    private Button bt_logout;
    private TextView tv_user;

    public UserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_user, container, false);
        login = PreferenceLogin.getInstance(getActivity().getApplicationContext());
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv_user = view.findViewById(R.id.tv_user_user);
        bt_logout = view.findViewById(R.id.btn_logout);

        tv_user.setText(login.getName());
        bt_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login.setLogin(false);
                getActivity().finish();
                getActivity().startActivity(new Intent(getContext(), LoginActivity.class));
            }
        });
    }
}
