public class MochilaFuerzaBruta {

    // Método para encontrar el valor máximo usando fuerza bruta
    // Complejidad: O(2^n) - Exponencial
    // Debido a que cada objeto puede estar o no estar en la mochila, hay 2^n posibles combinaciones.
    public static int mochilaFuerzaBruta(int[] pesos, int[] valores, int capacidad, int n) {
        // Caso base: sin objetos o sin capacidad en la mochila
        if (n == 0 || capacidad == 0) {
            return 0;
        }

        // Si el peso del objeto es mayor que la capacidad, no se puede incluir
        if (pesos[n - 1] > capacidad) {
            return mochilaFuerzaBruta(pesos, valores, capacidad, n - 1);
        } else {
            // Opción 1: No incluir el objeto n-1
            int valorSinIncluir = mochilaFuerzaBruta(pesos, valores, capacidad, n - 1);

            // Opción 2: Incluir el objeto n-1
            int valorIncluir = valores[n - 1] + mochilaFuerzaBruta(pesos, valores, capacidad - pesos[n - 1], n - 1);

            // Retornar el máximo de las dos opciones
            return Math.max(valorSinIncluir, valorIncluir);
        }
    }

    public static void main(String[] args) {
        int[] pesos = {1, 2, 3, 4};
        int[] valores = {10, 20, 30, 40};
        int capacidad = 6;
        int n = pesos.length;

        int valorMaximo = mochilaFuerzaBruta(pesos, valores, capacidad, n);
        System.out.println("Valor máximo (Fuerza Bruta): " + valorMaximo);
    }
}
