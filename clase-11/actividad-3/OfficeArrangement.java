import java.util.ArrayList;
import java.util.List;

public class OfficeArrangement {
    private static final int N = 4; // Tamaño del tablero
    private static final char EMPTY = '.';
    private static final char COMPUTER = 'C';
    private static final char PRINTER = 'P';

    public static void main(String[] args) {
        char[][] office = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                office[i][j] = EMPTY;
            }
        }
        List<char[][]> solutions = new ArrayList<>();
        placeComputers(office, 0, new boolean[N], new boolean[N], solutions);
        System.out.println("Se encontraron " + solutions.size() + " configuraciones válidas.");
    }

    private static void placeComputers(char[][] office, int row, boolean[] usedColsC, boolean[] usedColsP, List<char[][]> solutions) {
        if (row == N) {
            placePrinters(office, 0, usedColsP, solutions);
            return;
        }

        for (int col = 0; col < N; col++) {
            if (!usedColsC[col]) {
                office[row][col] = COMPUTER;
                usedColsC[col] = true;
                placeComputers(office, row + 1, usedColsC, usedColsP, solutions);
                office[row][col] = EMPTY;
                usedColsC[col] = false;
            }
        }
    }

    private static void placePrinters(char[][] office, int row, boolean[] usedColsP, List<char[][]> solutions) {
        if (row == N) {
            saveSolution(office, solutions);
            return;
        }

        for (int col = 0; col < N; col++) {
            if (office[row][col] == EMPTY && !usedColsP[col]) {
                office[row][col] = PRINTER;
                usedColsP[col] = true;
                placePrinters(office, row + 1, usedColsP, solutions);
                office[row][col] = EMPTY;
                usedColsP[col] = false;
            }
        }
    }

    private static void saveSolution(char[][] office, List<char[][]> solutions) {
        char[][] savedConfig = new char[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(office[i], 0, savedConfig[i], 0, N);
        }
        solutions.add(savedConfig);
        printOffice(savedConfig);
    }

    private static void printOffice(char[][] office) {
        for (char[] row : office) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
