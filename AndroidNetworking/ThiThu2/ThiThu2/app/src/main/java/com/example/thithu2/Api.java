package com.example.thithu2;

import com.example.thithu2.Model.ModelAPI;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("api/users?page=1")
    Call<ModelAPI> getModeAPI();

}
