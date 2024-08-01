package BDD;

import Entity.Voiture;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

@WebServlet("/SelectUser")
public class SelectUsers extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Voiture> voitures = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnexion()) {
            String query = "SELECT * FROM voiture";
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Voiture voiture = new Voiture();
                voiture.setMarque(resultSet.getString("marque"));
                voiture.setModel(resultSet.getString("model"));
                voitures.add(voiture);
            }
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        request.setAttribute("voitures", voitures);
        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/bddConn.jsp");
        dispatcher.forward(request, response);
    }
}
