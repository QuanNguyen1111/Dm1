package com.example.demo2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    //demo http get Request
    String get = "https://jsonplaceholder.typicode.com/posts/1";

    //demo http Post Request
    String post ="https://jsonplaceholder.typicode.com/posts";
//    param
//    body: JSON.stringify({
//        title: 'foo',
//                body: 'bar',
//                userId: 1,
//    }),
//    headers: {
//        'Content-type': 'application/json; charset=UTF-8',
//    },
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tvKQ);

        findViewById(R.id.btnGet).setOnClickListener( view -> {
            Httpreques loader = new Httpreques(tv);
            loader.execute(get);
        });

        findViewById(R.id.btnPost).setOnClickListener( view -> {
            Httpreques loader = new Httpreques(tv);
            loader.execute(post);
        });

    }
}