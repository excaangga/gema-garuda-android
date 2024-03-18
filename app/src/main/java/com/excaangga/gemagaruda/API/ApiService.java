package com.excaangga.gemagaruda.API;

import com.excaangga.gemagaruda.Resources.LoginRequest;
import com.excaangga.gemagaruda.Resources.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
//    @POST("register")
//    Call<LoginResource> registerUser(@Body LoginResource user);

    @POST("login")
    Call<LoginResponse> loginUser(@Body LoginRequest request);
}
