public class App {
    static int maxValor = 0;

    public static void main(String[] args) {
        int[] pesos = {2, 5, 6, 7};
        int[] valores = {4, 2, 1, 6};
        int capacidad = 10;

        mochilaFuerzaBruta(0, 0, 0, pesos, valores, capacidad);
        System.out.println("Valor máximo con fuerza bruta: " + maxValor);

        mochilaDinamica(pesos, valores, capacidad);
    }

    public static void mochilaFuerzaBruta(int i, int pesoActual, int valorActual, int[] pesos, int[] valores, int capacidad) {
        if (pesoActual > capacidad) {
            return; // Si sobrepasa el peso, se descarta
        }
        if (i == pesos.length) { // Si ya evaluamos todos los objetos
            maxValor = Math.max(maxValor, valorActual);
            return;
        }
        // Opción 1: No incluir el objeto i
        mochilaFuerzaBruta(i + 1, pesoActual, valorActual, pesos, valores, capacidad);
        // Opción 2: Incluir el objeto i
        mochilaFuerzaBruta(i + 1, pesoActual + pesos[i], valorActual + valores[i], pesos, valores, capacidad);
    }

    public static void mochilaDinamica(int[] pesos, int[] valores, int capacidad) {
        int n = pesos.length;

        int[][] dp = new int[n + 1][capacidad + 1];

        // i es el número de objetos considerados y j es la capacidad restante.
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= capacidad; j++) {
                if (pesos[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], valores[i - 1] + dp[i - 1][j - pesos[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println("Valor máximo con programación dinámica: " + dp[n][capacidad]);
    }
}