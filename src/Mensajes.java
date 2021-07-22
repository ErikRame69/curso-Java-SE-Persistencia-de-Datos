public class Mensajes {
    int id_mensaje;
    String mensaje;
    String autor;
    String fecha_mensaje;

    public Mensajes(){

    }

    public Mensajes(String mensaje, String autor, String fecha_mensaje) {
        this.mensaje = mensaje;
        this.autor = autor;
        this.fecha_mensaje = fecha_mensaje;
    }

    public int getId_Mensaje() {
        return id_mensaje;
    }

    public void setId_Mensaje(int idMensaje) {
        this.id_mensaje = idMensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFecha_Mensaje() {
        return fecha_mensaje;
    }

    public void setFecha_Mensaje(String fecha_mensaje) {
        this.fecha_mensaje = fecha_mensaje;
    }
}
