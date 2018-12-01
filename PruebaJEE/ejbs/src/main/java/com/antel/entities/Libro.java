package com.antel.entities;

import javax.persistence.Entity;
import java.util.Calendar;

@Entity(name = "Libro")
public class Libro extends Publicacion {

    private String ISBN;


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