import java.sql.Connection;

public class Main {
    public static void main(String[] args) {

        Conecction conexion = new Conecction();

        try(Connection cnx = conexion.get_connection ()){

        }catch (Exception e){
            System.out.println(e);
        }

    }
}
