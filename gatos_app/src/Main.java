import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        int opcion_menu =-1;
        String[] botones = {"1. Ver gatos", "2. Salir"};
        do{
            String opcion = (String) JOptionPane.showInputDialog(null, "Gatitos Java", "MenuPrincipal",
                    JOptionPane.INFORMATION_MESSAGE, null, botones, botones[0]);
            for (int i=0; i<botones.length; i++){
                if(opcion.equals(botones[i])){
                    opcion_menu=i;
                }
            }
            switch (opcion_menu){
                case 0:
                    break;
                default:
                    break;
            }
        }while (opcion_menu!=1);
    }
}
