package proyectopa;
import java.util.ArrayList;

public class Enfermera {
    private String nombre;
    private int edad;
    private ArrayList<String> turnos;

    public Enfermera(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.turnos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setTurnos(){
        this.turnos.add("N/A");
    }

    public void setTurnos(String dia){
        this.turnos.add(dia);
    }

    public String getTurno(int i){
        return this.turnos.get(i);
    }

    public int getTurnosSize(){
        return this.turnos.size();
    }
}
