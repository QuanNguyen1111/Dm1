package com.example.thithu2;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.thithu2.Model.ModelAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView tvTextview;
    private Api api;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTextview = (TextView) findViewById(R.id.tvTextview);

        Gson gson = new GsonBuilder().serializeNulls().create();

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://reqres.in/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();

        api = retrofit.create(Api.class);


//        final ProgressDialog progressDialog;
//        progressDialog = new ProgressDialog(MainActivity.this);
//        progressDialog.setMax(100);
//        progressDialog.setMessage("Its loading....");
//        progressDialog.setTitle("ProgressDialog bar example");
//        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
//        // show it
//        progressDialog.show();
//        getTodo(progressDialog);


//        final Handler handler = new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                // Do something after 5s = 5000ms
//                startActivity(new Intent(MainActivity.this , MainActivity2.class));
//            }
//        }, 5000);

    }

    private void getTodo(ProgressDialog progressDialog){
        Call<ModelAPI> callModelApi = api.getModeAPI();

        callModelApi.enqueue(new Callback<ModelAPI>() {
            @Override
            public void onResponse(Call<ModelAPI> call, Response<ModelAPI> response) {
                if (!response.isSuccessful()) {
                    tvTextview.setText("code ; " + response.code());
                }
                ModelAPI modelAPI = response.body();
                tvTextview.append(modelAPI.toString() + " code : "+ response.code());
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<ModelAPI> call, Throwable t) {
                tvTextview.setText("code " + t.getMessage());
                progressDialog.dismiss();
            }
        });

    }

}