import com.antel.entities.Editorial;

import javax.annotation.Resource;
import javax.jms.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/AltaEditorial")
public class AltaEditorial extends HttpServlet {





    @Resource(lookup = "java:/ConnectionFactory")
    ConnectionFactory connectionFactory;

    @Resource(lookup = "java:jboss/exported/jms/queue/j2ee_prueba_alta_editorial")
    Destination queue;



    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        String nombreEditorial = req.getParameter("nombre");


        Editorial e = new Editorial();
        e.setNombre(nombreEditorial);

        sendMessage(e);

    }


    public void sendMessage(Editorial editorial){

        System.out.println("Enviando Mensaje");

        try {
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            connection.start();
            MessageProducer sender = session.createProducer(queue);
            ObjectMessage message = session.createObjectMessage();
            message.setObject(editorial);
            sender.send(message);

            sender.close();
            session.close();
            connection.stop();


        } catch (JMSException e) {
            e.printStackTrace();
        }

    }


}
