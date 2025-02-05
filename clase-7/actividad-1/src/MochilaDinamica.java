public class MochilaDinamica {

    // Método para encontrar el valor máximo usando programación dinámica
    // Complejidad: O(n * capacidad) - Pseudopolimonial
    // La tabla dp tiene dimensiones [n+1][capacidad+1] y se llena de manera iterativa.
    public static int mochilaDinamica(int[] pesos, int[] valores, int capacidad) {
        int n = pesos.length;
        int[][] dp = new int[n + 1][capacidad + 1];

        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacidad; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0;
                } else if (pesos[i - 1] <= w) {
                    dp[i][w] = Math.max(valores[i - 1] + dp[i - 1][w - pesos[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][capacidad];
    }

    public static void main(String[] args) {
        int[] pesos = {1, 2, 3, 4};
        int[] valores = {10, 20, 30, 40};
        int capacidad = 6;

        int valorMaximo = mochilaDinamica(pesos, valores, capacidad);
        System.out.println("Valor máximo (Programación Dinámica): " + valorMaximo);
    }
}
