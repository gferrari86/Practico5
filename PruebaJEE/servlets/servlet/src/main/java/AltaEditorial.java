import com.antel.PlaceEditorialLocal;

import javax.ejb.EJB;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/AltaEditorial")
public class AltaEditorial extends HttpServlet {




    @EJB
    PlaceEditorialLocal placeEditorialLocal;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

        String nombreEditorial = req.getParameter("nombre");





    }

}
