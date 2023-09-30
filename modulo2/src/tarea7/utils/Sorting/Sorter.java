package tarea7.utils.Sorting;


public abstract class Sorter {
    public int COMPARACIONES = 0;
    public int MOVIMIENTOS = 0;

    public int getCOMPARACIONES() {
        return COMPARACIONES;
    }

    public int getMOVIMIENTOS() {
        return MOVIMIENTOS;
    }

    public abstract void sort(int[] N);

    public static void swap(int[] N, int i, int j) {
        int aux = N[i];
        N[i] = N[j];
        N[j] = aux;
    }

    public enum SorterMethods {
        BUBBLE,SELECTION,INSERTION,SHELL,MERGE,QUICK,HEAP
    }



}