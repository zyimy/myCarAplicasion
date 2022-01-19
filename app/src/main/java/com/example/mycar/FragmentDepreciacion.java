package com.example.mycar;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;

import java.util.ArrayList;
import java.util.Map;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentDepreciacion#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentDepreciacion extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private EditText anio, precio;
    private Button depreciacion;
    private  TextView txtMarca, txtModelo;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Fragment fragmentdepre;

    public FragmentDepreciacion() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentDepreciacion.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentDepreciacion newInstance(String param1, String param2) {
        FragmentDepreciacion fragment = new FragmentDepreciacion();
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
        return inflater.inflate(R.layout.fragment_depreciacion, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        anio = (EditText) view.findViewById(R.id.lblAnioDepre);
        precio = (EditText) view.findViewById(R.id.lblPrecioDepre);
        depreciacion = view.findViewById(R.id.btnDepreciacion);
        txtMarca = view.findViewById(R.id.lblMarcaDepre);
        txtModelo = view.findViewById(R.id.lblModeloDepre);

        txtMarca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarDialogoMarca();
            }
        });

        txtModelo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarDialogoModelo();
            }
        });


        depreciacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Bundle bundle = new Bundle();
                bundle.putString("anio", anio.getText().toString());
                bundle.putString("precio", precio.getText().toString());
                getParentFragmentManager().setFragmentResult("key", bundle);
                fragmentManager = getActivity().getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.contenedorMenu, new FragmentDepre());
                fragmentTransaction.commit();
            }
        });


    }


    public void mostrarDialogoMarca() {
        String array[] = {"Bmw", "Toyota", "Alfa Romeo", "Audi",
                "Fiat", "Ford", "Honda", "Volkswagen", "Volvo", "Peugeot", "Mazda", "Jeep"};

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Seleccionar Marca");
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialogo_modelo, null);
        builder.setView(view)


                .setSingleChoiceItems(array, 0, new DialogInterface.OnClickListener() {
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

    public void mostrarDialogoModelo() {

        String arrayModeloVolswagen[] = {"Touareg", "Toouran", "Tiguan", "Polo",
                "Passat", "Multivan", "Golf", "Amarok", "California", "Caravelle", "Sharan", "T-Cross"};


        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Seleccionar Modelo");
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialogo_modelo, null);
        builder.setView(view);


        builder.setSingleChoiceItems(arrayModeloVolswagen, 0, new DialogInterface.OnClickListener() {
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

}


