import com.antel.DisplayDataLocal;
import com.antel.entities.Libro;
import com.antel.entities.Publicacion;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/DisplayData")
public class DisplayData extends HttpServlet {

    @EJB
    DisplayDataLocal displayDataLocal;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Publicacion> listaPublicaciones = displayDataLocal.DisplayAllPublicaciones();


        req.setAttribute("listaPublicaciones", listaPublicaciones);
        req.getRequestDispatcher("display.jsp").forward(req, resp);




    }



    }
