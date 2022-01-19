package com.example.mycar;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycar.Entidades.Chasis;
import com.example.mycar.Entidades.Coches;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {
    private List<Coches>listacoches;
    private int posicion;

    private Context context;

    public Adaptador(Context context, List<Coches> listacoches) {
        this.listacoches = listacoches;
        this.context = context;

    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_datos,parent,false);

        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder ;
    }

    @Override



    public void onBindViewHolder(ViewHolder holder, int position) {


     String modelos = listacoches.get(position).getModelos();
     //String modelos = String.valueOf(modelo);
    holder.txtmodel.setText(modelos);
    String version  = listacoches.get(position).getVersion();
    holder.txtversi.setText(version);
    String carroceria = listacoches.get(position).getCarroceria();
    holder.txtcarroce.setText(carroceria);
    String anio = listacoches.get(position).getAnio();
    holder.txtanio.setText(anio);

    String combustibles = listacoches.get(position).getCombustibles();
    holder.txtcombustible.setText(combustibles);
        Picasso.Builder builder = new Picasso.Builder(context);
        builder.build().load(listacoches.get(position).getImagenes())
                .placeholder(R.drawable.golf7)
                .error(R.drawable.golf7)
                .into(holder.imagen);

         holder.vista.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                int posicion = holder.getAdapterPosition();
              String image = listacoches.get(posicion).getImagenes();
              String model = listacoches.get(posicion).getModelos();
              String vers = listacoches.get(posicion).getVersion();
              String carroce = listacoches.get(posicion).getCarroceria();
              String ani = listacoches.get(posicion).getAnio();
              String combust = listacoches.get(posicion).getCombustibles();
              String door = listacoches.get(posicion).getPuertas();
              String plazahomologadas = listacoches.get(posicion).getPlazasHomologadas();
              String acabad = listacoches.get(posicion).getAcabado();
              String precio = listacoches.get(posicion).getPvp();
              String sd = listacoches.get(posicion).getSuspension_delantera();
              String st = listacoches.get(posicion).getSuspension_trasera();
              String distanciaEjes = listacoches.get(posicion).getDistancia_ejes();
              String velocidad = listacoches.get(posicion).getVelocidades();
              String traccion = listacoches.get(posicion).getTraccion();
              String neumaticoD = listacoches.get(posicion).getNeumatico_delantero();
              String neumaticoT = listacoches.get(posicion).getNeumatico_trasero();
              String cambio = listacoches.get(posicion).getCambio_id();

              //Motor

              String cilindro = listacoches.get(posicion).getCilindrada();
              String numero_cilindro = listacoches.get(posicion).getNumeroCilindros();
              String diametro = listacoches.get(posicion).getDiametro();
              String carrera = listacoches.get(posicion).getCarrera();
              String posicion_motor = listacoches.get(posicion).getPosicionMotor();
              String orientacionM = listacoches.get(posicion).getOrientacionMotor();
              String ratioC = listacoches.get(posicion).getRatioComprension();
              String tipoA = listacoches.get(posicion).getTipoAdmision();
              String numeroV = listacoches.get(posicion).getNumeroValvulas();
              String compresor = listacoches.get(posicion).getCompresor();
              String intercoler = listacoches.get(posicion).getCompresor();
              String potenciaM = listacoches.get(posicion).getPotenciaMaxima();
              String rpmPotenciaM = listacoches.get(posicion).getRpmPotenciaMaxima();
              String parMaximo = listacoches.get(posicion).getParMaximo();
              String rpmAParM = listacoches.get(posicion).getRpmAParMaximo();


              //Emisiones

                 String emision = listacoches.get(posicion).getEmisiones();
                 String consumourbano = listacoches.get(posicion).getConsumoUrbano();
                 String cosumoExUrbano = listacoches.get(posicion).getConsumoExtraUrbano();
                 String consumomedio = listacoches.get(posicion).getConsumoMedio();
                 String consumoDepo = listacoches.get(posicion).getConsumoDeposito();
                 String autonomiaAproxi = listacoches.get(posicion).getAutonomiaAproximada();
                 String velocidadMaxi = listacoches.get(posicion).getVelocidad_maxima();











                 Intent intent = new Intent(context,DatosCoches.class);
                 intent.putExtra("imagenes",image);
                 intent.putExtra("modelo",model);
                 intent.putExtra("version",vers);
                 intent.putExtra("carroceria",carroce);
                 intent.putExtra("anio",ani);
                 intent.putExtra("combustible",combust);
                 intent.putExtra("puertas",door);
                 intent.putExtra("plazasHomologadas",plazahomologadas);
                 intent.putExtra("acabado",acabad);
                 intent.putExtra("pvp",precio);
                 intent.putExtra("suspension_delantera",sd);
                 intent.putExtra("suspension_trasera",st);
                 intent.putExtra("distancia_ejes",distanciaEjes);
                 intent.putExtra("velocidades",velocidad);
                 intent.putExtra("traccion",traccion);
                 intent.putExtra("neumatico_delantero",neumaticoD);
                 intent.putExtra("neumatico_trasero",neumaticoT);
                 intent.putExtra("cambio_id",cambio);

                 //Motor

                 intent.putExtra("cilindrada",cilindro);
                 intent.putExtra("numeroCilindros",numero_cilindro);
                 intent.putExtra("diametro",diametro);
                 intent.putExtra("carrera",carrera);
                 intent.putExtra("posiscionMotor",posicion_motor);
                 intent.putExtra("orientacionMotor",orientacionM);
                 intent.putExtra("ratioComprension",ratioC);
                 intent.putExtra("tipoAdmision",tipoA);
                 intent.putExtra("numeroValvulas",numeroV);
                 intent.putExtra("compresor",compresor);
                 intent.putExtra("intercooler",intercoler);
                 intent.putExtra("potenciaMaxima",potenciaM);
                 intent.putExtra("rpmPotenciaMaxima",rpmPotenciaM);
                 intent.putExtra("parMaximo",parMaximo);
                 intent.putExtra("rpmAParMaximo",rpmAParM);

                 // Emisiones

                 intent.putExtra("emisiones",emision);
                 intent.putExtra("consumoUrbano",consumourbano);
                 intent.putExtra("consumoExtraUrbano",cosumoExUrbano);
                 intent.putExtra("consumoMedio",consumomedio);
                 intent.putExtra("consumoDeposito",consumoDepo);
                 intent.putExtra("autonomiaAproximada",autonomiaAproxi);
                 intent.putExtra("velocidad_maxima",velocidadMaxi);



                  context.startActivity(intent);

             }


         });



    }





    @Override
    public int getItemCount() {
        return listacoches.size();
    }





    public void setData(List<Coches> listacoches){
        this.listacoches = listacoches;
        notifyDataSetChanged();
    }







    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtmodel,txtversi,txtcarroce,txtanio,txtcombustible;
        private ImageView imagen;
        private Button vista;
        private  CardView vistaCarta;

        public ViewHolder( View v) {
            super(v);

            txtmodel = v.findViewById(R.id.lblModelo);
            txtversi = v.findViewById(R.id.lblVersion);
            txtcarroce = v.findViewById(R.id.lblCarroceria);
            imagen = v.findViewById(R.id.imgImagen);
            txtanio = v.findViewById(R.id.lblAnio);
            txtcombustible = v.findViewById(R.id.lblGasolina);
            vista = v.findViewById(R.id.cvView);
            vistaCarta = v.findViewById(R.id.crView);

        }
    }
}
