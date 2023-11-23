package tarea7.utils.Sorting;

import static tarea7.utils.Sorting.Sorter.*;

public class SorterFactory {
    public static Sorter getSorter(SorterMethods method){

        return switch (method){
            case BUBBLE -> new Sorter(){
                @Override
                public void sort(int[] A) {
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
            };

            case SELECTION -> new Sorter(){

                @Override
                public void sort(int[] N) {
                    for(int i=0;i<N.length-1;i++){
                        int minIndex=i;
                        for(int j=i+1;j<N.length;j++){
                            COMPARACIONES++;
                            if(N[minIndex]>N[j]){
                                minIndex = j;
                            }
                        }
                        if(minIndex!=i){
                            MOVIMIENTOS++;
                            swap(N,minIndex,i);
                        }
                    }
                }
            };
            case INSERTION -> new Sorter(){
                @Override
                public void sort(int[] array) {
                    for (int i = 1; i < array.length; i++) {
                        int current = array[i];
                        int j = i - 1;

                        while (j >= 0 && array[j] > current) {
                            array[j + 1] = array[j];
                            j--;
                        }

                        array[j + 1] = current;
                    }
                }
            };

            case SHELL -> new Sorter(){
                @Override
                public void sort(int[] array) {
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
            };

            default -> throw new IllegalStateException("Unexpected value: " + method);
        };

    }
}
