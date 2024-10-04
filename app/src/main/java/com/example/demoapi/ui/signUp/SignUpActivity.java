package com.example.demoapi.ui.signUp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.InputQueue;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.demoapi.R;
import com.example.demoapi.data.model.GetSignUpUserdata;
import com.example.demoapi.data.retrofitClient.RetrofitClient;
import com.example.demoapi.databinding.ActivitySignUpBinding;
import com.example.demoapi.ui.home.HomeActivity;
import com.example.demoapi.utils.SharedPref;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Body;

public class SignUpActivity extends AppCompatActivity {
    private ActivitySignUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sign_up);

        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.fullNameET.getText().toString();
                String email = binding.emailET.getText().toString();
                String password = binding.passwordET.getText().toString();

                //              String img=""
                GetSignUpUserdata getSignUpUserdata = new GetSignUpUserdata();
                getSignUpUserdata.getError();
                getSignUpUserdata.getMessage();
                getSignUpUserdata.getStatusCode();

                RetrofitClient.getInstance().getnewCreatedUser((Body) getSignUpUserdata).enqueue(new Callback<GetSignUpUserdata>() {
                    @Override
                    public void onResponse(Call<GetSignUpUserdata> call, Response<GetSignUpUserdata> response) {
                        SharedPref.saveObject(SignUpActivity.this,"userData",response.body());
                        startActivity(new Intent(SignUpActivity.this,HomeActivity.class));
                        Toast.makeText(SignUpActivity.this, response.message(),
                                Toast.LENGTH_SHORT).show();

                        if (response.isSuccessful() && response.body() != null) {
                            startActivity(new Intent(SignUpActivity.this, HomeActivity.class));
                        }
                    }

                    @Override
                    public void onFailure(Call<GetSignUpUserdata> call, Throwable t) {
                    }
                });
            }
        });
    }
}