package tarea8.utils.Sorting;

public class Selection {
    public static void selectionSort(int[] array) {
        int n = array.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                ++Sorting.COMPARACIONES;

                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                ++Sorting.MOVIMIENTOS;

                Sorting.swap(array, minIndex, i);
            }
        }
    }
}
