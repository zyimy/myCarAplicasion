package com.example.mycar.Servicios;

import com.example.mycar.Entidades.Chasis;
import com.example.mycar.Entidades.Coches;

import java.util.HashMap;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitApiChasis {




    @GET("chasi")
    Call<List<Coches>>getCoche();

    @GET("coche/{id_coche}")
    Call<List<Chasis>>getCocheId(@Path("id_coche") int id_coche);
}
