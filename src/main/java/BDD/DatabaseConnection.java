package BDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String url = "jdbc:mysql://localhost:3306/";
    private static final String user = "root";
    private static final String bddApp = "concession_mii";
    private static final String pwd = "";

    public static Connection getConnexion() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(url+bddApp, user, pwd);
    }
}