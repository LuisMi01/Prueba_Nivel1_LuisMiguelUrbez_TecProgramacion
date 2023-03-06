package org.example;
import java.util.HashMap;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Diccionario {

    private HashMap<Character, LinkedList<String>> tablaHash;

    public Diccionario() {
        tablaHash = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            tablaHash.put(c, new LinkedList<String>());
        }
    }

    public void agregarPalabra(String palabra) {
        char primeraLetra = palabra.charAt(0);
        LinkedList<String> palabrasConLetra = tablaHash.get(primeraLetra);
        palabrasConLetra.add(palabra);
    }

    public boolean buscarPalabra(String palabra) {
        char primeraLetra = palabra.charAt(0);
        LinkedList<String> palabrasConLetra = tablaHash.get(primeraLetra);
        return palabrasConLetra.contains(palabra);
    }

    public static void main(String[] args) {
        String csvFile = "/Users/luismiguelurbez/Downloads/palabras.csv";
        String line = "";
        String csvSeparator = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSeparator);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}