package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firstServlet")
public class Exemple extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = "Bonjour, bienvenue sur mon site!";
        String message2 = "Coucou Chems !";
        request.setAttribute("tartanpion", message);// Définir l'attribut message
        request.setAttribute("tartanpion2", message2);
        request.getRequestDispatcher("/WEB-INF/views/exemple.jsp").forward(request, response); // Rediriger vers le template JSP
    }



}