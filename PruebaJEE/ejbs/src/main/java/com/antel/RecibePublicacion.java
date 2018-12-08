package com.antel;

import com.antel.entities.Editorial;
import com.antel.entities.Libro;
import com.antel.entities.Publicacion;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@MessageDriven(
        name = "Recibe Publicacion",
        activationConfig = {
                @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
                @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:jboss/exported/jms/queue/j2ee_prueba_alta_publicacion"),
        }

)


public class RecibePublicacion implements MessageListener {

    @PersistenceContext
    EntityManager entityManager;

    public void onMessage(Message message) {

        System.out.println("Recibiendo Mensaje Publicacion");

        ObjectMessage objectMessage = (ObjectMessage) message;

        try {
            Editorial editorial = (Editorial) objectMessage.getObject();

            System.out.println("se recibio la publicacion para la editorial " + editorial.getNombre() );

            Query query = entityManager.createQuery("SELECT e FROM Editorial e WHERE e.nombre = :eName");
            query.setParameter("eName", editorial.getNombre());
            if (query.getResultList().size() == 0){

                System.out.println("No existe la ediotrial para agregar la Publicacion");

            } else {

                System.out.println("Existe la Editorial");
                Editorial ediDB = (Editorial)query.getResultList().get(0);
                Publicacion pubDB = editorial.getListaPublicacionesEditorial().get(0);


                if (pubDB instanceof Libro) {

                    Libro libDB = (Libro)pubDB;

                    Query query2 = entityManager.createQuery("SELECT p FROM Editorial e INNER JOIN e.listaPublicacionesEditorial p WHERE p.ISBN = :isbn AND e.id = :editorialID");
                    query2.setParameter("isbn", libDB.getISBN());
                    query2.setParameter("editorialID", ediDB.getId());

                    if(query2.getResultList().size() != 0){

                        System.out.println("Exite un Libro en esa editorial con el mismo ISBN");
                        return;

                    }

                }

                System.out.println("Se persiste publicacion");

                entityManager.persist(pubDB);
                System.out.println("Se agrega publicacion a editorial");
                ediDB.getListaPublicacionesEditorial().add(pubDB);

                //No creo que sea necesario. Lo encuentra en la query
                //entityManager.find(Editorial.class, ediDB.getId());




            }






        } catch (JMSException e) {
            e.printStackTrace();
        }

    }




}
