package tarea8.utils.Search;

public class Binary {

    public static int binarySearch(int[] arr, int elementoBuscado) {
        int inicio = 0;
        int fin = arr.length - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;

            if (arr[medio] == elementoBuscado) {
                return medio;
            }
            if (arr[medio] > elementoBuscado) {
                fin = medio - 1;
            }
            else {
                inicio = medio + 1;
            }
        }

        return -1;
    }

}

