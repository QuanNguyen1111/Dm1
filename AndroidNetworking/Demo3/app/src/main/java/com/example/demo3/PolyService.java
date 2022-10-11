package com.example.demo3;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PolyService {

    public  static Retrofit retrofit;
    public  static  Retrofit getInstance(){
        if  ( retrofit == null){
             retrofit = new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")// thiet lap doan ma retonpit se requet
                    .addConverterFactory(GsonConverterFactory.create())// add thu vien hoc Json cho retonfit
                    .build();
        }
        return retrofit;
    }
}
