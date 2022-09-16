package com.example.register;

import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit
{
    private static retrofit2.Retrofit retrofit;
    private static final String Baseurl= "https://rebliss.in/sfa/api/";

    public static retrofit2.Retrofit getRetrofit()
    {
        if(retrofit==null)
        {
            retrofit = new  retrofit2.Retrofit.Builder().baseUrl(Baseurl).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;

    }

   /* public static retrofit2.Retrofit getRetrofit()
    {
        if(retrofit==null)
        {
            retrofit= new retrofit2.Retrofit.Builder().baseUrl(Baseurl).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }*/




}
