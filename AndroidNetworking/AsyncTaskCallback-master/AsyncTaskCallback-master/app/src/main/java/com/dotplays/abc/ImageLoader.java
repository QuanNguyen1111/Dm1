package com.dotplays.abc;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class ImageLoader extends AsyncTask<String, Integer, Bitmap> {

    ImageView imageView;

    public ImageLoader(ImageView imageView) {
        this.imageView = imageView;
    }

    public ImageLoader() {
    }

    public ImageListener imageListener;

    public void setImageListener(ImageListener imageListener) {
        this.imageListener = imageListener;
        imageListener.start();
    }

    @Override
    protected Bitmap doInBackground(String... strings) {
        try {
            String link = strings[0];
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            InputStream stream = connection.getInputStream();
            // chuyen doi stream sang kieu Bitmap.
            Bitmap bitmap = BitmapFactory.decodeStream(stream);
            return bitmap;
        } catch (Exception e) {

        }
        return null;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        //imageView.setImageBitmap(bitmap);
        imageListener.finish(bitmap);
    }
}
