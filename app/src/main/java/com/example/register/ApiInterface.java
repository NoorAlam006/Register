package com.example.register;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiInterface
{
    //@POST("register")
   /* Call<RegisterResponse>  getregister(@Body RegisterRequest registerRequest);*/

    @POST("register")
    Call<RegisterResponse> getresponse(@Body RegisterRequest registerRequest);

}
