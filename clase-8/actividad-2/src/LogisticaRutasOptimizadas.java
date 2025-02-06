
import java.util.Scanner;

public class LogisticaRutasOptimizadas {
    final static int INF = 99999;  // Usamos un valor grande para representar el infinito

    public static void main(String[] args) {
        LogisticaRutasOptimizadas logistica = new LogisticaRutasOptimizadas();
        int tiempoViaje[][] = {
                {0, 8, 5},
                {3, 0, INF},
                {INF, 2, 0}
        };
        int numCentros = tiempoViaje.length;
        logistica.optimizarRutas(tiempoViaje, numCentros);

        // Pedir centros de distribución de origen y destino
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el centro de distribución de origen (0 a " + (numCentros - 1) + "): ");
        int origen = sc.nextInt();
        System.out.print("Ingrese el centro de distribución de destino (0 a " + (numCentros - 1) + "): ");
        int destino = sc.nextInt();

        // Imprimir el camino más corto entre el origen y el destino
        System.out.print("El camino más corto desde " + origen + " hasta " + destino + " es: ");
        logistica.imprimirRuta(origen, destino);
        sc.close();
    }

    // Variables de instancia para la matriz de tiempos y la matriz de recuperación de rutas
    int[][] tiempoMinimo;
    int[][] ruta; // Matriz de recuperación de rutas

    // Algoritmo de Floyd-Warshall
    void optimizarRutas(int tiempoViaje[][], int numCentros) {
        tiempoMinimo = new int[numCentros][numCentros];
        ruta = new int[numCentros][numCentros]; // Inicializamos la matriz ruta

        // Inicializar las matrices de tiempos y recuperación de rutas
        for (int i = 0; i < numCentros; i++) {
            for (int j = 0; j < numCentros; j++) {
                tiempoMinimo[i][j] = tiempoViaje[i][j];
                if (i != j && tiempoViaje[i][j] != INF) {
                    ruta[i][j] = i; // Si hay una ruta directa entre i y j, el antecesor es i
                } else {
                    ruta[i][j] = -1; // Si no hay ruta, se inicializa como -1
                }
            }
        }

        // Aplicar el algoritmo de Floyd-Warshall
        for (int k = 0; k < numCentros; k++) {
            for (int i = 0; i < numCentros; i++) {
                for (int j = 0; j < numCentros; j++) {
                    if (tiempoMinimo[i][k] != INF && tiempoMinimo[k][j] != INF && tiempoMinimo[i][k] + tiempoMinimo[k][j] < tiempoMinimo[i][j]) {
                        tiempoMinimo[i][j] = tiempoMinimo[i][k] + tiempoMinimo[k][j];
                        ruta[i][j] = ruta[k][j]; // Guardamos el centro intermedio que permitió reducir el tiempo
                    }
                }
            }
        }

        // Imprimir la matriz de tiempos mínimos
        imprimirSolucion(tiempoMinimo, numCentros);
    }

    // Función para imprimir el camino más corto usando la matriz ruta
    void imprimirRuta(int origen, int destino) {
        if (ruta[origen][destino] == -1) {
            System.out.println("No hay ruta entre " + origen + " y " + destino);
            return;
        }
        imprimirRutaRecursiva(origen, destino);
        System.out.println(destino); // Finalmente imprimimos el destino
    }

    // Método recursivo para reconstruir la ruta desde origen hasta destino
    void imprimirRutaRecursiva(int origen, int destino) {
        if (ruta[origen][destino] == origen) {
            System.out.print(origen + " -> ");
            return;
        }
        imprimirRutaRecursiva(origen, ruta[origen][destino]);
        System.out.print(ruta[origen][destino] + " -> ");
    }

    // Función para imprimir la matriz de tiempos mínimos
    void imprimirSolucion(int tiempoMinimo[][], int numCentros) {
        System.out.println("Matriz de tiempos mínimos entre cada par de centros de distribución:");
        for (int i = 0; i < numCentros; i++) {
            for (int j = 0; j < numCentros; j++) {
                if (tiempoMinimo[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(tiempoMinimo[i][j] + "   ");
            }
            System.out.println();
        }
    }
}
