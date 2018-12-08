package com.antel;

import com.antel.entities.Publicacion;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless

public class DiplayDataBean implements DisplayDataLocal{

    @PersistenceContext
    EntityManager entityManager;

    public List<Publicacion> DisplayAllPublicaciones(){

        Query query = entityManager.createQuery("SELECT p FROM Publicacion p");
        return query.getResultList();


    }

}
