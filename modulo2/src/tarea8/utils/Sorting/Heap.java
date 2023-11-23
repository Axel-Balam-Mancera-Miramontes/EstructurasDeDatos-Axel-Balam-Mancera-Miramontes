package tarea8.utils.Sorting;

public class Heap {
    public static void heapSort(int[] arr) {
        int n = arr.length;

        for (int index = 1; index < n; index++) {
            int current = index;
            int parent = getParent(current);

            while (current > 0 && arr[current] > arr[parent]) {
                Sorting.swap(arr, current, parent);
                current = parent;
                parent = getParent(current);

                ++Sorting.COMPARACIONES;
                ++Sorting.MOVIMIENTOS;
            }
        }

        for (int fP = n - 1; fP > 0; fP--) {
            Sorting.swap(arr, 0, fP);
            int current = 0;
            int bCh = getBiggestChild(arr, current, fP);

            while (bCh < fP && arr[current] < arr[bCh]) {
                Sorting.swap(arr, current, bCh);
                current = bCh;
                bCh = getBiggestChild(arr, current, fP);

                ++Sorting.COMPARACIONES;
                ++Sorting.MOVIMIENTOS;
            }
        }
    }

    private static int getParent(int index) {
        return (index - 1) / 2;
    }

    private static int getBiggestChild(int[] arr, int current, int end) {
        int leftChild = 2 * current + 1;
        int rightChild = 2 * current + 2;

        if (rightChild < end && arr[leftChild] < arr[rightChild]) {
            return rightChild;
        } else {
            return leftChild;
        }
    }
}
