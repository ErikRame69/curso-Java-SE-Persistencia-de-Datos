import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
        Conexion db_connet = new Conexion();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try (Connection conexion = db_connet.get_connection()){
            String query ="SELECT * FROM `mensajes`";
            ps=conexion.prepareStatement(query);
            rs=ps.executeQuery();

            while(rs.next()){
                System.out.println("ID: "+rs.getInt("id_mensaje"));
                System.out.println("Mensaje: "+rs.getString("mensaje"));
                System.out.println("Autor: "+rs.getString("autor"));
                System.out.println("Fecha: "+rs.getString("fecha_mensaje"));
                System.out.println("");
            }
        }catch (SQLException e) {
            System.out.println("No se encontraron los mensajes");
            System.out.println(e);
        }

    }

    public static void borrarMensajesDB (int id_mensaje){
        Conexion db_connet = new Conexion();

        try (Connection conexion = db_connet.get_connection()){
        PreparedStatement ps=null;

            try {
                String query="DELETE FROM `mensajes` WHERE `mensajes`.`id_mensaje` = ?";
                ps=conexion.prepareStatement(query);
                ps.setInt(1, id_mensaje);
                ps.executeUpdate();
                System.out.println("Mensaje borrado");
            }catch (SQLException e) {
                System.out.println(e);
                System.out.println("No se borraron los mensajes");
            }
        }catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void actualizarMensajeDB(Mensajes mensaje){
        Conexion db_connet = new Conexion();

        try (Connection conexion = db_connet.get_connection()){
            PreparedStatement ps=null;

            try {
                String query="UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?";
                ps= conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setInt(2, mensaje.getId_Mensaje());
                ps.executeUpdate();
                System.out.println("Mensaje actualizado correctamente");
            }catch (SQLException ex){
                System.out.println(ex);
                System.out.println("No se actualizo el mensaje");
            }

        }catch (SQLException e) {
            System.out.println(e);
        }

    }

}
