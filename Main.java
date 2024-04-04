import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        
        Archivo pacientestxt = new Archivo("pacientes.txt");
        ArrayList<String> pacientes = null;

        try{
            pacientes = pacientestxt.leerArchivo();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        for (String paciente : pacientes){
            String [] campos = paciente.split(",",3);
            System.out.println(campos[0]);
            System.out.println(campos[1]);
        }

    }
}