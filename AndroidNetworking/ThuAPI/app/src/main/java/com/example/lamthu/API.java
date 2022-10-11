package com.example.lamthu;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public interface API {

    // Link API:https://batdongsanabc.000webhostapp.com/mob403lab4/getall.json?fbclid=IwAR1l5EBVGZyaazzBpE_vjawavvNkPc017Lt1FF8CdWDgtDxx4KfOZapUeHE

    @GET("mob403lab4/getall.json")
    Call<Products> productsVnd();

}
