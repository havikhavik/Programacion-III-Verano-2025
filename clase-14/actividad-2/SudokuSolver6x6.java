public class SudokuSolver6x6 {

    private static final int SIZE = 6;
    private static final int SUBGRID_ROWS = 2;
    private static final int SUBGRID_COLS = 3;

    public static void main(String[] args) {
        int[][] board = {
                {5, 3, 0, 0, 6, 0},
                {6, 0, 0, 5, 0, 3},
                {0, 6, 3, 0, 0, 0},
                {0, 0, 0, 3, 5, 0},
                {3, 0, 5, 0, 0, 6},
                {0, 5, 0, 0, 3, 1}
        };

        if (solveSudoku(board)) {
            printBoard(board);
        } else {
            System.out.println("No existe solución para este Sudoku.");
        }
    }

    public static boolean solveSudoku(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == 0) {
                    for (int num = 1; num <= SIZE; num++) {
                        if (isValid(board, row, col, num)) {
                            board[row][col] = num;

                            if (solveSudoku(board)) {
                                return true;
                            }

                            board[row][col] = 0;
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(int[][] board, int row, int col, int num) {
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

        int startRow = (row / SUBGRID_ROWS) * SUBGRID_ROWS;
        int startCol = (col / SUBGRID_COLS) * SUBGRID_COLS;

        for (int i = 0; i < SUBGRID_ROWS; i++) {
            for (int j = 0; j < SUBGRID_COLS; j++) {
                if (board[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void printBoard(int[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }
}