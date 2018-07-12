package com.example.grupa1.vremenskaprognoza;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WeatherServise {
    @GET("/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22")
    Call<Example> getWeather();
}
