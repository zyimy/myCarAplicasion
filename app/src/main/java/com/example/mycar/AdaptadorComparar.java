package com.example.mycar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mycar.Entidades.Coches;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdaptadorComparar extends RecyclerView.Adapter<AdaptadorComparar.ViewHolder>{

    private List<Coches> listacochesComparar;
    private Context context;

    public AdaptadorComparar(Context context,List<Coches> listacochesComparar) {
        this.listacochesComparar = listacochesComparar;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.comparador_coches,parent,false);

        AdaptadorComparar.ViewHolder viewHolder = new AdaptadorComparar.ViewHolder(v);
        return viewHolder ;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String modelos = listacochesComparar.get(position).getModelos().toString();
        holder.modelo.setText(modelos);
        String carrocerias = listacochesComparar.get(position).getCarroceria().toString();
        holder.carroceria.setText(carrocerias);

      /*  String versiones = listacochesComparar.get(position).getVersion().toString();
        holder.version.setText(versiones);

       */
        String precios = listacochesComparar.get(position).getPvp().toString();
        holder.precio.setText(precios);
        String conMe = listacochesComparar.get(position).getConsumoMedio().toString();
        holder.consumoMedio.setText(conMe);
        String combustibles = listacochesComparar.get(position).getCombustibles().toString();
        holder.combustible.setText(combustibles);
        String potencias = listacochesComparar.get(position).getPotenciaMaxima().toString();
        holder.potencia.setText(potencias);
        String cilindradas = listacochesComparar.get(position).getCilindrada().toString();
        holder.cilindrada.setText(cilindradas);
        String veloMax = listacochesComparar.get(position).getVelocidad_maxima().toString();
        holder.velocidadMaxima.setText(veloMax);
        String conUrba = listacochesComparar.get(position).getConsumoUrbano().toString();
        holder.consumoUrbano.setText(conUrba);
        String conExUr = listacochesComparar.get(position).getConsumoExtraUrbano().toString();
        holder.consumoExtraurbano.setText(conExUr);
        String traccions = listacochesComparar.get(position).getTraccion().toString();
        holder.traccion.setText(traccions);
        String emision = listacochesComparar.get(position).getEmisiones().toString();
        holder.emisiones.setText(emision);
        String numPlazas = listacochesComparar.get(position).getPlazasHomologadas().toString();
        holder.numeroPlazas.setText(numPlazas);

        Picasso.Builder builder = new Picasso.Builder(context);
        builder.build().load(listacochesComparar.get(position).getImagenes())
                .placeholder(R.drawable.golf7)
                .error(R.drawable.golf7)
                .into(holder.imagenComparar);

    }

    @Override
    public int getItemCount() {
        return listacochesComparar.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView modelo,carroceria,version,precio,consumoMedio,combustible,potencia,cilindrada,
        velocidadMaxima,consumoUrbano,consumoExtraurbano,traccion,emisiones,numeroPlazas;
        private ImageView imagenComparar;
        public ViewHolder(@NonNull View v) {
            super(v);


            modelo = v.findViewById(R.id.lblModeloComparar);
            carroceria = v.findViewById(R.id.lblcarroceriaComparar);
            //version = v.findViewById(R.id.lblVersionComparar);
            precio = v.findViewById(R.id.lblPrecioComparar);
            consumoMedio = v.findViewById(R.id.lblConsumoMedioComparar);
            combustible = v.findViewById(R.id.lblcombustibleComparar);
            potencia = v.findViewById(R.id.lblPotenciaComparar);
            cilindrada = v.findViewById(R.id.lblCilindradaComparar);
            velocidadMaxima = v.findViewById(R.id.lblVelocidadMaximaComparar);
            carroceria = v.findViewById(R.id.lblcarroceriaComparar);
            consumoUrbano = v.findViewById(R.id.lblConsumoUrbanoComparar);
            consumoExtraurbano= v.findViewById(R.id.lblConsumoExtraUrbanoComparar);
            traccion = v.findViewById(R.id.lblTraccionComparar);
            emisiones = v.findViewById(R.id.lblEmisionesComparar);
            numeroPlazas = v.findViewById(R.id.lblNumeroPlazasComparar);
            imagenComparar = v.findViewById(R.id.imgPrimerCoche);

        }
    }
}
