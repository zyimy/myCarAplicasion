package com.example.mycar;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mycar.Entidades.Chasis;
import com.example.mycar.Servicios.RetrofitApiChasis;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class FragmentDatosTecnicos extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER


    private static final String sd = "suspension_delantera";
    private static final String st = "suspension_trasera";
    private static final String distanciaE = "distancia_ejes";
    private static final String velocidad = "velocidades";
    private static final String traccione = "traccion";
    private static final String neumaticoD = "neumatico_delantero";
    private static final String neumaticoT = "neumatico_trasero";
    private static final String cambio = "cambio_id";
    private static final String emision = "emisiones";
    private static final String consumourbano = "consumoUrbano";
    private static final String consumoextraurb = "consumoExtraUrbano";
    private static final String consumomedio = "consumoMedio";
    private static final String consumodeposito = "consumoDeposito";
    private static final String autonomiaaproximada = "autonomiaAproximada";
    private static final String velocidadmaxima = "velocidad_maxima";
    // TODO: Rename and change types of parameters


    private RecyclerView miRecicler;
    private RecyclerView.Adapter miAdapter;
    //private RetrofitApiCoche apiCoche;
    private ArrayList<String>lista = new ArrayList<String>();
    private ArrayList<Chasis>listachas;
    private Retrofit retrofit;
    private HttpLoggingInterceptor httpLoggingInterceptor;
    private OkHttpClient.Builder httpclientBuilder;
    ArrayAdapter adapter ;
    private  String suspension_delantera,suspension_trasera,distancia_ejes,velocidades,traccion,neumatico_delantero,
            neumatico_trasero,cambio_id,emisiones,consumoUrbano,consumoExtraUrbano,consumoMedio,consumoDeposito,autonomiaAproximada,velocidad_maxima;
    private Button vista;
    private String manual ="";



    public FragmentDatosTecnicos() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param suspension_delantera parameter1
     *
     * @return A new instance of fragment FragmentDatosTecnicos.
     */


    public static FragmentDatosTecnicos newInstance(String suspension_delantera,String suspension_trasera,String distancia_ejes,
            String velocidades, String traccion, String neumatico_delantero, String neumatico_trasero,String cambio_id,
                                                    String emisiones,String consumoUrbano, String consumoExtraUrbano,String consumoMedio,
                                                    String consumoDeposito, String autonomiaAproximada, String velocidad_maxima){

        FragmentDatosTecnicos fragmentDatosTecnicos = new FragmentDatosTecnicos();
        Bundle bundle = new Bundle();
        bundle.getString(sd,suspension_delantera);
        bundle.getString(st,suspension_trasera);
        bundle.getString(distanciaE,distancia_ejes);
        bundle.getString(velocidad,velocidades);
        bundle.getString(traccione,traccion);
        bundle.getString(neumaticoD,neumatico_delantero);
        bundle.getString(neumaticoT,neumatico_trasero);
        bundle.getString(cambio,cambio_id);
        bundle.getString(emision,emisiones);
        bundle.getString(consumourbano,consumoUrbano);
        bundle.getString(consumoextraurb,consumoExtraUrbano);
        bundle.getString(consumomedio,consumoMedio);
        bundle.getString(consumodeposito,consumoDeposito);
        bundle.getString(autonomiaaproximada,autonomiaAproximada);
        bundle.getString(velocidadmaxima,velocidad_maxima);



        fragmentDatosTecnicos.setArguments(bundle);
        return fragmentDatosTecnicos;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            suspension_delantera = getArguments().getString(sd);
            suspension_trasera = getArguments().getString(st);
            distancia_ejes = getArguments().getString(distanciaE);
            velocidades = getArguments().getString(velocidad);
            traccion = getArguments().getString(traccione);
            neumatico_delantero = getArguments().getString(neumaticoD);
            neumatico_trasero = getArguments().getString(neumaticoT);
            cambio_id = getArguments().getString(cambio);
            emisiones = getArguments().getString(emision);
            consumoUrbano = getArguments().getString(consumourbano);
            consumoExtraUrbano = getArguments().getString(consumoextraurb);
            consumoMedio = getArguments().getString(consumomedio);
            consumoDeposito = getArguments().getString(consumodeposito);
            autonomiaAproximada = getArguments().getString(autonomiaaproximada);
            velocidad_maxima = getArguments().getString(velocidadmaxima);




        }
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_datos_tecnicos, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((TextView)view.findViewById(R.id.lblMotorCilindrada)).setText(suspension_delantera);
        ((TextView)view.findViewById(R.id.lblSuspensionT)).setText(suspension_trasera);
        ((TextView)view.findViewById(R.id.lblDistanciaEjes)).setText(distancia_ejes);
        ((TextView)view.findViewById(R.id.lblVelocida)).setText(velocidades);
        ((TextView)view.findViewById(R.id.lblTraccion)).setText(traccion);
        ((TextView)view.findViewById(R.id.lblNeumaDelan)).setText(neumatico_delantero);
        ((TextView)view.findViewById(R.id.lblNeumaticosTrase)).setText(neumatico_trasero);
        ((TextView)view.findViewById(R.id.lblCambio)).setText("Manual");
        ((TextView)view.findViewById(R.id.lblEmisiones)).setText(emisiones);
        ((TextView)view.findViewById(R.id.lblConsumoUrbano)).setText(consumoUrbano);
        ((TextView)view.findViewById(R.id.lblConsumoExtraUrbano)).setText(consumoExtraUrbano);
        ((TextView)view.findViewById(R.id.lblConsumoMedio)).setText(consumoMedio);
        ((TextView)view.findViewById(R.id.lblConsumoDeposito)).setText(consumoDeposito);
        ((TextView)view.findViewById(R.id.lblAutonomiaAproximada)).setText(autonomiaAproximada);
        ((TextView)view.findViewById(R.id.lblVelocidadMaxima)).setText(velocidad_maxima);

    }



    public  void lanzarChasis(int coche){
        //apiCoche =  RetrofitClienteCoche.getApiCoche();
        httpLoggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        httpclientBuilder = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor);
        retrofit = new Retrofit.Builder()
                .baseUrl("https://chasis20210822172420.azurewebsites.net/api/chasi/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpclientBuilder.build())
                .build();

        RetrofitApiChasis request = retrofit.create(RetrofitApiChasis.class);

        Call<List<Chasis>> call = request.getCocheId(coche);
        call.enqueue(new Callback<List<Chasis>>() {
            @Override
            public void onResponse(Call <List<Chasis>> call, Response<List<Chasis>> response) {
                List<Chasis> listachasis = response.body();


                for (Chasis chasis:listachasis){

                    String suspension_delantera = chasis.getSuspension_delantera().toString();
                    String suspension_trasera = chasis.getSuspension_trasera().toString();
                    String distancia_ejes= chasis.getDistancia_ejes().toString();
                    String velocidades = chasis.getVelocidades().toString();
                    String traccion = chasis.getTraccion().toString();
                    String neumatico_delantero = chasis.getNeumatico_delantero().toString();
                    String neumatico_trasero = chasis.getNeumatico_trasero().toString();

                    //Chasis chasis1 = new Chasis(suspension_de,suspension_trasera,distanciaEjes,velocidad,traccion,neumaticoDelantero,neumaticoTrasero);


                   lista.add(suspension_trasera);
                   lista.add(distancia_ejes);
                   lista.add(velocidades);
                   lista.add(traccion);
                   lista.add(neumatico_delantero);
                   lista.add(neumatico_trasero);
                   lista.add("Manual");


                }


            }

            @Override
            public void onFailure(Call <List<Chasis>> call, Throwable t) {

                Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_LONG).show();

            }
        });



    }
}