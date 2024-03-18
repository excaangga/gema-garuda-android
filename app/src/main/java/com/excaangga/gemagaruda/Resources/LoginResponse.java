package com.excaangga.gemagaruda.Resources;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("success")
    private boolean success;

    @SerializedName("data")
    private LoginData data;

    @SerializedName("message")
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public LoginData getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }
}

