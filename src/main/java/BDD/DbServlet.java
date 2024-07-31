package BDD;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/dbServlet")
public class DbServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String message = "Base de donnée connectée !";
        try {
            DatabaseConnection.getConnexion();
            request.setAttribute("message", message);
            request.getRequestDispatcher("/WEB-INF/views/bddConn.jsp").forward(request, response);
        } catch (ServletException | SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}