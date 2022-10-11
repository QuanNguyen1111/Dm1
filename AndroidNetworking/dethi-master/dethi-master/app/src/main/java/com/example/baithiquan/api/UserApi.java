package com.example.baithiquan.api;


import com.example.baithiquan.model.ListUser;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserApi {
    @GET("api/users")
    Call<ListUser> getListUser(
            @Query("page") int page
    );
}
