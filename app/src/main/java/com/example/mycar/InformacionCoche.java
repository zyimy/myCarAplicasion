package com.example.mycar;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import technolifestyle.com.imageslider.FlipperLayout;
import technolifestyle.com.imageslider.FlipperView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InformacionCoche#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InformacionCoche extends Fragment {
    private static final String images = "imagenes";
    private static final String model = "modelo";
    private static final String vers = "version";
    private static final String carroce = "carroceria";
    private static final String ani = "anio";
    private static final String combust = "combustible";
    private static final String puert = "puertas";
    private static final String plazashomologadas = "plazasHomologadas";
    private static final String acabad = "acabado";
    private static final String precio = "pvp";


    private   FlipperLayout flipperLayout;

    ViewFlipper viewFlipper;



    private  String imagenes, modelo,version,carroceria,anio,combustible,puertas,plazasHomologadas,acabado,pvp;

    public InformacionCoche() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     *
     * @param modelo parameter1
     * @return A new instance of fragment InformacionCoche.
     */
    // TODO: Rename and change types and number of parameters
    public static InformacionCoche newInstance(String imagenes, String modelo, String version, String carroceria, String anio, String combustible
    ,String puertas, String plazasHomologadas, String acabado, String pvp) {
        InformacionCoche fragment = new InformacionCoche();
        Bundle bundle = new Bundle();
        bundle.getString(images,imagenes);
         bundle.getString(model,modelo);
         bundle.getString(vers,version);
         bundle.getString(carroce,carroceria);
         bundle.getString(ani,anio);
         bundle.getString(combust,combustible);
         bundle.getString(puert,puertas);
         bundle.getString(plazashomologadas,plazasHomologadas);
         bundle.getString(acabad,acabado);
         bundle.getString(precio,pvp);


        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            imagenes = getArguments().getString(images);
            modelo = getArguments().getString(model);
            version = getArguments().getString(vers);
            carroceria = getArguments().getString(carroce);
            anio = getArguments().getString(ani);
            combustible = getArguments().getString(combust);
            puertas = getArguments().getString(puert);
            plazasHomologadas = getArguments().getString(plazashomologadas);
            acabado = getArguments().getString(acabad);
            pvp = getArguments().getString(precio);


        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_informacion_coche, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       viewFlipper = view.findViewById(R.id.Fliper);
        int[]misImagenes = new int[]  {R.drawable.golf7,R.drawable.golf9,R.drawable.golf10,R.drawable.golf11,
        R.drawable.golf12};

       for (int image: misImagenes){
           fliperImages(image);
       }
        //((ImageView)view.findViewById(R.id.imgInformacionCoches)).toString();
        ((TextView)view.findViewById(R.id.lblModelo)).setText(modelo);
        ((TextView)view.findViewById(R.id.lblVersion)).setText(version);
        ((TextView)view.findViewById(R.id.lblCarrocerias)).setText(carroceria);
        ((TextView)view.findViewById(R.id.lblAnios)).setText(anio);
        ((TextView)view.findViewById(R.id.lblCombustibles)).setText(combustible);
        ((TextView)view.findViewById(R.id.lblPuertas)).setText(puertas);
        ((TextView)view.findViewById(R.id.lblPlazasHomologadas)).setText(plazasHomologadas);
        ((TextView)view.findViewById(R.id.lblAcabado)).setText(acabado);
        ((TextView)view.findViewById(R.id.lblPvp)).setText(pvp);
    }

    public void fliperImages(int imagen){
        ImageView imageView = new ImageView(getContext());
        imageView.setBackgroundResource(imagen);
        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);

        viewFlipper.setInAnimation(getContext(), android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(getContext(), android.R.anim.slide_out_right);
    }


}