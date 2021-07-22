import com.google.gson.Gson;
import com.squareup.okhttp.*;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;




public class GatosService {

    public static void verGatos() throws  IOException{
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.thecatapi.com/v1/images/search")
                .method("GET", null)
                .build();
        Response response = client.newCall(request).execute();

        String elJson = response.body().string();

        elJson = elJson.substring(1, elJson.length());
        elJson = elJson.substring(0, elJson.length()-1);

        Gson gson = new Gson();
        Gatos gatos = gson.fromJson(elJson, Gatos.class);

        Image image = null;
        try{
            URL url = new URL(gatos.getUrl());
            image = ImageIO.read(url);

            ImageIcon fondoGato = new ImageIcon(image);
            if (fondoGato.getIconWidth()>800) {
                Image fondo = fondoGato.getImage();
                Image modificafa = fondo.getScaledInstance(800, 600, Image.SCALE_SMOOTH);
                fondoGato = new ImageIcon(modificafa);

            }

            String menu = "Opciones: \n"
                    + "1. Ver otra imagen\n"
                    + "2. Añadir a favoritos\n"
                    + "3.volver\n";

            String [] botones = {"Ver otra imagen", "Añadir a favoritos", "volver"};
            String id_gato = gatos.getId();
            String opcion = (String) JOptionPane.showInputDialog(null, menu,id_gato,
                    JOptionPane.INFORMATION_MESSAGE, fondoGato,botones,botones[0]);

            int seleccion = -1;
            for (int i=0; i<botones.length; i++) {
                if (opcion.equals(botones[i])) {
                    seleccion = i;
                }
            }
            switch (seleccion){
                case 0:
                    verGatos();
                    break;
                case 1:
                    favoritoGato(gatos);
                default:
                    break;
            }
        }catch (IOException e){
            System.out.println(e);
        }
    }

    public static void favoritoGato(Gatos gato){
        try{
            OkHttpClient client = new OkHttpClient();
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, "{\n\t\"image_id\":\""+gato.getId()+"\"\n}");
            Request request = new Request.Builder()
              .url("https://api.thecatapi.com/v1/favourites")
              .post(body)
              .addHeader("Content-Type", "application/json")
              .addHeader("x-api-key", gato.getApikey())
              .build();
            Response response = client.newCall(request).execute();

        }catch(IOException e){
            System.out.println(e);
        }
    }
}
