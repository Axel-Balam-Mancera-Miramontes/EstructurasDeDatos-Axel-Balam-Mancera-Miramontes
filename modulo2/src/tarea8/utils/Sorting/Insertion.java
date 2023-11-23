package tarea8.utils.Sorting;

public class Insertion {
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                j--;

                ++Sorting.COMPARACIONES;
                ++Sorting.MOVIMIENTOS;
            }

            array[j + 1] = current;
        }
    }
}
