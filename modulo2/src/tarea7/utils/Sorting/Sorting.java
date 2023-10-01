package tarea7.utils.Sorting;


import java.util.Arrays;
import java.util.Random;

import static tarea7.utils.Sorting.Bubble.*;
import static tarea7.utils.Sorting.Insertion.*;
import static tarea7.utils.Sorting.Selection.*;
import static tarea7.utils.Sorting.Shell.*;

public class Sorting {
    public static int COMPARACIONES = 0;
    public static int MOVIMIENTOS = 0;
    public static void testPerformance() {
        final int RANGO = 1_000;
        final int ITERACIONES = 500;
        final int INCREMENTOS = 100;

        double[][] performanceResults = new double[RANGO / INCREMENTOS][2];
        for (int N = 1, k = 0; N <= RANGO; N += INCREMENTOS, k++) {
            // llamar 500 veces cada algoritmo
            COMPARACIONES = 0;
            MOVIMIENTOS = 0;
            for (int i = 0; i < ITERACIONES; i++) {
                int[] array = getRandomArray(N, Short.MIN_VALUE, Integer.MAX_VALUE);
                selectionSort(array);

            }
            performanceResults[k][0] += COMPARACIONES;
            performanceResults[k][1] += MOVIMIENTOS;
            performanceResults[k][0] = performanceResults[k][0] / ((double) ITERACIONES);
            performanceResults[k][1] = performanceResults[k][1] / ((double) ITERACIONES);
        }


        System.out.println("{algoritmo}: ");
        System.out.println(performanceResults.length);
        for(double[] results: performanceResults)
            System.out.println(Arrays.toString(results).replace("[","").replace("]","").replace(",",""));
    }
    public static int[] getRandomArray(int n, int minVal, int maxVal) {
        Random random = new Random();
        return random.ints(n, minVal, maxVal).toArray();
    }

    public static void swap(int[] N, int i, int j) {
        int aux = N[i];
        N[i] = N[j];
        N[j] = aux;
    }
}
