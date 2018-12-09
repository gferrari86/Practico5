package com.antel;

import com.antel.entities.Editorial;
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

    public List<Object[]> DisplayAllPublicaciones(){

        //Query query = entityManager.createQuery("SELECT p FROM Publicacion p");
        Query query2 = entityManager.createQuery("SELECT e, p FROM Editorial e INNER JOIN e.listaPublicacionesEditorial p");



        return query2.getResultList();


    }

}
