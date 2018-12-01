package com.antel.entities;

import javax.persistence.Entity;
import java.util.Calendar;

@Entity(name = "Revista")

public class Revista extends Publicacion {

    private int numero;

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