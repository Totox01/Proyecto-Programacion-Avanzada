package proyectopa;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.util.Objects;

class Main{
    public static void main(String[] args) throws IOException {
        int opcion, auxEdad;
        String auxName, auxTurno;
        ArrayList<Enfermera> enfermeras = new ArrayList<Enfermera>();
        boolean encontrado;

        Enfermera enfermeraEj1 = new Enfermera("Juanita Perez", 25);
        enfermeraEj1.setTurnos();
        enfermeras.add(enfermeraEj1);

        Enfermera enfermeraEj2 = new Enfermera("Pepita Gomez", 24);
        enfermeraEj2.setTurnos("Lunes");
        enfermeraEj2.setTurnos("Martes");
        enfermeraEj2.setTurnos("Miercoles");
        enfermeras.add(enfermeraEj2);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
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
                    System.out.println("Ingrese el nombre de la enfermera");
                    auxName = reader.readLine();
                    System.out.println("Ingrese la edad de la enfermera");
                    auxEdad = Integer.parseInt(reader.readLine());
                    Enfermera auxiliarEnfermera = new Enfermera(auxName,auxEdad);
                    auxiliarEnfermera.setTurnos();
                    enfermeras.add(auxiliarEnfermera);
                    System.out.println("Enfermera agregada");
                    break;
                case 2:
                    System.out.println("Ingrese el nombre de la enfermera a agregar el turno");
                    auxName = reader.readLine();
                    System.out.println("Ingrese la edad de la enfermera a agregar el turno");
                    auxEdad = Integer.parseInt(reader.readLine());
                    encontrado = false;
                    for (int i = 0; i<enfermeras.size();i++){
                        Enfermera auxEnfermera = enfermeras.get(i);
                        if((Objects.equals(auxEnfermera.getNombre(),auxName) && (Objects.equals(auxEnfermera.getEdad(),auxEdad)))){
                            encontrado = true;
                            System.out.println("Ingrese el dia del turno");
                            auxTurno = reader.readLine();
                            auxEnfermera.setTurnos(auxTurno);
                        }
                    }
                    if (!encontrado) System.out.println("No se ha encontrado coincidencias");
                    break;
                case 3:
                    System.out.println("Ingrese el nombre de la enfermera a eliminar");
                    auxName = reader.readLine();
                    System.out.println("Ingrese la edad de la enfermera a eliminar");
                    auxEdad = Integer.parseInt(reader.readLine());
                    encontrado = false;
                    for (int i = 0; i<enfermeras.size();i++){
                        Enfermera auxEnfermera = enfermeras.get(i);
                        if((Objects.equals(auxEnfermera.getNombre(),auxName) && (Objects.equals(auxEnfermera.getEdad(),auxEdad)))){
                            encontrado = true;
                            enfermeras.remove(auxEnfermera);
                            System.out.println("Enfermera eliminada");
                        }
                        break;
                    }
                    if (!encontrado) System.out.println("No se ha encontrado coincidencias");
                    break;
                case 4:
                    for (int i = 0; i<enfermeras.size();i++){
                        Enfermera auxEnfermera = enfermeras.get(i);
                        System.out.println("Nombre: " + auxEnfermera.getNombre());
                        for (int j = 0; j<auxEnfermera.getTurnosSize();j++){
                            System.out.println("Turno "+(j+1)+": "+ auxEnfermera.getTurno(j));
                        }
                    }
                    break;
                case 5:
                    System.out.println("Funcionalidad aun no implementada");
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