package tarea7.utils.Sorting;

public class Shell {
    public static void shellSort(int[] array) {
        int n = array.length;

        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < n; i++) {
                int j = i;
                while (j >= h && array[j] < array[j - h]) {
                    swap(array, j, j - h);
                    j = j - h;
                }
            }
            h = h / 3;
        }
    }

    public static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
