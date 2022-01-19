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
import android.widget.LinearLayout;
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
 * Use the {@link FragmentComparar#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentComparar extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private TextView marca,modelo,version,anio,marcaS,modeloS,versionS,anioS,cocheuno,cochedos,comprueba,
            precioCocheUno,consMedioCocheDos,consuMedioCocheUno,precioCocheDos,tituloDiferencia,ahorro,tituloPrecio,
    emisionesCocheUno,emisionesCocheDos,potenciaCocheUno,potenciaCocheDos,velocidadMaxiCocheUno,velocidadMaxiCocheDos;
    private EditText txtMarca,txtModelo,txtVersion,txtAnio,txtMarcaS,txtModeloS,txtVersionS,txtAnioS;
    private Button buscar;
    private Retrofit retrofit;
    private RecyclerView miRecicler,miRecliclerdos;
    private RecyclerView.Adapter miAdapter,adapterSegundo;
    private HttpLoggingInterceptor httpLoggingInterceptor;
    private OkHttpClient.Builder httpclientBuilder;
    private LinearLayout contenedor,contenedorChecked;
    ArrayAdapter<String> adapter;
    ArrayAdapter<String> adapterSegundos;
    ArrayAdapter<String> adapterVersion;
    ArrayAdapter<String> adapterVersionSegundo;
    ArrayList<String> listaVersion = new ArrayList<>();
    ArrayList<String> listaVersionSegundo = new ArrayList<>();



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentComparar() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentComparar.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentComparar newInstance(String param1, String param2) {
        FragmentComparar fragment = new FragmentComparar();
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
        return inflater.inflate(R.layout.fragment_comparar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        marca = view.findViewById(R.id.lblMarcaprimerCoche);
        modelo = view.findViewById(R.id.lblModeloPrimerCoche);
        version = view.findViewById(R.id.lblVersionDialogoPrimerCoche);
        anio = view.findViewById(R.id.lblAnioPrimerCoche);
        txtMarca = view.findViewById(R.id.txtMarcasDialogoPrimerCoche);
        txtModelo = view.findViewById(R.id.txtModeloDialogoPrimerCoche);
        txtVersion = view.findViewById(R.id.txtVersionDialogoPrimerCoche);
        txtAnio = view.findViewById(R.id.txtAnioDialogoPrimerCoche);
  //segundo
        marcaS = view.findViewById(R.id.lblMarcaSegundoCoche);
        modeloS = view.findViewById(R.id.lblModeloDialogoSegundo);
        versionS = view.findViewById(R.id.lblVersionDialogoSegundo);
        anioS = view.findViewById(R.id.lblAnioDSegundo);
        txtMarcaS = view.findViewById(R.id.txtMarcasDialogoSegundo);
        txtModeloS = view.findViewById(R.id.txtModeloDialogoSegundo);
        txtVersionS = view.findViewById(R.id.txtVersionDialogoSegundo);
        txtAnioS = view.findViewById(R.id.txtAnioDialogoSegundo);
        buscar = view.findViewById(R.id.btnBuscarVersionesSegundo);
        miRecicler = view.findViewById(R.id.rvCompararDos);
        miRecliclerdos = view.findViewById(R.id.rvComparar);
        tituloDiferencia = view.findViewById(R.id.lblTituloDiferencias);
        cocheuno = view.findViewById(R.id.lblCocheUno);
        cochedos = view.findViewById(R.id.lblCocheDos);
        contenedor = (LinearLayout)view.findViewById(R.id.contanedorComparar);
        contenedorChecked = (LinearLayout)view.findViewById(R.id.contenedorCheck);
        ahorro = view.findViewById(R.id.lblAhorro);
        precioCocheUno = view.findViewById(R.id.lblPrecioCocheDos);
        precioCocheDos = view.findViewById(R.id.lblPrecioCocheUno);
        consuMedioCocheUno= view.findViewById(R.id.lblConsumoMedioCocheUno);
        consMedioCocheDos= view.findViewById(R.id.lblConsumoMedioCocheCocheDos);
        tituloPrecio = view.findViewById(R.id.lblTituloPrecio);
        emisionesCocheUno = view.findViewById(R.id.lblEmisionesCocheUno);
        emisionesCocheDos = view.findViewById(R.id.lblEmisionesCocheDos);
        potenciaCocheUno = view.findViewById(R.id.lblPotenciaCocheUno);
        potenciaCocheDos = view.findViewById(R.id.lblPotenciaCocheDos);
        velocidadMaxiCocheUno = view.findViewById(R.id.lblVelocidadMaximaCoUno);
        velocidadMaxiCocheDos = view.findViewById(R.id.lblVelocidadMaxCoDos);



        cocheuno.setVisibility(View.INVISIBLE);
        cochedos.setVisibility(View.INVISIBLE);
        ahorro.setVisibility(View.INVISIBLE);
        tituloDiferencia.setVisibility(View.INVISIBLE);
        tituloPrecio.setVisibility(View.INVISIBLE);


        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int converAnio = Integer.parseInt(txtAnio.getText().toString());
                int converAnioS = Integer.parseInt(txtAnioS.getText().toString());
                lanzarVersion(1,txtModelo.getText().toString(),txtVersion.getText().toString(),converAnio);
                lanzarVersionDos(1,txtModeloS.getText().toString(),txtVersionS.getText().toString(),converAnioS);
                cocheuno.setVisibility(View.VISIBLE);
                cochedos.setVisibility(View.VISIBLE);
                ahorro.setVisibility(View.VISIBLE);
                tituloDiferencia.setVisibility(View.VISIBLE);
                tituloPrecio.setVisibility(View.VISIBLE);

                ahorro.setText("Ahorro");
                cocheuno.setText("Coche 1");
                cochedos.setText("Coche 2");




            }
        });


        marca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentMarcas fragmentMarcas = new FragmentMarcas();

                mostrarDialogoMarca();
            }
        });

        modelo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarDialogoModelo();
            }
        });

        version.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                lanzarCoche();
                mostrarDialogoVersion();
            }
        });

        anio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarDialogoAnio();
            }
        });

        marcaS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarDialogoMarcaSegundo();
            }
        });

        modeloS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarDialogoModeloSegundo();
            }
        });

        versionS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzarCocheSegundo();
                mostrarDialogoVersionSegundo();
            }
        });

        anioS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarDialogoAnioSegundo();
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
                        txtMarca.setText(array[which]);
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
                        txtVersion.setText(adapterVersion.getItem(which));
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
                txtAnio.setText(anio[which]);

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

    public void mostrarDialogoVersionSegundo(){


        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        adapterVersionSegundo = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1,listaVersionSegundo);
        builder.setTitle("Seleccionar Version");
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialogo_modelo,null);
        builder.setView(view)


                .setSingleChoiceItems( adapterVersionSegundo, 0, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        txtVersionS.setText(adapterVersionSegundo.getItem(which));
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


    public void mostrarDialogoMarcaSegundo(){
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
                        txtMarcaS.setText(array[which]);
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

    public void mostrarDialogoModeloSegundo(){

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
                txtModeloS.setText(arrayModeloVolswagen[which]);

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





    public void mostrarDialogoAnioSegundo(){

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
                txtAnioS.setText(anio[which]);

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
            }
            @Override
            public void onFailure(Call <List<Coches>> call, Throwable t) {
                Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }

    public  void lanzarCocheSegundo(){
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

                        listaVersionSegundo.add(coches.getVersion());


                    }
                }else {
                    Toast.makeText(getContext(),"No hay respuesta",Toast.LENGTH_LONG).show();
                }
                adapterVersionSegundo.notifyDataSetChanged();
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

                for (Coches coches:listaversionBase){
                    String precio = coches.getPvp().toString();
                    precioCocheUno.setText(precio+"€");
                    String conMedio = coches.getConsumoMedio();
                    consuMedioCocheUno.setText(conMedio);
                    String emisiones = coches.getEmisiones();
                    emisionesCocheUno.setText(emisiones);
                    String potencia = coches.getPotenciaMaxima();
                    potenciaCocheUno.setText(potencia);
                    String velocidad = coches.getVelocidad_maxima();
                    velocidadMaxiCocheUno.setText(velocidad);

                }


                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                layoutManager.setOrientation(miRecicler.VERTICAL);
                miRecicler.setLayoutManager( layoutManager);
                adapterSegundo = new AdaptadorComparar( getContext(),listaversionBase);
                miRecicler.setAdapter(adapterSegundo);
            }

            @Override
            public void onFailure(Call <List<Coches>> call, Throwable t) {

                Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_LONG).show();

            }
        });





    }

    public  void lanzarVersionDos(int marca_id,String modelo,String version,int anio){
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

                List<Coches> listaversionSegundo = response.body();

                for (Coches coches:listaversionSegundo){
                    String precio = coches.getPvp().toString();
                    precioCocheDos.setText(precio+"€");
                    String conMedio = coches.getConsumoMedio();
                    consMedioCocheDos.setText(conMedio);
                    String emisiones = coches.getEmisiones();
                    emisionesCocheDos.setText(emisiones);
                    String potencia = coches.getPotenciaMaxima();
                    potenciaCocheDos.setText(potencia);
                    String velocidad = coches.getVelocidad_maxima();
                    velocidadMaxiCocheDos.setText(velocidad);

                }
                LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
                layoutManager.setOrientation(miRecliclerdos.VERTICAL);
                miRecliclerdos.setLayoutManager(layoutManager);
                adapterSegundo= new AdaptadorComparar(getContext(), listaversionSegundo);
                miRecliclerdos.setAdapter(adapterSegundo);
            }

            @Override
            public void onFailure(Call <List<Coches>> call, Throwable t) {

                Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_LONG).show();

            }
        });



    }




}