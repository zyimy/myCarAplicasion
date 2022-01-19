package com.example.mycar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class DatosCoches extends AppCompatActivity {


    FragmentTransaction transaction;
    Fragment frDatosTecnicos, frMotor;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_coches);

         frDatosTecnicos = new FragmentDatosTecnicos();
         frMotor = new FragmenMotor();



        Bundle bundle = getIntent().getExtras();
        String images = bundle.getString("imagenes");
        String model = bundle.getString("modelo");
        String vers = bundle.getString("version");
        String carroce = bundle.getString("carroceria");
        String ani = bundle.getString("anio");
        String combust = bundle.getString("combustible");
        String puert = bundle.getString("puertas");
        String plazashomologadas = bundle.getString("plazasHomologadas");
        String acabad = bundle.getString("acabado");
        String precio = bundle.getString("pvp");

        // Cambio y chasis

         String sd = bundle.getString("suspension_delantera");
         String st = bundle.getString("suspension_trasera");
         String distanciaE = bundle.getString("distancia_ejes");
         String velocidad = bundle.getString("velocidades");
         String traccion = bundle.getString("traccion");
         String neumaticoD = bundle.getString("neumatico_delantero");
         String neumaticoT = bundle.getString("neumatico_trasero");
         String cambio = bundle.getString("cambio_id");

         //Motor

        String cilindro = bundle.getString("cilindrada");
        String numero_cilindro = bundle.getString("numeroCilindros");
        String diametro = bundle.getString("diametro");
        String carrera = bundle.getString("carrera");
        String posicionM = bundle.getString("posiscionMotor");
        String OrientacionM = bundle.getString("orientacionMotor");
        String ratioC = bundle.getString("ratioComprension");
        String tipoA = bundle.getString("tipoAdmision");
        String numeroV = bundle.getString("numeroValvulas");
        String compresor = bundle.getString("compresor");
        String intercooler = bundle.getString("intercooler");
        String potenciaM = bundle.getString("potenciaMaxima");
        String rpmPM = bundle.getString("rpmPotenciaMaxima");
        String parM = bundle.getString("parMaximo");
        String rpmAParM = bundle.getString("rpmAParMaximo");

        //Chasis

        String emision = bundle.getString("emisiones");
        String consumourbano = bundle.getString("comsumoUrbano");
        String consumoextraurbano = bundle.getString("ConsumoExtraUrbano");
        String consumomedio = bundle.getString("consumoMedio");
        String consumodepo = bundle.getString("consumoDeposito");
        String autonomiaAprox = bundle.getString("autonomiaAproximada");
        String velocidadMaxi = bundle.getString("velocidad_maxima");






     /*
        resuCoche.setText(model+"\n"+vers+"\n"+carroce+"\n"+ani+"\n"+
                combust+"\n"+puert+"\n"+
                plazashomologadas+"\n"+acabad+"\n"+precio);
       */

        InformacionCoche fragment = new InformacionCoche();

        fragment.setArguments(bundle);
        frDatosTecnicos.setArguments(bundle);
        frMotor.setArguments(bundle);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.contenedorFragments,fragment)
                .commit();


    }

      public void seleccion(View view){

        transaction = getSupportFragmentManager().beginTransaction();

        switch (view.getId()){
            case R.id.btnChasis:
                 transaction.replace(R.id.contenedorFragments,frDatosTecnicos);
                 transaction.addToBackStack(null);

                break;

            case R.id.btnMotor:
                transaction.replace(R.id.contenedorFragments,frMotor);
                transaction.addToBackStack(null);

                break;


        }
        transaction.commit();
      }

    public void volverAtras(View view) {
        Intent intent = new Intent(DatosCoches.this.getBaseContext(), MarcaCoche.class);
        startActivity(intent);

    }
}