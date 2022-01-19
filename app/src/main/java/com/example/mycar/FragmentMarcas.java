package com.example.mycar;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mycar.Entidades.Coches;
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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentMarcas#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentMarcas extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private TextView txtlist,txtmarcas,txtmodelo,txtversion,txtanio;
    private Retrofit retrofit;
    private RecyclerView miRecicler;
    private RecyclerView.Adapter miAdapter;
    private HttpLoggingInterceptor httpLoggingInterceptor;
    private OkHttpClient.Builder httpclientBuilder;
    private TextView mode,ver,carr,lblcochesBd,lblModelodialogo,txtModelo,
            txtVersionDialogos,lblVersionD,txtanioD,lblAnioD,resultVersion,comprobar;
    ArrayAdapter<String> adapter;
    ArrayAdapter<String> adapterVersion;
    ArrayList<String> listaModelo = new ArrayList<String>();
    ArrayList<String> listaMarca = new ArrayList<String>();
    ArrayList<String> listaVersion = new ArrayList<>();
    List<Coches> listaversionBase = new ArrayList<>();
    private Button btnbuscarversion;



    public FragmentMarcas() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentMarcas.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentMarcas newInstance(String param1, String param2) {
        FragmentMarcas fragment = new FragmentMarcas();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_marcas, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        txtlist = view.findViewById(R.id.lblMarcaprimerCoche);
        lblModelodialogo = view.findViewById(R.id.lblModeloPrimerCoche);
        txtmarcas = view.findViewById(R.id.txtMarcasDialogoPrimerCoche);
        txtModelo = view.findViewById(R.id.txtModeloDialogoPrimerCoche);
        txtVersionDialogos = view.findViewById(R.id.txtVersionDialogoPrimerCoche);
        lblVersionD = view.findViewById(R.id.lblVersionDialogoPrimerCoche);
        lblAnioD = view.findViewById(R.id.lblAnioPrimerCoche);
        txtanioD = view.findViewById(R.id.txtAnioDialogoPrimerCoche);
        miRecicler = view.findViewById(R.id.rvVewbuscar);
        btnbuscarversion = view.findViewById(R.id.btnBuscarVersionesSegundo);






            lblModelodialogo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                        mostrarDialogoModelo();

                }
            });

            lblAnioD.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mostrarDialogoAnio();
                }
            });

        lblVersionD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               lanzarCoche();
               mostrarDialogoVersion();


            }
        });

        txtlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 mostrarDialogoMarca();
            }
        });

        btnbuscarversion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int converAnio = Integer.parseInt(txtanioD.getText().toString());


                lanzarVersion(1,txtModelo.getText().toString(),txtVersionDialogos.getText().toString(),converAnio);


            }
        });



    }

    public void mostrarDialogoMarca(){
        String array[]={"Bmw","Toyota", "Alfa Romeo",	"Audi",
                "Fiat", "Ford","Honda","Volkswagen","Volvo","Peugeot","Mazda","Jeep"};



        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Seleccionar Marca");
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialogo_modelo,null);
        builder.setView(view)


        .setSingleChoiceItems( array, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
              txtmarcas.setText(array[which]);
            }
        })

        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {



            }
        })
        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });


         builder.create().show();


    }

    public void mostrarDialogoModelo(){

        String arrayModeloVolswagen[]={"Touareg","Toouran", "Tiguan","Polo",
                "Passat", "Multivan","Golf","Amarok","California","Caravelle","Sharan","T-Cross"};


        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Seleccionar Modelo");
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialogo_modelo,null);
        builder.setView(view);


                           builder.setSingleChoiceItems( arrayModeloVolswagen, 0, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            txtModelo.setText(arrayModeloVolswagen[which]);

                        }
                    })

                            .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })
                            .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            });


                    builder.create().show();

    }


    public void mostrarDialogoVersion(){


        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        adapterVersion = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,listaVersion);
        builder.setTitle("Seleccionar Version");
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialogo_modelo,null);
        builder.setView(view)


                .setSingleChoiceItems( adapterVersion, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        txtVersionDialogos.setText(adapterVersion.getItem(which));
                    }
                })

                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });


        builder.create().show();


    }


    public void mostrarDialogoAnio(){

        String anio[]={"2010","2011", "2012","2013",
                "2014", "2015","2016","2017","2018","2019","2020","2021"};


        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Seleccionar Año");
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialogo_modelo,null);
        builder.setView(view);


        builder.setSingleChoiceItems( anio, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                txtanioD.setText(anio[which]);

            }
        })

                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });


        builder.create().show();

    }




    public  void lanzarCoche(){
        //apiCoche =  RetrofitClienteCoche.getApiCoche();
        httpLoggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        httpclientBuilder = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor);
        retrofit = new Retrofit.Builder()
                .baseUrl("https://coches20210815233244.azurewebsites.net/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpclientBuilder.build())
                .build();

        RetrofitApiCoche request = retrofit.create(RetrofitApiCoche.class);

        Call<List<Coches>> call = request.getCoche();
        call.enqueue(new Callback<List<Coches>>() {
            @Override
            public void onResponse(Call <List<Coches>> call, Response<List<Coches>> response) {
                List<Coches>  listacarro = response.body();
               if (response.isSuccessful()){
                   for (Coches coches:listacarro){


                       listaVersion.add(coches.getVersion());


                   }




               }else {

                   Toast.makeText(getContext(),"No hay respuesta",Toast.LENGTH_LONG).show();

               }



              adapterVersion.notifyDataSetChanged();




                  /*String model = String.valueOf(coches.getModelo());
                    mode.setText("Golf");
                    ver.setText(response.body().getVersion());
                    carr.setText(response.body().getCarroceria());
                 */






                //listacoches.add(new Coches(response.body().getModelos(), response.body().getVersion(), response.body().getCarroceria(),response.body().getImagenes()));



            }

            @Override
            public void onFailure(Call <List<Coches>> call, Throwable t) {

                Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_LONG).show();

            }
        });



    }

    public  void lanzarVersion(int marca_id,String modelo,String version,int anio){
        //apiCoche =  RetrofitClienteCoche.getApiCoche();
        httpLoggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        httpclientBuilder = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor);
        retrofit = new Retrofit.Builder()
                .baseUrl("https://coches20210815233244.azurewebsites.net/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpclientBuilder.build())
                .build();

        RetrofitApiCoche request = retrofit.create(RetrofitApiCoche.class);

        Call<List<Coches>> call = request.getVersionId(marca_id,modelo,version,anio);
        call.enqueue(new Callback <List<Coches>>() {
            @Override
            public void onResponse(Call <List<Coches>> call, Response <List<Coches>> response) {

               List<Coches> listaversionBase = response.body();




                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                layoutManager.setOrientation(miRecicler.VERTICAL);
                miRecicler.setLayoutManager(layoutManager);
                miAdapter = new Adaptador(getContext(),listaversionBase);
                miRecicler.setAdapter(miAdapter);

                  /*String model = String.valueOf(coches.getModelo());
                    mode.setText("Golf");
                    ver.setText(response.body().getVersion());
                    carr.setText(response.body().getCarroceria());



                miRecicler = findViewById(R.id.rvMarcas);
                LinearLayoutManager layoutManager = new LinearLayoutManager(MarcaCoche.this);
                layoutManager.setOrientation(miRecicler.VERTICAL);
                miRecicler.setLayoutManager(layoutManager);
                miAdapter = new Adaptador(MarcaCoche.this,listacoches);
                miRecicler.setAdapter(miAdapter);

           */

                //listacoches.add(new Coches(response.body().getModelos(), response.body().getVersion(), response.body().getCarroceria(),response.body().getImagenes()));



            }

            @Override
            public void onFailure(Call <List<Coches>> call, Throwable t) {

                Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_LONG).show();

            }
        });



    }




}