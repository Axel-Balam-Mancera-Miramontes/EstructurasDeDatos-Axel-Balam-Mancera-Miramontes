package tarea8.utils.Sorting;

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
                while (j >= h) {
                    ++Sorting.COMPARACIONES;
                    if (array[j] < array[j - h]) {
                        Sorting.swap(array, j, j - h);
                        ++Sorting.MOVIMIENTOS;
                        j = j - h;
                    } else {
                        break;
                    }
                }
            }
            h = h / 3;
        }
    }
}
