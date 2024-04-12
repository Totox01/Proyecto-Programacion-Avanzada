package proyectopa;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.util.*;

public class CargarArchivo {
    public static void cargarEnfermerasDesdeArchivo(Hospital hospital) throws IOException {
        FileReader fileReader = new FileReader("src/proyectopa/enfermeras.txt");
        BufferedReader br = new BufferedReader(fileReader);
        String linea;
        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split(",");
            String nombre = partes[0];
            int edad = Integer.parseInt(partes[1]);
            Map<String, String> horario = new HashMap<>();
            for (int i = 2; i < partes.length; i++) {
                String[] turnoDia = partes[i].split(":");
                horario.put(turnoDia[0], turnoDia[1]);
            }
            hospital.agregarEnfermera(nombre, edad, horario);
        }
        br.close();
    }

    public static void agregarEnfermeraAArchivo(String nombre, int edad, Map<String, String> horario) throws IOException {
        FileWriter fileWriter = new FileWriter("src/proyectopa/enfermeras.txt", true);
        BufferedWriter bw = new BufferedWriter(fileWriter);
        bw.write(nombre + "," + edad);
        for (Map.Entry<String, String> entry : horario.entrySet()) {
            bw.write("," + entry.getKey() + ":" + entry.getValue());
        }
        bw.newLine();
        bw.close();
    }

    public static void eliminarEnfermeraDeArchivo(String nombre) throws IOException {
        File archivoEntrada = new File("src/proyectopa/enfermeras.txt");
        File archivoTemporal = new File("temp.txt");

        FileReader fileReader = new FileReader(archivoEntrada);
        BufferedReader reader = new BufferedReader(fileReader);

        FileWriter fileWriter = new FileWriter(archivoTemporal);
        BufferedWriter writer = new BufferedWriter(fileWriter);

        String lineaActual;
        boolean enfermeraEncontrada = false;
        while ((lineaActual = reader.readLine()) != null) {
            String[] partes = lineaActual.split(",");
            String nombreEnfermera = partes[0].trim();
            if (!nombreEnfermera.equalsIgnoreCase(nombre)) {
                writer.write(lineaActual + System.getProperty("line.separator"));
            } else {
                enfermeraEncontrada = true;
            }
        }

        writer.close();
        reader.close();

        if (!enfermeraEncontrada) {
            throw new IOException("La enfermera '" + nombre + "' no se encontró en el archivo");
        }

        if (!archivoEntrada.delete()) {
            throw new IOException("No se pudo eliminar el archivo original");
        }
        if (!archivoTemporal.renameTo(archivoEntrada)) {
            throw new IOException("No se pudo renombrar el archivo temporal");
        }
    }
}

