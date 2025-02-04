import java.util.Arrays;

public class Actividad3{

    // Clase para representar un objeto con su valor y peso
    static class Mercancia {
        double valor, peso, ratio;

        Mercancia(double valor, double peso) {
            this.valor = valor;
            this.peso = peso;
            this.ratio = valor / peso;
        }
    }

    public static double cargaMercanciaFraccionalCamion(int capacidadMaxima, Mercancia[] mercancias) {
        // Ordenar la mercancia por la relación valor/peso en orden descendente
        Arrays.sort(mercancias, (a, b) -> Double.compare(b.ratio, a.ratio));

        double maxValue = 0.0;

        for (Mercancia mercancia : mercancias) {
            if (capacidadMaxima == 0) break; // Si el camion está lleno, terminar

            if (mercancia.peso <= capacidadMaxima) {
                // Tomar la mercancia completa
                maxValue += mercancia.valor;
                capacidadMaxima -= mercancia.peso;
            } else {
                // Tomar solo la fracción de la mercancia que cabe en el camion
                maxValue += mercancia.valor * ((double) capacidadMaxima / mercancia.peso);
                capacidadMaxima = 0;
            }
        }

        return maxValue;
    }

    public static void main(String[] args) {
        Mercancia[] mercancias = {
                new Mercancia(30, 10),
                new Mercancia(50, 20),
                new Mercancia(60, 30)
        };

        int capacidadMaxima = 50; //capacidad maxima de la mochila

        System.out.println("Valor máximo obtenido = " + cargaMercanciaFraccionalCamion(capacidadMaxima, mercancias));
    }
}