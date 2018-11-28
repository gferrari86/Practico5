package com.antel;

import com.antel.entities.Editorial;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless

public class PlaceEditorialBean implements PlaceEditorialLocal{

    @PersistenceContext
    EntityManager entityManager;

    public PlaceEditorialBean(){};

    public Editorial addEditorial(Editorial editorial) {

        entityManager.persist(editorial);

        System.out.println("Adding Editorial: " + editorial.getNombre() );


        return editorial;
    }
}
