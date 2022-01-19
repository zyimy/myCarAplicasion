package com.example.mycar.Entidades;

public class Personas {

    private int idPersona;
    private String nombre;
    private String correoEletronico;
    private String contrasena;

    public Personas() {
    }

    public Personas(int idPersona, String nombre, String correoEletronico, String contrasena) {
        this.idPersona = idPersona;
        this.nombre = nombre;
        this.correoEletronico = correoEletronico;
        this.contrasena = contrasena;
    }

    public int getId() {
        return idPersona;
    }

    public void setId(int id) {
        this.idPersona = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return correoEletronico;
    }


    public void setCorreoElectronico(String correoElectronico) {
        this.correoEletronico = correoElectronico;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public String toString() {
        return "Personas{" +
                "id=" + idPersona +
                ", nombre='" + nombre + '\'' +
                ", correoElectronico='" + correoEletronico + '\'' +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }
}
