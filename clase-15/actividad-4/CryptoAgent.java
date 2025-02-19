import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class CryptoAgent {
    private int[][] nodos; // Cada nodo tiene [monto de cobro/pago, tasa de volatilidad en centésimas]
    private double tasaVolatilidad;
    private double maxSaldoFinal;

    public CryptoAgent(int[][] nodos, double tasaVolatilidad) {
        // Ordenar nodos priorizando mayores cobros
        Arrays.sort(nodos, (a, b) -> Integer.compare(b[0], a[0]));
        this.nodos = nodos;
        this.tasaVolatilidad = tasaVolatilidad;
        this.maxSaldoFinal = 0;
    }

    private void backtracking(double saldo, HashSet<Integer> visitados) {
        // Convertir saldo a dólares con volatilidad
        double saldoEnDolares = saldo * (1 + tasaVolatilidad);
        maxSaldoFinal = Math.max(maxSaldoFinal, saldoEnDolares);

        for (int i = 0; i < nodos.length; i++) {
            if (!visitados.contains(i)) { // No visitar un nodo dos veces
                int cobroPago = nodos[i][0];

                // Poda: Si no hay saldo suficiente para pagar, descartar esta rama
                if (saldo + cobroPago < 0) {
                    continue;
                }

                // Continuar con el siguiente nodo
                visitados.add(i);
                backtracking(saldo + cobroPago, visitados);
                visitados.remove(i); // Retroceder en la búsqueda
            }
        }
    }

    public double maximizarSaldo(double saldoInicial) {
        backtracking(saldoInicial, new HashSet<>());
        return maxSaldoFinal;
    }

    public static void main(String[] args) {
        // Ejemplo de nodos con [monto de cobro/pago, tasa de volatilidad *100 (para referencia)]
        int[][] nodos = {{50, 120}, {-30, 130}, {20, 110}, {-10, 120}, {40, 150}};
        double tasaVolatilidad = 0.05; // 5% de variación en el mercado

        CryptoAgent agente = new CryptoAgent(nodos, tasaVolatilidad);
        double saldoInicial = 50;
        double saldoFinal = agente.maximizarSaldo(saldoInicial);

        System.out.printf("Saldo final máximo en dólares: %.2f\n", saldoFinal);
    }
}