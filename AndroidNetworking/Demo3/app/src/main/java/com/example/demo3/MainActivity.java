package com.example.demo3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button btnGet;
    private Button btnPost;
    private TextView tvKetQua;

    String get = "https://jsonplaceholder.typicode.com/todos/1";
    String post = "https://jsonplaceholder.typicode.com/posts";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnGet = findViewById(R.id.btnGet);
        btnPost = findViewById(R.id.btnPost);
        tvKetQua = findViewById((R.id.tv_ketqua));

        btnGet.setOnClickListener(view -> {

            Callback<User> userCallback = new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {

                    User user = response.body();
                    Toast.makeText(MainActivity.this,response.body().getTitle(),Toast.LENGTH_SHORT).show();
                    tvKetQua.setText(user.getTitle());
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {

                    Toast.makeText(MainActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();
                }
            };
            PolyService.getInstance().create(PolyInterface.class).getUserByID(199).enqueue(userCallback);
        });

        btnPost.setOnClickListener(view -> {

            Callback<User> userCallback = new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {

                    User user = response.body();
                    Toast.makeText(MainActivity.this,response.body().getTitle(),Toast.LENGTH_SHORT).show();
                    tvKetQua.setText(user.getTitle());
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {

                    Toast.makeText(MainActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();
                }
            };
            User user=new User(3,2,"Quan Quan Quan",true);
            PolyService.getInstance().create(PolyInterface.class).createrUser(user).enqueue(userCallback);
        });


    }


}