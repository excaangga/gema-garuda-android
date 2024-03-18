package com.excaangga.gemagaruda.Resources;

import com.google.gson.annotations.SerializedName;

public class LoginData {
    @SerializedName("token")
    private String token;

    @SerializedName("refresh_token")
    private String refreshToken;

    public String getToken() {
        return token;
    }

    public String getRefreshToken() {
        return refreshToken;
    }
}
