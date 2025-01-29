public class SumaRecursiva {
    // Costo: O(1) - Inicialización de la clase y método principal.

    public static void main(String[] args) {
        int n = 10; // Costo: O(1) - Asignación de una variable.
        int resultado = sumaRecursiva(n); // Costo: O(n) - Llamada al método recursivo.
        System.out.println("La suma de los primeros " + n + " números enteros es: " + resultado);
        // Costo: O(1) - Operación de salida.
    }

    public static int sumaRecursiva(int n) {
        // Costo: O(1) - Comparación simple.
        if (n == 1) {
            return 1; // Costo: O(1) - Retorno en el caso base.
        }
        // Llamada recursiva: sumar n más la suma de los primeros (n-1) números enteros.
        // Costo: O(n) - Llamada recursiva (dependiendo del valor de n).
        return n + sumaRecursiva(n - 1);
        // Operación de suma simple y llamada recursiva: O(1) + O(n-1) ≈ O(n)
    }
}
