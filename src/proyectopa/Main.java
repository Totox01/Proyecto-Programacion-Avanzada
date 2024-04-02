package proyectopa;

import java.io.*;

class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int opcion;
        Hospital hospital = new Hospital();

        hospital.agregarEnfermera("Laura Rodriguez", 22);
        hospital.agregarTurno("Laura Rodriguez", "lunes");

        hospital.agregarEnfermera("Carla Tudela", 23);
        hospital.agregarTurno("Carla Tudela", "miercoles");

        hospital.agregarEnfermera("Camila Gonzalez", 26);
        hospital.agregarTurno("Camila Gonzalez", "viernes");

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
                    hospital.agregarEnfermera(nombre, edad);
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