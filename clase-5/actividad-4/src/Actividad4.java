import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Actividad4 {


    // Complete the getMinimumCost function below.
    static int getMinimumCost(int k, int[] c) {
        if (c.length == 0 || k == 0) {
            return 0; //casos base
        }

        if (k == c.length) { // hay un amigo para cada flor
            int precioTotal = 0;
            for (int i = 0; i < c.length; i++) {
                precioTotal = precioTotal + c[i];
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

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int minimumCost = getMinimumCost(k, c);

        bufferedWriter.write(String.valueOf(minimumCost));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
