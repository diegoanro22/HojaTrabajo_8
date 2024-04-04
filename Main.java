import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        
        Archivo pacientestxt = new Archivo("pacientes.txt");
        ArrayList<String> pacientes = null;
        VectorHeapCollection<Paciente> queuePaciente = new VectorHeapCollection<>();

        try{
            pacientes = pacientestxt.leerArchivo();
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        for (String paciente : pacientes){
            String [] campos = paciente.split(",",3);
            String nombre = campos[0].trim();
            String sintoma = campos[1].trim();
            char codigoEmergencia = campos[2].trim().charAt(0);
            Paciente nuevoPaciente = new Paciente(nombre, sintoma, codigoEmergencia);
            queuePaciente.add(nuevoPaciente);
        }

        // Aquí podrías comenzar a procesar la cola de pacientes, por ejemplo:
        while (!queuePaciente.isEmpty()) {
            Paciente paciente = queuePaciente.remove();
            System.out.println("Atendiendo a: " + paciente.getNombre() + " con " + paciente.getSintoma() + " - Prioridad: " + paciente.getCodigoEmergencia());
        }

    }
}