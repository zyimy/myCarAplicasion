package com.example.mycar.Servicios;

import com.example.mycar.Entidades.Coches;
import com.example.mycar.Entidades.JSONResponse;

import java.util.HashMap;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitApiCoche {

    @POST("coche")
    Call<ResponseBody> getIngresarCoche(@Body HashMap<Object, Object> map);


    @GET("coche")
    Call<List<Coches>>getCoche();

    @GET("coche/marca/{marca_Id}")
    Call<List<Coches>>getMarcaId(@Path("marca_Id") int marca_Id);

    @GET("coche/{marca_id}/{modelo}/{version}/{anio}")
    Call<List<Coches>>getVersionId(@Path("marca_id") int marca_id,
                                   @Path("modelo") String modelo,
                                   @Path("version") String version,
                                   @Path("anio") int anio);

}
