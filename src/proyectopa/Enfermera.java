package proyectopa;
import java.util.*;

class Enfermera {

    private String nombre;
    private int edad;
    private Map<String, String> horario;

    public Enfermera(String nombre, int edad, Map<String, String> horario) {
        this.nombre = nombre;
        this.edad = edad;
        this.horario = horario;
    }

    public int getEdad() {
        return edad;
    }

    public String getNombre() {
        return nombre;
    }

    public Map<String, String> getHorario() {
        return horario;
    }

    public void asignarTurno(String dia, String turno) {
        horario.put(dia, turno);
    }
}


