public class App {
    public static void main(String[] args) throws Exception {
        actividad1();
    }

    /**
     * Por consenso 
     * f(n) = 8n^2 + 5n + 8
     * 8n^2 + 5n + 8 <= c n^2
     * 8n^2/n^2 + 5n/n^2 + 8/n^2 <= c n^2/n^2
     * 8 + 5 + 8 <= c
     * 21 <= 21
     * Por lo que f(n) = 8n^2 + 5n + 8 pertenece a O(n^2) para c = 21 y nO = 1
     */
    static void actividad1() {
        int[][] mat = {{4,5,6},{7,8,9},{5,6,7}}; // 1
        int suma = 0; // 1
        for (int i = 0; i < mat.length; i++) { // 1 + 2(n+1) + n = 3 + 3n
            for (int j = 0; j < mat.length; j++) { // 1 + 2(n+1) + n = 3 + 3n
                suma += mat[i][j];
            }
        }
        double promedio = (double) suma / (mat.length * mat.length); // 2
        System.out.println("Promedio: " + promedio); // 2
    }
}
