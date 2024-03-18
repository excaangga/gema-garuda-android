package com.excaangga.gemagaruda.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.excaangga.gemagaruda.API.ApiClient;
import com.excaangga.gemagaruda.API.ApiService;
import com.excaangga.gemagaruda.R;
import com.excaangga.gemagaruda.Resources.LoginRequest;
import com.excaangga.gemagaruda.Resources.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button loginButton;
    private ApiClient apiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize EditText fields and Login button
        editTextEmail = findViewById(R.id.email);
        editTextPassword = findViewById(R.id.password);
        loginButton = findViewById(R.id.loginButton);

        // Initialize ApiClient
        apiClient = new ApiClient();

        // Set click listener for the Login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call method to handle login
                handleLogin();
            }
        });
    }

    private void handleLogin() {
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();

        // Make API call for login
        apiClient.loginUser(email, password, new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    LoginResponse data = response.body();
                    // Handle successful login response
                    Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_LONG).show();
                } else {
                    // Handle failed login response
                    Toast.makeText(MainActivity.this, "Login failed", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                // Handle failure
                Toast.makeText(MainActivity.this, "Network error", Toast.LENGTH_LONG).show();
            }
        });
    }
}