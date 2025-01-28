public class App {
    public static void main(String[] args) throws Exception {
        actividad1();
    }

    static void actividad1() {
        int[][] mat = {{4,5,6},{7,8,9},{5,6,7}}; 
        int suma = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat.length; j++) {
                suma += mat[i][j];
            }
        }
        double promedio = (double) suma / (mat.length * mat.length);
        System.out.println("Promedio: " + promedio);
    }
}
