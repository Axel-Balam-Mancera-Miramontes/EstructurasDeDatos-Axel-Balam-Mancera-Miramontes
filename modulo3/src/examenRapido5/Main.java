package examenRapido5;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int n = 8;
        NQueensProblem nQueens = new NQueensProblem(n);
        List<int[]> solutions = nQueens.solveNQueensProblem();

        System.out.println("Existen " + solutions.size() + " soluciones diferentes para resolver el problema de las "
                + n + " reinas en un tablero de ajedrez de dimensiones de " + n + " * " + n + ":");
        for (int[] solution : solutions) {
            for (int i = 0; i < n; i++) {
                System.out.print(solution[i] + " ");
            }
            System.out.println();
        }
    }
}
