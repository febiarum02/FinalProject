package com.cingu.laptop.apaaja.api;

import com.cingu.laptop.apaaja.model.Response;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MenuAPI {

    @GET("db.json")
    Call<Response> getMenu();

}
