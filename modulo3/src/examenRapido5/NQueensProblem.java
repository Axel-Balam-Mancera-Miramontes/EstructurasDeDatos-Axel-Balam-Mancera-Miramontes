package examenRapido5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueensProblem {
    // An array to represent the chessboard
    private int[] chessBoard;

    // The size of the chessboard
    private int chessBoardSize;

    // List to store the solutions
    private List<int[]> solutions;

    public NQueensProblem(int chessBoardSize) {
        this.chessBoardSize = chessBoardSize;
        this.chessBoard = new int[chessBoardSize];
        this.solutions = new ArrayList<>();
    }

    // Solve the N-Queens problem and return a list of solutions
    public List<int[]> solveNQueensProblem() {
        // Start placing queens from the first row (row 0)
        placeQueens(0);

        // Return the list of solutions
        return solutions;
    }

    // Recursive function to place queens on the chessboard
    private void placeQueens(int row) {

        // If we have successfully placed queens in all rows, add the current solution
        if (row == chessBoardSize) {
            int[] solution = Arrays.copyOf(chessBoard, chessBoard.length);
            solutions.add(solution);
            return;
        }

        // Try placing a queen in each column of the current row
        for (int col = 0; col < chessBoardSize; ++col) {
            if (canPlaceQueen(row, col)) {

                // Place the queen in the current cell
                chessBoard[row] = col;

                // Move on to the next row
                placeQueens(row + 1);
            }
        }
    }

    // Check if it's safe to place a queen in the current cell
    private boolean canPlaceQueen(int row, int col) {
        for (int i = 0; i < row; ++i) {

            // Check if there is a queen in the same column or on diagonals
            if (chessBoard[i] == col ||
                    chessBoard[i] - i == col - row ||
                    chessBoard[i] + i == col + row) {

                // It's not safe to place a queen here
                return false;
            }
        }

        // It's safe to place a queen in this cell
        return true;
    }
}
