package tarea13;

/**
 * Utility class to find the median in an array using the QuickSelect algorithm.
 */
public class Median {

    /**
     * Find the kth element in a list.
     *
     * @param arr    The input list.
     * @param start  The starting index of the list.
     * @param end    The ending index of the list.
     * @param k      The desired position of the element in the list.
     * @return The kth element in the list.
     */
    public int getMedian(int[] arr, int start, int end, int k) {
        if (start == end) {
            return arr[start];
        }

        int partition = partition(arr, start, end);
        int p = partition - start + 1;

        if (k == p) {
            return arr[partition];
        } else if (k < p) {
            return getMedian(arr, start, partition - 1, k);
        } else {
            return getMedian(arr, partition + 1, end, k - p);
        }
    }

    /**
     * Partition the list based on a pivot element.
     *
     * @param arr    The input list.
     * @param start  The starting index of the list.
     * @param end    The ending index of the list.
     * @return The index of the partitioned element.
     */
    public int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int i = start;

        for (int j = start; j < end; j++) {
            if (arr[j] <= pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }

        int temp = arr[i];
        arr[i] = arr[end];
        arr[end] = temp;

        return i;
    }
}
