package com.antel.entities;

import java.util.ArrayList;
import java.util.List;

public class Editorial {

    private String nombre;
    private Integer id;
    private List<Publicacion> listaPublicacionesEditorial = new ArrayList<Publicacion>();

    public Editorial(){

    }

    public Editorial(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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