package com.example.grupa1.vremenskaprognoza;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Example w;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        final TextView temp = findViewById(R.id.Temperature);
        final TextView desc = findViewById(R.id.Desc_Weather);
        final TextView city = findViewById(R.id.Place);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://samples.openweathermap.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherServise service = retrofit.create(WeatherServise.class);

        service.getWeather().enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                w = response.body();
                temp.setText(w.getMain().getTemp());
                desc.setText(w.getWeather().get(0).getDescription());


            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

                Log.e("Failed" , "Failed");

            }
        });

    }
}
