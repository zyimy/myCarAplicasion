package com.example.mycar.Servicios;

import com.example.mycar.Entidades.Coches;
import com.example.mycar.Entidades.Personas;

import java.util.HashMap;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitApiService {
    @POST("persona")
    Call<ResponseBody> getIngresar(@Body HashMap<Object, Object> map);


    @GET("persona")
    Call<List<Personas>>getPersona();

    @GET("persona/{correo_electronico}/{contrasena}")
    Call<List<Personas>>getPersonaId(@Path("correo_electronico") String correo_electronico,
                                     @Path("contrasena") String contrasena);




}
