import java.util.Arrays;

public class FloydWarshall {
    static final int infinito = 99999; // Un valor grande para representar infinito

    public static void main(String[] args) {
        int matriz[][] = {
            {0, 2, infinito, 5},
            {infinito, 0, infinito, 4},
            {infinito, infinito, 0, infinito},
            {infinito, infinito, 2, 0}
        };

        floydWarshall(matriz);
    }

    public static void floydWarshall(int matriz[][]) {
        int length = matriz.length;
        int matrizDist[][] = new int[length][length];

        // Copiamos la matriz de adyacencia en la matriz de distancias
        for (int i = 0; i < length; i++) {
            matrizDist[i] = Arrays.copyOf(matriz[i], length);
        }

        // Algoritmo de Floyd-Warshall
        for (int k = 0; k < length; k++) {
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    if (matrizDist[i][k] != infinito && matrizDist[k][j] != infinito && 
                        matrizDist[i][k] + matrizDist[k][j] < matrizDist[i][j]) {
                            matrizDist[i][j] = matrizDist[i][k] + matrizDist[k][j];
                    }
                }
            }
        }

        imprimirMatriz(matrizDist);
    }

    public static void imprimirMatriz(int matrizDist[][]) {
        System.out.println("Matriz de distancias mínimas entre nodos:");
        for (int i = 0; i < matrizDist.length; i++) {
            for (int j = 0; j < matrizDist.length; j++) {
                if (matrizDist[i][j] == infinito)
                    System.out.print("∞ ");
                else
                    System.out.print(matrizDist[i][j] + " ");
            }
            System.out.println();
        }
    }

}