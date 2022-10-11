package com.example.demo1;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class ImageLoader extends AsyncTask<String, Integer, Bitmap> {


    ImageView imageView;
    public ImageLoader(ImageView imageView){
        this.imageView= imageView;
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        try{
            String link =strings[0];
            URL url = new URL(link);
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            InputStream stream = connection.getInputStream();
            Bitmap bitmap= BitmapFactory.decodeStream(stream);
            return bitmap;

        } catch (Exception e){

        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
    }
}
