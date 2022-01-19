package com.example.mycar;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentDepre#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentDepre extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private PieChart pieChart;
    ArrayList<String> valoresx = new ArrayList<>();
    ArrayList<Entry> valoresy = new ArrayList<>();
    ArrayList<Integer> colores = new ArrayList<>();



    public FragmentDepre() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentDepre.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentDepre newInstance(String param1, String param2) {
        FragmentDepre fragment = new FragmentDepre();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_depre, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getParentFragmentManager().setFragmentResultListener("key", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle bundle) {

                String anio = bundle.getString("anio");
                String precio = bundle.getString("precio");

                System.out.println(anio);
                pieChart = view.findViewById(R.id.pieGrafico);

                pieChart.setHoleRadius(40f);
                pieChart.setDrawXValues(true);
                pieChart.setDrawYValues(true);
                pieChart.setRotationEnabled(true);
                pieChart.animateXY(1500, 1500);




                int numeroAnio = Integer.parseInt(anio);
                int numeroPrecio = Integer.parseInt(precio);
                int resultado = 2021-numeroAnio;

/*
                valoresy.add(new Entry((numeroPrecio * 10)/100-numeroPrecio,1));
                valoresy.add(new Entry((numeroPrecio * 10)/100-numeroPrecio,2));
                valoresy.add(new Entry((numeroPrecio * 10)/100-numeroPrecio,3));
                valoresy.add(new Entry((numeroPrecio * 10)/100-numeroPrecio,4));
                valoresy.add(new Entry((numeroPrecio * 10)/100-numeroPrecio,5));
                valoresy.add(new Entry((numeroPrecio * 10)/100-numeroPrecio,6));
                valoresy.add(new Entry((numeroPrecio * 10)/100-numeroPrecio,7));

*/
                int totalDepre = 0;
              int suma = 0;
                int detalle = (numeroPrecio*16)/100;
                valoresy.add(new Entry(detalle,0));
               for (int i = 0;i<resultado-1;i++){

                   detalle =  (numeroPrecio*10)/100;

                   valoresy.add(new Entry(detalle,i));

                   suma = suma+detalle;
               }

                totalDepre = suma+detalle;

                System.out.println(suma+detalle);

               int valorCoche = numeroPrecio-totalDepre;

                valoresx.add("2014");
                valoresx.add("2015");
                valoresx.add("2016");
                valoresx.add("2017");
                valoresx.add("2018");
                valoresx.add("2019");
                valoresx.add("2020");
                valoresx.add("2021");








                colores.add(getResources().getColor(R.color.color_proyecto));
                colores.add(getResources().getColor(R.color.colorPrimary));
                colores.add(getResources().getColor(R.color.colorAccent));

                colores.add(getResources().getColor(R.color.color_proyecto));
                colores.add(getResources().getColor(R.color.colorPrimary));
                colores.add(getResources().getColor(R.color.colorAccent));

                colores.add(getResources().getColor(R.color.color_proyecto));
                colores.add(getResources().getColor(R.color.colorPrimary));


                PieDataSet set = new PieDataSet(valoresy, "resultados");
                set.setSliceSpace(5f);
                set.setColors(colores);

                PieData data = new PieData(valoresx, set);
                pieChart.setData(data);
                pieChart.highlightValues(null);
                pieChart.invalidate();

                pieChart.setDescription("Total Depreciacion: "+totalDepre+"\n"+"€"+" Valor del Coche: "+valorCoche+"€");
                pieChart.setDescriptionTextSize(3.3f);

                pieChart.setDrawLegend(true);

            }
        });





    }
}