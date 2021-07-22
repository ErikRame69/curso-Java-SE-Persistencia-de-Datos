import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conecction {

    public Connection get_connection(){
        Connection connection = null;
        try {                                               //la contraseña va vacia por que el servidor de php no le pusimos contrasñ y no es la misma que la de mysql workbench
            connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3307/mensajes_app", "root", "");
            if (connection != null){
                System.out.println("Successful connection");
            }
        }catch(SQLException e) {
            System.out.println(e);
        }
        return connection;
    }
}
