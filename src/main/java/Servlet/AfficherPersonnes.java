package Servlet;

import Entity.Personnes;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/afficherPersonnes")
public class AfficherPersonnes extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Récupérer la valeur transmise par le formulaire
        String transmittedValue = request.getParameter("transmittedValue");

        // Ajouter la valeur en tant qu'attribut à la requête
        request.setAttribute("transmittedValue", transmittedValue);

        List<Personnes> personnes = new ArrayList<>();
        personnes.add(new Personnes("Léon Marchand", 22));
        personnes.add(new Personnes("Teddy Rinner", 35));
        personnes.add(new Personnes("Kevin Mayer", 32));

        request.setAttribute("pers", personnes);
        request.getRequestDispatcher("/WEB-INF/views/exemple.jsp").forward(request, response);
    }




}
