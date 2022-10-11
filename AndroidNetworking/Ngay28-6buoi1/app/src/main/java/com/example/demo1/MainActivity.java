package com.example.demo1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button button;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.tv_id);
        button = findViewById(R.id.button);
        imageView = findViewById(R.id.imageView);

        findViewById(R.id.button).setOnClickListener(view -> {
            String link = "https://freetuts.net/upload/tut_post/images/2021/06/26/4037/anh-nen-doremon-de-thuong-1.jpg";
            ImageLoader loader = new ImageLoader(imageView);
            loader.execute(link);
        });
    }
}

//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                AsyncTask task = new AsyncTask() {
//                    @Override
//                    protected Object doInBackground(Object[] objects) {
//                        try {
//                            String link = "https://vn.images.search.yahoo.com/search/images;_ylt=AwrxywKw1LpiiAQAOjJrUwx.;_ylu=Y29sbwNzZzMEcG9zAzEEdnRpZAMEc2VjA3BpdnM-?p=img&fr2=piv-web&type=E210VN91215G0&fr=mcafee#id=2&iurl=http%3A%2F%2Fwww.tandemconstruction.com%2Fsites%2Fdefault%2Ffiles%2Fstyles%2Fproject_slider_main%2Fpublic%2Fimages%2Fproject-images%2FIMG-Student-Union_6.jpg%3Fitok%3DSIO_SJym&action=click";
//                            URL url = new URL(link);
//                            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//                            InputStream stream = connection.getInputStream();
//                            Bitmap bitmap = BitmapFactory.decodeStream(stream);
//                            return bitmap;
//                        }catch (Exception e){
//
//                        }
//                        return null;
//                    }
//
//                    @Override
//                    protected void onPostExecute(Object o) {
//                        super.onPostExecute(o);
//                        Bitmap bitmap = (Bitmap) o;
//                        imageView.setImageBitmap(bitmap);
//                    }
//                };
//                task.execute();
//            }
//        });
//    }
//}
