package com.example.demo3;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PolyInterface {
    @GET("/todos/1")
    Call<User>getUserByID(@Path("id") int id);


    @POST("/posts")
    Call<User>createrUser(@Body User user);
}
