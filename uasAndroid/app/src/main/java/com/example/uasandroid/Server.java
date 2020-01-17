package com.example.uasandroid;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Server {
    private  static final String url_base="http://192.168.42.155/uasphp/";

    private static Retrofit retrofit;

    public static Retrofit getClient(){

        if (retrofit ==null){
            retrofit=new Retrofit.Builder().baseUrl(url_base)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
