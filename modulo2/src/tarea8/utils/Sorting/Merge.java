package tarea8.utils.Sorting;

public class Merge {
    public static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }

        int midpoint = arr.length / 2;
        int[] left = new int[midpoint];
        int[] right;

        if (arr.length % 2 == 0) {
            right = new int[midpoint];
        } else {
            right = new int[midpoint + 1];
        }

        for (int i = 0; i < midpoint; i++) {
            left[i] = arr[i];
        }
        for (int j = 0; j < right.length; j++) {
            right[j] = arr[midpoint + j];
        }

        int[] result;
        result = merge(mergeSort(left), mergeSort(right));

        return result;
    }

    public static int[] merge(int[] n1, int[] n2) {
        int[] N = new int[n1.length + n2.length];
        int index1 = 0;
        int index2 = 0;

        for (int i = 0; i < N.length; i++) {
            if (index1 == n1.length) {
                N[i] = n2[index2];
                index2++;
            } else if (index2 == n2.length) {
                N[i] = n1[index1];
                index1++;
            } else if (n1[index1] < n2[index2]) {
                N[i] = n1[index1];
                index1++;
                ++Sorting.MOVIMIENTOS;
            } else {
                N[i] = n2[index2];
                index2++;
                ++Sorting.MOVIMIENTOS;
            }
            ++Sorting.COMPARACIONES;
        }

        return N;
    }

}


