package com.example.hw_6_5_m.data.network;

import com.example.hw_6_5_m.data.entity.LoveModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface LoveApi {

    @GET("getPercentage")
    Call<LoveModel> calculate(@Query("fname") String firstName,
                              @Query("sname") String secondName,
                              @Header("X-RapidAPI-Key") String key,
                              @Header("X-RapidAPI-Host") String host);
}
