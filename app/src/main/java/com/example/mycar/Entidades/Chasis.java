package com.example.mycar.Entidades;

public class Chasis {
    String suspension_delantera;
    String suspension_trasera;
    String distancia_ejes;
    String velocidades;
    String traccion;
    String neumatico_delantero;
    String neumatico_trasero;

    public Chasis(String suspension_delantera, String suspension_trasera, String distancia_ejes, String velocidades, String traccion, String neumatico_delantero, String neumatico_trasero) {
        this.suspension_delantera = suspension_delantera;
        this.suspension_trasera = suspension_trasera;
        this.distancia_ejes = distancia_ejes;
        this.velocidades = velocidades;
        this.traccion = traccion;
        this.neumatico_delantero = neumatico_delantero;
        this.neumatico_trasero = neumatico_trasero;
    }

    public String getSuspension_delantera() {
        return suspension_delantera;
    }

    public void setSuspension_delantera(String suspension_delantera) {
        this.suspension_delantera = suspension_delantera;
    }

    public String getSuspension_trasera() {
        return suspension_trasera;
    }

    public void setSuspension_trasera(String suspension_trasera) {
        this.suspension_trasera = suspension_trasera;
    }

    public String getDistancia_ejes() {
        return distancia_ejes;
    }

    public void setDistancia_ejes(String distancia_ejes) {
        this.distancia_ejes = distancia_ejes;
    }

    public String getVelocidades() {
        return velocidades;
    }

    public void setVelocidades(String velocidades) {
        this.velocidades = velocidades;
    }

    public String getTraccion() {
        return traccion;
    }

    public void setTraccion(String traccion) {
        this.traccion = traccion;
    }

    public String getNeumatico_delantero() {
        return neumatico_delantero;
    }

    public void setNeumatico_delantero(String neumatico_delantero) {
        this.neumatico_delantero = neumatico_delantero;
    }

    public String getNeumatico_trasero() {
        return neumatico_trasero;
    }

    public void setNeumatico_trasero(String neumatico_trasero) {
        this.neumatico_trasero = neumatico_trasero;
    }

    @Override
    public String toString() {
        return "Chasis{" +
                "suspension_delantera='" + suspension_delantera + '\'' +
                ", Suspension_trasera='" + suspension_trasera + '\'' +
                ", distancia_ejes='" + distancia_ejes + '\'' +
                ", velocidades='" + velocidades + '\'' +
                ", traccion='" + traccion + '\'' +
                ", neumatico_delantero='" + neumatico_delantero + '\'' +
                ", neumatico_trasero='" + neumatico_trasero + '\'' +
                '}';
    }
}
