package tarea8.utils.Sorting;

public class Bubble {
    public static void bubbleSort(int[] A) {
        int n = A.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                ++Sorting.COMPARACIONES;
                if (A[i - 1] > A[i]) {
                    Sorting.swap(A, i - 1, i);
                    swapped = true;
                    ++Sorting.MOVIMIENTOS;
                }
            }
        } while (swapped);
    }

}
