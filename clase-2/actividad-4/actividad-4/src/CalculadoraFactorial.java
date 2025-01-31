/*
En Java, el tipo long puede almacenar valores de hasta 2^63 - 1, lo que significa
que solo puede calcular factoriales de números relativamente pequeños (hasta 20!).
Para factoriales más grandes, necesitamos BigInteger, que permite representar
enteros de cualquier tamaño.
*/

import java.math.BigInteger;

public class CalculadoraFactorial {

    // Factorial recursivo usando long (limitado a números ≤ 20)
    public static long calcularFactorialLong(int numero) {
        if (numero <= 0) return 1; // Caso base
        return numero * calcularFactorialLong(numero - 1);
    }

    // Factorial recursivo usando BigInteger (para valores grandes)
    public static BigInteger calcularFactorialBigInteger(int numero) {
        if (numero <= 0) return BigInteger.ONE; // Caso base
        return BigInteger.valueOf(numero).multiply(calcularFactorialBigInteger(numero - 1));
    }

    public static void main(String[] args) {
        int numero = 20; // Puedes probar con diferentes valores

        System.out.println("Factorial de " + numero + " con long: " + calcularFactorialLong(numero));
        System.out.println("Factorial de " + numero + " con BigInteger: " + calcularFactorialBigInteger(numero));

        // Prueba con un número grande
        int numeroGrande = 50;
        System.out.println("Factorial de " + numeroGrande + " con BigInteger: " + calcularFactorialBigInteger(numeroGrande));
    }
}
