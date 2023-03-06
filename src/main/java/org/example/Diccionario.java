package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import com.opencsv.CSVReader;
public class Diccionario {


        private HashMap<String, String> tablaHash;

        public Diccionario(String rutaArchivo) {
            tablaHash = new HashMap<String, String>();
            leerArchivoCSV(rutaArchivo);
        }

        private void leerArchivoCSV(String rutaArchivo) {
            BufferedReader lector = null;

            try {
                lector = new BufferedReader(new FileReader(rutaArchivo));
                String fila = lector.readLine();

                while (fila != null) {
                    String[] datos = fila.split(",");
                    tablaHash.put(datos[0], datos[1]);
                    fila = lector.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (lector != null) {
                        lector.close();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

        public String obtenerTraduccion(String palabra) {
            return tablaHash.get(palabra);
        }
}
