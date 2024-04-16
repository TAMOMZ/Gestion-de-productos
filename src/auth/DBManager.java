package auth;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Parámetros de conexión
                String url = "jdbc:mysql://localhost:3306/users";
                String user = "root";
                String password = "";

                // Establecer la conexión
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                System.out.println("Error al conectar a la base de datos: " + e.getMessage());
            }
        }
        return connection;
    }
}

