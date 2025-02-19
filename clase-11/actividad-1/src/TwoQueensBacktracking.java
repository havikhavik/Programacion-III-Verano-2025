import java.util.ArrayList;
import java.util.List;

public class TwoQueensBacktracking {
    private static final int SIZE = 4; // Tamaño del tablero
    private static List<int[][]> solutions = new ArrayList<>();

    public static void main(String[] args) {
        int[][] board = new int[SIZE][SIZE]; // Tablero vacío
        placeQueens(board, 0, 0);

        System.out.println("Soluciones encontradas: " + solutions.size());
        for (int[][] solution : solutions) {
            printBoard(solution);
        }
    }

    private static void placeQueens(int[][] board, int row, int count) {
        if (count == 2) { // Se colocaron las dos reinas
            saveSolution(board);
            return;
        }

        for (int i = row; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (isSafe(board, i, j)) {
                    board[i][j] = 1; // Colocar reina
                    placeQueens(board, i + 1, count + 1); // Pasar a la siguiente fila
                    board[i][j] = 0; // Backtracking
                }
            }
        }
    }


    private static boolean isSafe(int[][] board, int row, int col) {
        // Verificar columna
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) return false;
        }

        // Verificar diagonal principal \
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) return false;
        }

        // Verificar diagonal secundaria /
        for (int i = row, j = col; i >= 0 && j < SIZE; i--, j++) {
            if (board[i][j] == 1) return false;
        }

        return true;
    }

    private static void saveSolution(int[][] board) {
        int[][] solution = new int[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            System.arraycopy(board[i], 0, solution[i], 0, SIZE);
        }
        solutions.add(solution);
    }

    private static void printBoard(int[][] solution) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(solution[i][j] == 1 ? " Q " : " . ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
