package proyectopa;
import java.util.Map;
import java.util.HashMap;
import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int opcion;
        Hospital hospital = new Hospital();

        CargarArchivo.cargarEnfermerasDesdeArchivo(hospital);


        do {
            System.out.println("Ingrese el numero de la opcion deseada:");
            System.out.println("1. Agregar una enfermera al sistema");
            System.out.println("2. Agregar un turno a una enfermera");
            System.out.println("3. Eliminar una enfermera al sistema");
            System.out.println("4. Ver todas las enfermeras con sus horarios");
            System.out.println("5. Buscar un dia con sus horarios");
            System.out.println("6. Salir");
            opcion = Integer.parseInt(reader.readLine());

            switch (opcion){
                case 1:
                    System.out.println("Ingrese el nombre de la enfermera:");
                    String nombre = reader.readLine();
                    System.out.println("Ingrese la edad de la enfermera:");
                    int edad = Integer.parseInt(reader.readLine());

                    Map<String, String> horario = new HashMap<>();

                    System.out.println("Ingrese el turno para el día Lunes (Dia/Noche/Libre):");
                    String turnoLunes = reader.readLine();
                    horario.put("Lunes", turnoLunes);

                    System.out.println("Ingrese el turno para el día Martes (Dia/Noche/Libre):");
                    String turnoMartes = reader.readLine();
                    horario.put("Martes", turnoMartes);

                    System.out.println("Ingrese el turno para el día Miércoles (Dia/Noche/Libre):");
                    String turnoMiercoles = reader.readLine();
                    horario.put("Miércoles", turnoMiercoles);

                    System.out.println("Ingrese el turno para el día Jueves (Dia/Noche/Libre):");
                    String turnoJueves = reader.readLine();
                    horario.put("Jueves", turnoJueves);

                    System.out.println("Ingrese el turno para el día Viernes (Dia/Noche/Libre):");
                    String turnoViernes = reader.readLine();
                    horario.put("Viernes", turnoViernes);

                    hospital.agregarEnfermera(nombre, edad, horario);
                    CargarArchivo.agregarEnfermeraAArchivo(nombre, edad, horario);
                    break;
                case 2:
                    System.out.println("Ingrese el nombre de la enfermera:");
                    String nombreEnfermera = reader.readLine();
                    System.out.println("Ingrese el día de inicio (por ejemplo, lunes):");
                    String diaInicio = reader.readLine();
                    hospital.agregarTurno(nombreEnfermera, diaInicio);
                    break;

                case 3:
                    System.out.println("Ingrese el nombre de la enfermera a eliminar:");
                    String nombreEnfermeraEliminar = reader.readLine();
                    hospital.eliminarEnfermera(nombreEnfermeraEliminar);
                    CargarArchivo.eliminarEnfermeraDeArchivo(nombreEnfermeraEliminar);
                    break;

                case 4:
                    hospital.mostrarEnfermerasConHorarios();
                    break;

                case 5:
                    System.out.println("Ingrese el día de la semana a buscar:");
                    String diaBuscado = reader.readLine().toLowerCase();
                    hospital.buscarDiaConHorarios(diaBuscado);
                    break;

                case 6:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Ingrese un numero de opcion valido");
            }
        } while (opcion!=6);
    }
}