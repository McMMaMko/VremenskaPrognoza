package com.example.grupa1.vremenskaprognoza;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WeatherServise {
    @GET("/data/2.5/weather?q=London,uk&appid=996f141951689e2d30423b503c20c9d7")
    Call<Example> getWeather();
}
