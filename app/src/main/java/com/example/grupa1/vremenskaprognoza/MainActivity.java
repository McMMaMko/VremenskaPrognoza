package com.example.grupa1.vremenskaprognoza;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Example w;
    TextView temp;
    TextView desc;
    EditText searchEditText;
    Button searchButton;
    TextView city;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        temp = findViewById(R.id.Temperature);
        searchEditText = findViewById(R.id.Searchbox);
        searchButton = findViewById(R.id.Dugme);
        desc = findViewById(R.id.Desc_Weather);
        city = findViewById(R.id.Place);
        searchButton.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherServise service = retrofit.create(WeatherServise.class);

        service.getWeather(searchEditText.getText().toString()).enqueue(new Callback<Example>() {
            @Override
            public void onResponse(Call<Example> call, Response<Example> response) {
                w = response.body();

                temp.setText(w.getMain().getTemp());
                desc.setText(w.getWeather().get(0).getDescription());
                city.setText(searchEditText.getText().toString());

                searchEditText.getText().clear();


            }

            @Override
            public void onFailure(Call<Example> call, Throwable t) {

                Log.e("Failed" , "Failed");

            }
        });
    }
}
