package BDD;

import Entity.Voiture;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.util.ArrayList;

@WebServlet("/AddCarServlet")
public class AddCar extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String marque = request.getParameter("marque");
        String model = request.getParameter("model");

        try (Connection connection = DatabaseConnection.getConnexion()) {
            String query = "INSERT INTO voiture (marque, model) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, marque);
            statement.setString(2, model);
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

//      Après avoir inséré la nouvelle voiture, récupérer la liste mise à jour des voitures
        try {
            ArrayList<Voiture> voitures = SelectRequest.getVoitures();
            request.setAttribute("voitures", voitures);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/bddConn.jsp");
        dispatcher.forward(request, response);
    }
}
