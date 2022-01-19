package com.example.mycar;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmenMotor#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmenMotor extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String cilindro = "cilindrada";
    private static final String numero_cilindro = "numeroCilindros";
    private static final String diametros = "diametro";
    private static final String carreras = "carrera";
    private static final String posicionM = "posiscionMotor";
    private static final String orientacionM = "orientacionMotor";
    private static final String ratioC = "ratioComprension";
    private static final String tipoA = "tipoAdmision";
    private static final String numeroV = "numeroValvulas";
    private static final String compresores = "compresor";
    private static final String intercoler = "intercooler";
    private static final String potenciaM = "potenciaMaxima";
    private static final String rpmPM = "rpmPotenciaMaxima";
    private static final String parM = "parMaximo";
    private static final String rpmAParM = "rpmAParMaximo";


    // TODO: Rename and change types of parameters
    private String cilindrada, numeroCilindros,diametro,carrera,posicionMotor,orientacionMotor,ratioComprension,
                   tipoAdmision,numeroValvulas,compresor,intercooler,potenciaMaxima,rpmPotenciaMaxima,parMaximo,rpmAParMaximo;


    public FragmenMotor() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     * @return A new instance of fragment FragmenMotor.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmenMotor newInstance(String cilindrada, String numeroCilindros, String diametro, String carrera, String posicionMotor,
                                           String orientacionMotor, String ratioComprension, String tipoAdmision, String numeroValvulas,
                                           String compresor, String intercooler, String potenciaMaxima,String rpmPotenciaMaxima, String parMaximo,
                                           String rpmAParMaximo) {
        FragmenMotor fragment = new FragmenMotor();
        Bundle args = new Bundle();
        args.putString(cilindro, cilindrada);
        args.putString(numero_cilindro, numeroCilindros);
        args.putString(diametros, diametro);
        args.putString(carreras, carrera);
        args.putString(posicionM, posicionMotor);
        args.putString(orientacionM, orientacionMotor);
        args.putString(cilindro, cilindrada);
        args.putString(ratioC, ratioComprension);
        args.putString(tipoA, tipoAdmision);
        args.putString(numeroV, numeroValvulas);
        args.putString(cilindro, cilindrada);
        args.putString(compresores, compresor);
        args.putString(cilindro, cilindrada);
        args.putString(intercoler,intercooler );
        args.putString(potenciaM, potenciaMaxima);
        args.putString(rpmPM, rpmPotenciaMaxima);
        args.putString(parM, parMaximo);
        args.putString(rpmAParM, rpmAParMaximo);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            cilindrada = getArguments().getString(cilindro);
            numeroCilindros = getArguments().getString(numero_cilindro);
            diametro = getArguments().getString(diametros);
            carrera = getArguments().getString(carreras);
            posicionMotor = getArguments().getString(posicionM);
            orientacionMotor = getArguments().getString(orientacionM);
            ratioComprension = getArguments().getString(ratioC);
            tipoAdmision = getArguments().getString(tipoA);
            numeroValvulas = getArguments().getString(numeroV);
            compresor = getArguments().getString(compresores);
            intercooler = getArguments().getString(intercoler);
            potenciaMaxima = getArguments().getString(potenciaM);
            rpmPotenciaMaxima = getArguments().getString(rpmPM);
            parMaximo = getArguments().getString(parM);
            rpmAParMaximo = getArguments().getString(rpmAParM);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragmen_motor, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ((TextView)view.findViewById(R.id.lblMotorCilindrada)).setText(cilindrada);
        ((TextView)view.findViewById(R.id.lblNumeroCilindro)).setText(numeroCilindros);
        ((TextView)view.findViewById(R.id.lblCarrera)).setText(carrera);
        ((TextView)view.findViewById(R.id.lblPosicionMotor)).setText(posicionMotor);
        ((TextView)view.findViewById(R.id.lblOrientacionMotor)).setText(orientacionMotor);
        ((TextView)view.findViewById(R.id.lblRatioComprencion)).setText(ratioComprension);
        ((TextView)view.findViewById(R.id.lblTipoAdmision)).setText(tipoAdmision);
        ((TextView)view.findViewById(R.id.lblNumeroValvulas)).setText(numeroValvulas);
        ((TextView)view.findViewById(R.id.lblCompresor)).setText(compresor);
        ((TextView)view.findViewById(R.id.lblIntercoler)).setText(intercooler);
        ((TextView)view.findViewById(R.id.lblPotenciaMaxima)).setText(potenciaMaxima);
        ((TextView)view.findViewById(R.id.lblRpmPotenciaMaxima)).setText(rpmPotenciaMaxima);
        ((TextView)view.findViewById(R.id.lblParMaximo)).setText(parMaximo);
        ((TextView)view.findViewById(R.id.lblRpmAparMaximo)).setText(rpmAParMaximo);
    }
}