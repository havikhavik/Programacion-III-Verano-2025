public class Main {
    public static void main(String[] args) {
        int miEdad=29;
        double miAlturaEnMetros=1.76;
        char inicialPrimerNombre= 'L';
        String ciudadResidencia="Wilde";

        // sumar edad con un numero cualquiera
        int sumaEdadConNumeroCualquiera= miEdad+1;

        // multiplicar altura x2
        double miAlturaDuplicada= miAlturaEnMetros*2;

        // concatenar inicial con un texto para formar un mensaje como: "Tu inicial es X"
        String inicialConcatenadaConTexto= "Tu inicial es: "+ inicialPrimerNombre;

        // imprimir resultados en consola

        System.out.println("Resultados:");
        System.out.println("Suma edad con numero cualquiera: " + sumaEdadConNumeroCualquiera);
        System.out.println("Altura duplicada: " + miAlturaDuplicada);
        System.out.println(inicialConcatenadaConTexto);
        System.out.println("Ciudad de residencia: " + ciudadResidencia);



    }
}
