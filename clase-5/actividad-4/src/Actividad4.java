import java.util.*;

public class Actividad4 {

    // Complete the getMinimumCost function below.
    static int getMinimumCost(int k, int[] c) {
        if (c.length == 0 || k == 0) {
            return 0; // casos base
        }

        if (k == c.length) { // hay un amigo para cada flor
            int precioTotal = 0;
            for (int i = 0; i < c.length; i++) {
                precioTotal += c[i];
            }
            return precioTotal;
        } else if (k < c.length) { // el grupo de amigos es menor que la cantidad de flores
            Arrays.sort(c);
            int[] reverseSortedArray = new int[c.length];
            for (int i = 0; i < c.length; i++) {
                reverseSortedArray[i] = c[c.length - 1 - i];
            }
            c = reverseSortedArray;

            int precioTotal = 0;
            int comprasAnteriores = 0;

            for (int i = 0; i < c.length; i++) {
                precioTotal += (comprasAnteriores / k + 1) * c[i];
                comprasAnteriores++;
            }
            return precioTotal;
        }

        return 0;
    }

    public static void main(String[] args) {
        // Aquí puedes definir los parámetros manualmente
        int n = 6; // Número de flores
        int k = 3; // Número de amigos
        int[] c = {2, 5, 6, 1, 3, 4}; // Costos de las flores

        // Calcular el costo mínimo
        int minimumCost = getMinimumCost(k, c);

        // Imprimir el costo mínimo en la consola
        System.out.println(minimumCost);
    }
}
