package com.antel.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Editoriales")

public class Editorial implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    private String nombre;

    @OneToMany
    @JoinColumn(name="editorial_id")
    private List<Publicacion> listaPublicacionesEditorial = new ArrayList<Publicacion>();
    public Editorial(){

    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Editorial(String nombre) {
        this.nombre = nombre;
    }

    public List<Publicacion> getListaPublicacionesEditorial() {
        return listaPublicacionesEditorial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setListaPublicacionesEditorial(List<Publicacion> listaPublicacionesEditorial) {
        this.listaPublicacionesEditorial = listaPublicacionesEditorial;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Editorial)){ return false; }
        if(((Editorial) obj).getNombre().equals(this.getNombre())){ return true; }
        return false;
    }

}