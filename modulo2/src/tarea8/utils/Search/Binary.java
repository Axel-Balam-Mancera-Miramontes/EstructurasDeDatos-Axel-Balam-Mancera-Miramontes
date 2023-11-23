package tarea8.utils.Search;

import tarea8.utils.Sorting.Sorting;

public class Binary {

    public static int binarySearch(int[] arr, int elementoBuscado) {
        int inicio = 0;
        int fin = arr.length - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;

            if (arr[medio] == elementoBuscado) {
                ++Sorting.COMPARACIONES;
                return medio;
            }
            if (arr[medio] > elementoBuscado) {
                ++Sorting.COMPARACIONES;
                fin = medio - 1;
            }
            else {
                ++Sorting.COMPARACIONES;
                inicio = medio + 1;
            }
        }

        return -1;
    }
}
