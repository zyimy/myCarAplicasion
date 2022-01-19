package com.example.mycar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mycar.Entidades.Coches;
import com.example.mycar.Entidades.JSONResponse;
import com.example.mycar.Servicios.RetrofitApiCoche;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MarcaCoche extends AppCompatActivity {

    private RecyclerView miRecicler;
    private RecyclerView.Adapter miAdapter;
    //private RetrofitApiCoche apiCoche;
    private List<Coches>listacoches;
    private Retrofit retrofit;
    private HttpLoggingInterceptor httpLoggingInterceptor;
    private OkHttpClient.Builder httpclientBuilder;
    private TextView mode,ver,carr;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marca_coche);


        lanzarPeticion(1);
        //SetupView();

        }

    public  void lanzarPeticion(int marca){
        //apiCoche =  RetrofitClienteCoche.getApiCoche();
        httpLoggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        httpclientBuilder = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor);
        retrofit = new Retrofit.Builder()
                .baseUrl("https://coches20210815233244.azurewebsites.net/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpclientBuilder.build())
                .build();

        RetrofitApiCoche request = retrofit.create(RetrofitApiCoche.class);

        Call<List<Coches>> call = request.getMarcaId(marca);
        call.enqueue(new Callback <List<Coches>>() {
            @Override
            public void onResponse(Call <List<Coches>> call, Response <List<Coches>> response) {
                List<Coches> listacoches = new ArrayList<>();
                listacoches = response.body();

                  /*String model = String.valueOf(coches.getModelo());
                    mode.setText("Golf");
                    ver.setText(response.body().getVersion());
                    carr.setText(response.body().getCarroceria());
                 */


                miRecicler = findViewById(R.id.rvMarcas);
                LinearLayoutManager layoutManager = new LinearLayoutManager(MarcaCoche.this);
                layoutManager.setOrientation(miRecicler.VERTICAL);
                miRecicler.setLayoutManager(layoutManager);
                miAdapter = new Adaptador(MarcaCoche.this,listacoches);
                miRecicler.setAdapter(miAdapter);



                //listacoches.add(new Coches(response.body().getModelos(), response.body().getVersion(), response.body().getCarroceria(),response.body().getImagenes()));



            }

            @Override
            public void onFailure(Call <List<Coches>> call, Throwable t) {

                Toast.makeText(MarcaCoche.this,t.getMessage(),Toast.LENGTH_LONG).show();

            }
        });



    }


       public void SetupView(){
        listacoches = new ArrayList<>();
        miAdapter = new Adaptador(MarcaCoche.this,listacoches);
        miRecicler = findViewById(R.id.rvMarcas);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(miRecicler.VERTICAL);
        miRecicler.setLayoutManager(layoutManager);
        miRecicler.setAdapter(miAdapter);
       }



    public void atras(View view){
        Intent intent = new Intent(this,Marcas.class);
        startActivity(intent);
    }



/*
    private void initValues(){
        apiCoche =  RetrofitClienteCoche.getApiCoche();
    }


    //Metodo para confirmar contraseña

    public  void getCoches(){

        apiCoche.getCoche().enqueue(new Callback<List<Coches>>() {
            @Override
            public void onResponse(Call <List<Coches>> call, Response<List<Coches>> response) {
              List<Coches>listacoches = response.body();

              for (Coches coches:listacoches){

                  String version = coches.getVersion().toString();
                  Coches coches1 = new Coches(version);



              }

                  ArrayAdapter<Coches>adapter = new ArrayAdapter<Coches>(MarcaCoche.this, android.R.layout.simple_dropdown_item_1line,listacoches);
                   modelo.setAdapter(adapter);

                        Toast.makeText(MarcaCoche.this,"Datos correctos",Toast.LENGTH_LONG).show();





            }

            @Override
            public void onFailure(Call<List<Coches>> call, Throwable t) {

                Toast.makeText(MarcaCoche.this,t.getMessage(),Toast.LENGTH_LONG).show();

            }
        });
    }
*/




}