import java.util.Scanner;

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

    }

    public static void editarMensaje(){

    }

}
