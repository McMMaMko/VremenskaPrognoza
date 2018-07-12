package com.example.grupa1.vremenskaprognoza;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WeatherServise {
    @GET("/data/2.5/weather?appid=57a1eb16a020293ee73630799720c1e5")
    Call<Example> getWeather(@Query("q") String city);
}
