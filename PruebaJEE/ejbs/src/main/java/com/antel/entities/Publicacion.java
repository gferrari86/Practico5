package com.antel.entities;

import java.util.Calendar;

public abstract class Publicacion {

    private String titulo;
    private Calendar fecha;

    public Publicacion(){

    }

    public Publicacion(String titulo, Calendar fecha) {
        this.titulo = titulo;
        this.fecha = fecha;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setFecha(Calendar fecha) {
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public Calendar getFecha() {
        return fecha;
    }
}
