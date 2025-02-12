import java.util.ArrayList;
import java.util.List;

public class OfficeArrangement {
    private static final int N = 4;

    public static void main(String[] args) {
        char[][] room = new char[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                room[i][j] = '.'; // Espacio vacío
            }
        }
        List<char[][]> rooms = new ArrayList<>();
        placeItems(room, 0, rooms);
        System.out.println("Se encontraron " + rooms.size() + " habitaciones");
    }

    private static void placeItems(char[][] room, int row, List<char[][]> rooms) {
        if (row == N) {
            rooms.add(room);
            printRoom(room);
        } else {
            for (int col = 0; col < N; col++) {
                if (isSafe(room, row, col)) {
                    room[row][col] = 'D'; // Colocar escritorio
                    placeItems(room, row + 1, rooms);
                    room[row][col] = 'S'; // Colocar silla
                    placeItems(room, row + 1, rooms);
                    room[row][col] = '.'; // Retroceder
                }
            }
        }
    }

    private static boolean isSafe(char[][] room, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (room[i][col] != '.') {
                return false; // Misma columna ocupada
            }
        }
        return true;
    }

    private static void printRoom(char[][] room) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(room[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
