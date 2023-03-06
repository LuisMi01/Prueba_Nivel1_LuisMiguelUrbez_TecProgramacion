package org.example;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    // Representación de la tabla como un arreglo de listas enlazadas
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
            return; // El elemento ya se encuentra en la tabla
        }
        lista.add(dato);
    }

    public String quitar(String dato) {
        int posicion = funcion_hash(dato, tamano);
        LinkedList<String> lista = tabla.get(posicion);
        if (lista.contains(dato)) {
            lista.remove(dato);
            return dato;
        }
        return null; // El elemento no se encontró en la tabla
    }

    public int buscar(String dato) {
        int posicion = funcion_hash(dato, tamano);
        LinkedList<String> lista = tabla.get(posicion);
        if (lista.contains(dato)) {
            return posicion;
        }
        return -1; // El elemento no se encontró en la tabla
    }

    private int funcion_hash(String dato, int tamano_tabla) {
        // Implementación de la función hash utilizando el primer carácter del dato
        int ascii = (int) dato.charAt(0);
        return ascii % tamano_tabla;
    }

    private int sondeo(int posicion, int tamano_tabla) {
        // Implementación de la función de sondeo utilizando la técnica lineal
        return (posicion + 1) % tamano_tabla;
    }

    public int cantidad_elementos() {
        int contador = 0;
        for (LinkedList<String> lista : tabla) {
            contador += lista.size();
        }
        return contador;
    }
}
