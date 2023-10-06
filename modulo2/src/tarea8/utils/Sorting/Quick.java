package tarea8.utils.Sorting;

public class Quick {
    public static void quickSort(int[] arr, int left, int right) {
        int partition;
        if (right - left > 0) {
            partition = getPartition(arr, left, right);
            quickSort(arr, left, partition - 1);
            quickSort(arr, partition + 1, right);
        }
    }

    public static int getPartition(int[] arr, int left, int right) {
        int pivot = right;
        int firstHigh = left;
        for (int counter = left; counter < right; counter++) {
            ++Sorting.COMPARACIONES;
            if (arr[counter] < arr[pivot]) {
                Sorting.swap(arr, counter, firstHigh);
                firstHigh++;
                ++Sorting.MOVIMIENTOS;
            }
        }
        Sorting.swap(arr, pivot, firstHigh);
        ++Sorting.MOVIMIENTOS;
        return firstHigh;
    }
}

