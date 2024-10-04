package com.example.demoapi.data.apiServices;

import com.example.demoapi.data.model.GetAllProducts;
import com.example.demoapi.data.model.GetLoginUserData;
import com.example.demoapi.data.model.GetSignUpUserdata;
import com.example.demoapi.data.model.LoginUserData;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface ApiServices {
@POST("api/v1/auth/login")
    Call<GetLoginUserData>getLoginUser(@Body LoginUserData data);

@POST("api/v1/users/")
    Call<GetSignUpUserdata>getnewCreatedUser(Body GetSignUpUserdatacreatedUser);

@GET("api/v1/products/")
    Call<List<GetAllProducts>>getAllProducts();
}
