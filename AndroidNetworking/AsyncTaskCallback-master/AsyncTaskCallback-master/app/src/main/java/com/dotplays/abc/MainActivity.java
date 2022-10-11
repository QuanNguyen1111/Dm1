package com.dotplays.abc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ImageView imge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tvText);
        imge = findViewById(R.id.imageView);

        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        findViewById(R.id.button).setOnClickListener(view -> {
            String link = "https://freetuts.net/upload/tut_post/images/2021/06/26/4037/anh-nen-doremon-de-thuong-1.jpg";
            ImageLoader loader = new ImageLoader();
            loader.setImageListener(new ImageListener<Bitmap>() {
                @Override
                public void start() {
                     progressDialog.show();
                     progressDialog.setMessage("Loading...");
                }

                @Override
                public void finish(Bitmap o) {
                     progressDialog.dismiss();
                     imge.setImageBitmap(o);
                }
            });
            loader.execute(link);
        });

    }
}