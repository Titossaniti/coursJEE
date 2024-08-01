package BDD;

import Entity.Voiture;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class SelectRequest {

    public static ArrayList<Voiture> getVoitures() throws SQLException, ClassNotFoundException {
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
        }
        return voitures;
    }
}
