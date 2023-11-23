package tarea11;

import utils.collection.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> hm = new HashMap<>();

        hm.add("Clave 1", "Valor 'a'");
        hm.add("Clave 2", "Valor 'b'");
        hm.add("Clave 3", "Valor 'c'");
        hm.add("Clave 3", "Valor 'd'");

        System.out.println(hm.get("Clave 1"));
        System.out.println(hm.get("Clave 3"));
        System.out.println(hm.get("Clave inexistente"));
    }
}
