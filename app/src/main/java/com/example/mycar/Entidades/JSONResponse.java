package com.example.mycar.Entidades;

import java.util.List;

public class JSONResponse {

    private List<Coches> listacoches;

    public void setListacoches(List<Coches>listacoches) {

        this.listacoches = listacoches;
    }

    public List<Coches> getCoches() {

        return listacoches ;
    }
}
