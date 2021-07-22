import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MensajesDAO {

    public static void crearMensajeDB(Mensajes mensaje){
        Conexion db_connet = new Conexion();
        try (Connection conexion = db_connet.get_connection()){
            PreparedStatement ps=null;
            try{
                String query="INSERT INTO mensajes (mensaje, autor) VALUES (?,?)";
                ps=conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutor());
                ps.executeUpdate();
                System.out.println("Mensaje Creado");

            }catch (SQLException ex){
                System.out.println(ex);
            }
        }catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void leerMensajesDB (){

    }

    public static void borrarMensajesDB (int id_mensaje){

    }

    public static void actualizarMensajeDB(Conexion conexion){

    }

}
