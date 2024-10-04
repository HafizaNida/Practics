package com.example.demoapi.data.retrofitClient;

import com.example.demoapi.data.apiServices.ApiServices;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public static final String Base_URL="https://api.escuelajs.co/";
    public static ApiServices apiServices = null;

    public static ApiServices getInstance(){
        if(apiServices==null){
            apiServices=new Retrofit.Builder()
                    .baseUrl(Base_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ApiServices.class);
        }
        return apiServices;
    }
}

