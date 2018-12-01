package com.antel.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@Entity
@Table(name = "Publicaciones")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)

public class Publicacion implements Serializable {

    protected Long id;
    private String titulo;
    private Calendar fecha;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
