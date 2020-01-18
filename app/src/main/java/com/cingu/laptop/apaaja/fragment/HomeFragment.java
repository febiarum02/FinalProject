package com.cingu.laptop.apaaja.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.cingu.laptop.apaaja.R;
import com.cingu.laptop.apaaja.adapter.RvAdapterMenu;
import com.cingu.laptop.apaaja.api.MenuAPI;
import com.cingu.laptop.apaaja.api.RetrofitClient;
import com.cingu.laptop.apaaja.model.Response;

public class HomeFragment extends Fragment implements View.OnClickListener {

    private Button btn;
    private RecyclerView rv;
    private RvAdapterMenu rvAdapterMenu;
    private Retrofit retrofit;
    private MenuAPI service;

    public HomeFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        rvAdapterMenu = new RvAdapterMenu(getActivity());
        retrofit = RetrofitClient.connect();
        service = retrofit.create(MenuAPI.class);

        findView(v);
        initView();
        return v;
    }

    private Button findView(View v) {
        rv = v.findViewById(R.id.rv_home);
//        btn = v.findViewById(btn_order);
        return null;
    }

    private void initView() {
        rv.setHasFixedSize(true);
        rv.setAdapter(rvAdapterMenu);

        final Call<Response> request = service.getMenu( );
        request.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                rvAdapterMenu.setData(response.body().getKategori());
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });

        }

    @Override
    public void onClick(View v) {

    }
}
