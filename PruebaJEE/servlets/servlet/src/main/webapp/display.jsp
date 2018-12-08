<%@ page import="com.antel.entities.Publicacion, com.antel.entities.Libro, com.antel.entities.Revista, java.util.List, java.util.ArrayList, java.text.SimpleDateFormat"%>

<h3> Publicaciones </h3>
<% List<Publicacion> listaPublicaciones = (ArrayList<Publicacion>)request.getAttribute("listaPublicaciones"); %>


<table>

        <tr>
            <td><%out.print("ID");%></td>
            <td><%out.println("Titulo");%></td>
            <td><%out.println("Fecha");%></td>
            <td><%out.println("ISBN");%></td>
            <td><%out.println("Numero");%></td>
            <td><%out.println("Editorial");%></td>
        </tr>

    <%for(Publicacion publicacion : listaPublicaciones) { %>



        <tr>
            <td><%out.print(publicacion.getId());%></td>
            <td><%out.print(publicacion.getTitulo());%></td>

            <% SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");%>

            <td><%out.print(sdf.format(publicacion.getFecha().getTime()));%></td>
            <%
            String ISBN;
            if (publicacion instanceof Libro){
                ISBN = ((Libro) publicacion).getISBN();
            } else {
                ISBN = "Null";
            }
            %>
            <td><%out.print(ISBN);%></td>

            <%
            String Numero;
            if (publicacion instanceof Libro){
            Numero = "Null";
            } else {
            Numero = Integer.toString(((Revista) publicacion).getNumero());
            } %>
            <td><%out.print(Numero);%></td>



        </tr>




    <% } %>

</table>
