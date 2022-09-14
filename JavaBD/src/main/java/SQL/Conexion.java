package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author marco
 */
public class Conexion {

    /*
        Para que esta clase funcione en otros programas debe agregarse la dependencia
        en el archivo pom.xml del conector de base de datos, el cuál ya se encuentra en este
        proyecto
    
        Esta conexión maneja un tipo de conexión MVC
     */
    
    private static final String URL = "jdbc:mysql://localhost:3306/NombreBaseDatos";
    private String user = "usuario";
    private String password = "password";
    private static Connection conexion = null;

    public static Connection Conexion() {
        if (conexion == null) {
            new Conexion();
        }
        return conexion;
    }

    private Conexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, user, password);
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("No se ha podido generar la conexion");
        }
    }
}
