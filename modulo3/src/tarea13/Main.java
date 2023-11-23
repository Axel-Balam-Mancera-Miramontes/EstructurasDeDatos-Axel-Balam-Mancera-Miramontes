package tarea13;

public class Main {
    public static void main(String[] args) {
        Median median = new Median();
        int[] lista = { 3, 6, 2, 9, 1, 5, 4, 7, 8 };
        int n = lista.length;
        int pos = n / 2;

        if (n % 2 == 0) {
            int mediana = (median.getMedian(lista, 0, lista.length - 1, pos) + median.getMedian(lista, 0, lista.length - 1, pos)) / 2;
            System.out.println("La mediana es: " + mediana);
        } else {
            System.out.println("La mediana es: " + median.getMedian(lista, 0, lista.length - 1, pos));
        }
    }
}