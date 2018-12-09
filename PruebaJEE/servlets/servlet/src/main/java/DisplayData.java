import com.antel.DisplayDataLocal;
import com.antel.entities.Editorial;
import com.antel.entities.Libro;
import com.antel.entities.Publicacion;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/DisplayData")
public class DisplayData extends HttpServlet {

    @EJB
    DisplayDataLocal displayDataLocal;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Object[]> result = displayDataLocal.DisplayAllPublicaciones();

        List<Publicacion> listaPublicaciones = new ArrayList<Publicacion>();
        List<Editorial> listaEditoriales = new ArrayList<Editorial>();


        for (Object o[] : result) {
            Editorial edi = (Editorial) o[0];
            listaEditoriales.add(edi);

            Publicacion p = (Publicacion) o[1];
            listaPublicaciones.add(p);

            System.out.println("Editorial " + edi.getNombre() + "Publicacion " + p.getTitulo());

        }





        req.setAttribute("listaPublicaciones", listaPublicaciones);
        req.setAttribute("listaEditoriales", listaEditoriales);
        req.getRequestDispatcher("display.jsp").forward(req, resp);




    }



    }
