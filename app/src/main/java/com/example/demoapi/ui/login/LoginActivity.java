package com.example.demoapi.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.demoapi.R;
import com.example.demoapi.data.model.GetLoginUserData;
import com.example.demoapi.data.model.LoginUserData;
import com.example.demoapi.data.retrofitClient.RetrofitClient;
import com.example.demoapi.databinding.ActivityLoginBinding;
import com.example.demoapi.ui.home.HomeActivity;
import com.example.demoapi.ui.signUp.SignUpActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {
private ActivityLoginBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       
        setContentView(R.layout.activity_login);

        binding=ActivityLoginBinding.inflate(getLayoutInflater());
        View view=binding.getRoot();
        setContentView(view);

        binding.account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
            }
        });
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=binding.emailET.getText().toString();
                String password=binding.passwordET.getText().toString();

                LoginUserData data=new LoginUserData();
                data.setEmail(email);
                data.setPassword(password);

                RetrofitClient.getInstance().getLoginUser(data).enqueue(new Callback<GetLoginUserData>() {
                    @Override
                    public void onResponse(Call<GetLoginUserData> call, Response<GetLoginUserData> response) {

                        Toast.makeText(LoginActivity.this, response.message(), Toast.LENGTH_SHORT).show();

                        if (response.isSuccessful()&& response.body()!=null){
                            startActivity(new Intent(LoginActivity.this, HomeActivity.class));

                        }
                    }

                    @Override
                    public void onFailure(Call<GetLoginUserData> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "error", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
    }
}