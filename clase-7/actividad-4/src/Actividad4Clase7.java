import java.util.*;

public class Actividad4Clase7 {

    public static int maxGanancia(int[] costos, int[] ganancias, int presupuesto) {
        int n = costos.length;
        int[][] dp = new int[n + 1][presupuesto + 1];

        // Programación dinámica para maximizar la ganancia
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= presupuesto; j++) {
                if (costos[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - costos[i - 1]] + ganancias[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        return dp[n][presupuesto];
    }

    public static void main(String[] args) {
        
        int[] costos = {12, 20, 15, 25};
        int[] ganancias = {150, 200, 100, 300};
        int presupuesto = 35;
        
        System.out.println("Ganancia máxima obtenida: " + maxGanancia(costos, ganancias, presupuesto));
    }
}
