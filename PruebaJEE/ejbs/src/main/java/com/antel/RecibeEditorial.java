package com.antel;

import com.antel.entities.Editorial;

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
        name = "Recibe Editorial",
        activationConfig = {
                @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue"),
                @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:jboss/exported/jms/queue/j2ee_prueba_alta_editorial"),
        }

)


public class RecibeEditorial implements MessageListener {

    @PersistenceContext
    EntityManager entityManager;

    public void onMessage(Message message) {

        System.out.println("Recibiendo Mensaje");

        ObjectMessage objectMessage = (ObjectMessage) message;

        try {
            Editorial editorial = (Editorial) objectMessage.getObject();

            System.out.println("se recibio la editorial " + editorial.getNombre() );

            Query query = entityManager.createQuery("SELECT e FROM Editorial e WHERE e.nombre = :eName");
            query.setParameter("eName", editorial.getNombre());
            if (query.getResultList().size() == 0){

                entityManager.persist(editorial);
                System.out.println("Se persiste en base la editorial");


            } else {

                System.out.println("La editorial ya existe. No se persiste en base");

            }






        } catch (JMSException e) {
            e.printStackTrace();
        }

    }




}
