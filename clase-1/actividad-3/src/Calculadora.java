import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Introduce el primer número: ");
            double numero1 = scanner.nextDouble();

            System.out.print("Introduce el segundo número: ");
            double numero2 = scanner.nextDouble();

            // Solicitar la operación matemática
            System.out.print("Elige una operación (suma, resta, multiplicación, división): ");
            String operacion = scanner.next();

            double resultado = 0;

            // Estructura de control para realizar la operación seleccionada
            switch (operacion.toLowerCase()) {
                case "suma":
                    resultado = numero1 + numero2;
                    break;
                case "resta":
                    resultado = numero1 - numero2;
                    break;
                case "multiplicación":
                    resultado = numero1 * numero2;
                    break;
                case "division":
                    if (numero2 == 0) {
                        throw new ArithmeticException("Error: No se puede dividir por cero.");
                    }
                    resultado = numero1 / numero2;
                    break;
                default:
                    System.out.println("Operación no válida.");
                    return; // Terminar el programa si la operación no es válida
            }

            // Mostrar el resultado
            System.out.println("El resultado de la " + operacion + " es: " + resultado);
        } catch (ArithmeticException e) {
            // Manejar la excepción de division por cero
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocurrio un error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
