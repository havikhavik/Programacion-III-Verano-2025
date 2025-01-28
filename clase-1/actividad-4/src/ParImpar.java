import java.util.Scanner;

public class ParImpar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce un número entero: ");
        int n = scanner.nextInt();

        // Imprimir los números del 1 al n indicando si son pares o impares
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                System.out.println(i + " es par");
            } else {
                System.out.println(i + " es impar");
            }
        }

        scanner.close();
    }
}
