package proyectopa;
import java.util.*;

class Hospital {
    private List<Enfermera> enfermeras;

    public Hospital() {
        this.enfermeras = new ArrayList<>();
    }

    public void agregarEnfermera(String nombre, int edad) {
        Enfermera nuevaEnfermera = new Enfermera(nombre, edad);
        enfermeras.add(nuevaEnfermera);
        System.out.println("Enfermera agregada al sistema: " + nombre);
    }

    public void buscarDiaConHorarios(String diaBuscado) {
        System.out.println("Horarios para el día " + diaBuscado + ":");

        for (Enfermera enfermera : enfermeras) {
            Map<String, String> horario = enfermera.getHorario();
            if (horario.containsKey(diaBuscado)) {
                String turno = horario.get(diaBuscado);
                System.out.println("Enfermera: " + enfermera.getNombre() + " - Turno: " + turno);
            }
        }
    }
    private Enfermera buscarEnfermeraPorNombre(String nombre) {
        for (Enfermera enfermera : enfermeras) {
            if (enfermera.getNombre().equalsIgnoreCase(nombre)) {
                return enfermera;
            }
        }
        return null;
    }
    private int obtenerIndiceDia(String dia) {
        String[] diasSemana = { "lunes", "martes", "miércoles", "jueves", "viernes", "sábado", "domingo" };
        for (int i = 0; i < diasSemana.length; i++) {
            if (diasSemana[i].equalsIgnoreCase(dia)) {
                return i;
            }
        }
        return -1;
    }

    private String obtenerDiaPorIndice(int indice) {
        String[] diasSemana = { "lunes", "martes", "miércoles", "jueves", "viernes", "sábado", "domingo" };
        if (indice >= 0 && indice < diasSemana.length) {
            return diasSemana[indice];
        }
        return "Día no válido";
    }
    public void mostrarEnfermerasConHorarios() {
        for (Enfermera enfermera : enfermeras) {
            System.out.println("Enfermera: " + enfermera.getNombre() + " (Edad: " + enfermera.getEdad() + ")");
            Map<String, String> horario = enfermera.getHorario();

            List<String> diasSemana = new ArrayList<>(horario.keySet());
            diasSemana.sort((dia1, dia2) -> obtenerIndiceDia(dia1) - obtenerIndiceDia(dia2));

            for (String dia : diasSemana) {
                String turno = horario.get(dia);
                System.out.println("  " + dia + ": " + turno);
            }
            System.out.println();
        }
    }
    public void agregarTurno(String nombreEnfermera, String diaInicio) {
        Enfermera enfermera = buscarEnfermeraPorNombre(nombreEnfermera);
        if (enfermera != null) {
            String[] turnos = { "día", "noche", "saliente", "libre" };
            int indiceDiaInicio = obtenerIndiceDia(diaInicio);

            for (int i = 0; i < 7; i++) {
                String dia = obtenerDiaPorIndice((indiceDiaInicio + i) % 7);
                String turno = turnos[i % 4];
                enfermera.asignarTurno(dia, turno);
            }

            System.out.println("Turnos asignados a " + nombreEnfermera + " desde " + diaInicio);
        } else {
            System.out.println("Enfermera no encontrada.");
        }
    }
    public void eliminarEnfermera(String nombre) {
        Iterator<Enfermera> iter = enfermeras.iterator();
        while (iter.hasNext()) {
            Enfermera enfermera = iter.next();
            if (enfermera.getNombre().equalsIgnoreCase(nombre)) {
                iter.remove();
                System.out.println("Enfermera eliminada del sistema: " + nombre);
                return;
            }
        }
        System.out.println("Enfermera no encontrada.");
    }
}
