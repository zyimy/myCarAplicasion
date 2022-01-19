package com.example.mycar.Cliente;

import com.example.mycar.Servicios.RetrofitApiCoche;
import com.example.mycar.Servicios.RetrofitApiService;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClienteCoche {

    public static final String URL_COCHE = "https://coches20210815233244.azurewebsites.net/api/coche/";
    private static Retrofit retrofit;
    public static RetrofitApiCoche getApiCoche(){
        if (retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(URL_COCHE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return retrofit.create(RetrofitApiCoche.class);
    }
}
