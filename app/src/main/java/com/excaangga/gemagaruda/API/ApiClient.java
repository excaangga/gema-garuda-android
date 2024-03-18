package com.excaangga.gemagaruda.API;

import com.excaangga.gemagaruda.Resources.LoginRequest;
import com.excaangga.gemagaruda.Resources.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static final String BASE_URL = "http://192.168.43.58:8001/api/";
    private ApiService apiService;

    public ApiClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);
    }

    public void loginUser(String email, String password, Callback<LoginResponse> callback) {
        LoginRequest request = new LoginRequest(email, password);
        Call<LoginResponse> call = apiService.loginUser(request);
        call.enqueue(callback);
    }
}
