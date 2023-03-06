package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

    private ArrayList<LinkedList<String>> tabla;
    private int tamano;

    public Main(int tamano) {
        this.tamano = tamano;
        tabla = new ArrayList<>(tamano);
        for (int i = 0; i < tamano; i++) {
            tabla.add(new LinkedList<>());
        }
    }
    public void agregar(String dato) {
        int posicion = funcion_hash(dato, tamano);
        LinkedList<String> lista = tabla.get(posicion);
        if (lista.contains(dato)) {
           System.out.println("Se agregó el dato " + dato );
            return;
        }
        lista.add(dato);
    }
    public String quitar(String dato) {
        int posicion = funcion_hash(dato, tamano);
        LinkedList<String> lista = tabla.get(posicion);
        if (lista.contains(dato)) {
            lista.remove(dato);
            System.out.println("El dato se elimino correctamente");
            return dato;
        }
        return null;
    }
    public int buscar(String dato) {
        int posicion = funcion_hash(dato, tamano);
        LinkedList<String> lista = tabla.get(posicion);
        if (lista.contains(dato)) {
            System.out.println("Dato " + dato +" encontrado en la posicion " + posicion);
            return posicion;
        }
        return -1;
    }
    private int funcion_hash(String dato, int tamano_tabla) {

        int ascii = (int) dato.charAt(0);
        return ascii % tamano_tabla;
    }
    private int sondeo(int posicion, int tamano_tabla) {
        System.out.println("Se aplicó el método de sondeo a la lista");
        return (posicion + 1) % tamano_tabla;
    }

    public int cantidad_elementos() {
        int contador = 0;
        for (LinkedList<String> lista : tabla) {
            contador += lista.size();
        }
        System.out.println("Hay un total de " + contador + " elementos en la tabla");
        return contador;
    }
    public void leer_archivo_csv(String nombre_archivo) {
        try {
            BufferedReader lector = new BufferedReader(new FileReader(nombre_archivo));
            String linea;
            while ((linea = lector.readLine()) != null) {
                agregar(linea);
            }
            lector.close();
            System.out.println("Se leyó el archivo correctamente");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo");
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        int tamano_tabla = 28;
        Main tabla = new Main(tamano_tabla);
        tabla.leer_archivo_csv("/Users/luismiguelurbez/Downloads/palabras.csv");
        tabla.cantidad_elementos();
        tabla.sondeo(5, 28);
        tabla.buscar("hola");
    }
}
