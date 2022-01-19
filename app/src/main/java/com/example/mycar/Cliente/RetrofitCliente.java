package com.example.mycar.Cliente;

import com.example.mycar.Servicios.RetrofitApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitCliente {

    public static final String URL_BASE = "https://registrarse20210803225910.azurewebsites.net/api/";

    private static Retrofit retrofit;

    public static RetrofitApiService getApiService(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(RetrofitApiService.class);
    }


}
