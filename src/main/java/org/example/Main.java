package org.example;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {


        //TablaHash tabla = crear_tabla(28);

    }


     int tamaño;
     LinkedList<String>[] tabla;

    public void TablaHash(int tamaño) {
        this.tamaño = tamaño;
        tabla = new LinkedList[tamaño];
        for (int i = 0; i < tamaño; i++) {
            tabla[i] = new LinkedList<>();
        }
    }

    public void agregar(String dato) {
        int posicion = funcion_hash(dato, tamaño);
        LinkedList<String> lista = tabla[posicion];
        if (!lista.contains(dato)) {
            lista.add(dato);
        }
    }

    public String quitar(String dato) {
        int posicion = funcion_hash(dato, tamaño);
        LinkedList<String> lista = tabla[posicion];
        if (lista.contains(dato)) {
            lista.remove(dato);
            return dato;
        }
        return null;
    }

    public Integer buscar(String dato) {
        int posicion = funcion_hash(dato, tamaño);
        LinkedList<String> lista = tabla[posicion];
        if (lista.contains(dato)) {
            return posicion;
        }
        return null;
    }

    private int funcion_hash(String dato, int tamaño_tabla) {
        // Aquí implementamos nuestra función de hash
        int hash = 0;
        for (int i = 0; i < dato.length(); i++) {
            hash = (hash * 31 + dato.charAt(i)) % tamaño_tabla;
        }
        return hash;
    }


}