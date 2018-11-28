package com.antel.entities;

import java.util.Calendar;

public class Revista extends Publicacion {

    private int numero;

    public Revista(){

    }

    public Revista(String titulo, Calendar fecha, int numero) {
        super(titulo, fecha);
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Revista)){
            return false;
        }
        if(((Revista) obj).getTitulo().equals(this.getTitulo())){
            return true;
        }
        return false;
    }


}