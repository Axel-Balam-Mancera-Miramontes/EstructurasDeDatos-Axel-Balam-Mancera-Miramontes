package tarea7.utils.Sorting;

public class Bubble {
    public static void bubbleSort(int[] A) {
        int n = A.length;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (A[i - 1] > A[i]) {
                    // Swap A[i-1] and A[i]
                    int temp = A[i - 1];
                    A[i - 1] = A[i];
                    A[i] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }

}
