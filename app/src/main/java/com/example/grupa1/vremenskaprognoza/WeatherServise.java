package com.example.grupa1.vremenskaprognoza;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WeatherServise {
    @GET("/data/2.5/weather?q=Sarajevo&appid=996f141951689e2d30423b503c20c9d7")
    Call<Example> getWeather();
//@Query("q") String city
}
