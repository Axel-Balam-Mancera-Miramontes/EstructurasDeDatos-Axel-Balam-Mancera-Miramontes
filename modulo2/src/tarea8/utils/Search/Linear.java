package tarea8.utils.Search;

public class Linear {

    public static int linearSearch(int[] arreglo, int elementoBuscado) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == elementoBuscado) {
                return i;
            }
        }
        return -1;
    }

}

