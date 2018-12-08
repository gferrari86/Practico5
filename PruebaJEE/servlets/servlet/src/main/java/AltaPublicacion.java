import com.antel.entities.Editorial;
import com.antel.entities.Libro;
import com.antel.entities.Publicacion;
import com.antel.entities.Revista;

import javax.annotation.Resource;
import javax.jms.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@WebServlet(urlPatterns = "/AltaPublicacion")
public class AltaPublicacion extends HttpServlet {





    @Resource(lookup = "java:/ConnectionFactory")
    ConnectionFactory connectionFactory;

    @Resource(lookup = "java:jboss/exported/jms/queue/j2ee_prueba_alta_publicacion")
    Destination queue;



    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        String titulo = req.getParameter("titulo");
        String isbn = req.getParameter("isbn");
        String numeroString = req.getParameter("numero");
        String nombreEditorial = req.getParameter("nombreEditorial");

        Publicacion p;

        if (numeroString.equals("")){
            p = new Libro();
            ((Libro) p).setISBN(isbn);

        } else {
            p = new Revista();
            Integer numero = Integer.parseInt(numeroString);
            ((Revista) p).setNumero(numero);
        }

        p.setTitulo(titulo);
        p.setFecha(Calendar.getInstance());

        Editorial e = new Editorial();
        e.setNombre(nombreEditorial);
        List<Publicacion> listaPublicaciones = new ArrayList<Publicacion>();
        listaPublicaciones.add(p);
        e.setListaPublicacionesEditorial(listaPublicaciones);

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
