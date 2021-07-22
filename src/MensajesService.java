import java.util.Scanner;
import java.util.SortedMap;

public class MensajesService {

    public static void crearMensajeDb() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe tu mensaje");
        String mensaje = sc.nextLine();

        System.out.println("Tu nombre");
        String nombre = sc.nextLine();

        Mensajes registro = new Mensajes();
        registro.setMensaje(mensaje);
        registro.setAutor(nombre);

        MensajesDAO.crearMensajeDB(registro);
    }

    public static void listarMensaje(){
        MensajesDAO.leerMensajesDB();
    }

    public static void borrarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Indica el Id del Mensaje a borrar");
        int id_mensaje=sc.nextInt();
        MensajesDAO.borrarMensajesDB(id_mensaje);
    }

    public static void editarMensaje(){

    }

}
