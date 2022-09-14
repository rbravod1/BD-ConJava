package SQL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author marco
 */
public class Operaciones {

    /*  
        Esto solo es un ejemplo de la utilización de instrucciones SQL
        Si quiere hacer pruebas deberá conectar su BD y poner los valores 
        de sus tablas
     */
    public boolean operacionINSERT(String campo1, String campo2) {
        String query = "INSERT INTO Tabla(campo1, campo2) VALUES(?,?)";
        try {

            //Se realiza la conexión a BD
            PreparedStatement instruccion = Conexion.Conexion().prepareStatement(query);

            //Esta instruccion cambiará los simbolos de interrogación por los campos
            //Esto se hace por seguridad ya que la consulta puede ser escrita en el string
            //pero puede ser reemplazada y es una mala práctica en términos de seguridad
            instruccion.setString(1, campo1);
            instruccion.setString(2, campo2);

            //Se ejecuta la instrucción
            instruccion.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("LA OPERACIÓN NO SE REALIZÓ");
            System.out.println("Error SQL -> " + e.getErrorCode());
        }
        return false;
    }

    public boolean operacionUPDATE(String campo1, int id) {
        String query = "UPDATE Tabla SET campo1 = ? WHERE idTabla = ?";
        try {
            PreparedStatement instruccion = Conexion.Conexion().prepareStatement(query);
            instruccion.setString(1, campo1);
            instruccion.setInt(2, id);
            instruccion.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("LA OPERACIÓN NO SE REALIZÓ");
            System.out.println("Error SQL -> " + e.getErrorCode());
        }
        return false;
    }

    public void operacionSELECT() {
        String query = "SELECT * FROM Tabla";
        try {
            PreparedStatement instruccion = Conexion.Conexion().prepareStatement(query);
            ResultSet resultado = instruccion.executeQuery();
            while (resultado.next()) {
                //Se puede construir el objeto a partir de una tabla
                //O se puede obtener el atributo específico con el # de columna
                System.out.println("R -> " + resultado.getString(1));
            }
        } catch (SQLException e) {
            System.out.println("LA OPERACIÓN NO SE REALIZÓ");
            System.out.println("Error SQL -> " + e.getErrorCode());
        }
    }
}
