package App;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDConnection {
    public static void main(String[] args) {
       
    }

    public Connection conexion() {
         // Parámetros de conexión
        String url = "jdbc:mysql://localhost:3306/users";
        String user = "root";
        String password = "";

        // Establecer la conexión
        try {
            Connection conexion = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa a la base de datos.");
            

            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        return null;
    }
}

