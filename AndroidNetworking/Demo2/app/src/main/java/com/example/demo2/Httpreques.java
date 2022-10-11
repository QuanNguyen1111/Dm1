package com.example.demo2;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;
import android.widget.TextView;
import android.os.AsyncTask;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Httpreques extends AsyncTask<String, Integer ,String >{

    private TextView tvKq;
    public Httpreques (TextView tvKq){
        this.tvKq = tvKq;
    }

    @Override
    protected String doInBackground(String... strings) {
        String link = strings[0];
        try{
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
            OutputStream outputStream = connection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
//            String json = "{\n"+
//            "        title: 'foo',\n"+
//            "         body: 'bar',\n "+
//            "        userId: 1,\n "+
//            "        }";
            StringBuffer request = new StringBuffer();
            request.append("title=").append("foo");
            request.append("&body=").append("Nguyen Quan");
            request.append("&userId=").append("12345");

            bufferedWriter.append(request);
            bufferedWriter.flush();
            outputStream.close();
            bufferedWriter.close();



            InputStream in = connection.getInputStream();
            Scanner scanner = new Scanner(in);
            StringBuffer data = new StringBuffer();
            while (scanner.hasNext())data.append(scanner.nextLine());
            scanner.close();
            return data.toString();

        }catch (MalformedURLException e){
            e.printStackTrace();
            Log.e("ABC","Link Khong hop le");
        }catch (IOException e){
            e.printStackTrace();
            Log.e("ABC","khong the ket  loi");
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        ArrayList<NguoiDung> nguoiDungs=new ArrayList<>();
    try {
        JSONArray array= new JSONArray(s);
        for(int i=0 ;i< array.length();i++){
        //lau ra phan tu Jsonobiej ttrog array
            JSONObject item= array.getJSONObject(i);
//            int id= item.getInt("id");
//            int userId= item.getInt("userId");
//            String title =item.getString("title");
//            String body = item.getString("body");
//            NguoiDung nguoiDung=new NguoiDung(id,userId,title,body);
            NguoiDung nguoiDung=new Gson().fromJson(item.toString(),NguoiDung.class);
            nguoiDungs.add(nguoiDung);
        }
        Log.e("SIZE",String.valueOf(nguoiDungs.size()));
    }
        catch (JSONException e){
        e.printStackTrace();

        }
        tvKq.setText(s);
    }
}
