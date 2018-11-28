package com.antel.entities;

import java.util.Calendar;

public class Libro extends Publicacion {

    private String ISBN;

    public Libro(){

    }

    public Libro(String titulo, Calendar fecha, String ISBN) {
        super(titulo, fecha);
        this.ISBN = ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getISBN() {
        return ISBN;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Libro)){ return false; }
        if(((Libro) obj).getTitulo().equals(this.getTitulo())
                || ((Libro) obj).getISBN().equals(this.getISBN())){
            return true;
        }
        return false;
    }

}