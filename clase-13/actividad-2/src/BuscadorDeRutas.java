import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

class Ruta implements Comparable<Ruta> {
    String ciudad;
    int costo;
    List<String> camino;

    public Ruta(String ciudad, int costo, List<String> camino) {
        this.ciudad = ciudad;
        this.costo = costo;
        this.camino = new ArrayList<>(camino);
    }

    @Override
    public int compareTo(Ruta otra) {
        return Integer.compare(this.costo, otra.costo); // Ordena por costo mínimo
    }
}

class Grafo {
    private final Map<String, List<Ruta>> mapaRutas = new HashMap<>();

    public void agregarRuta(String origen, String destino, int costo) {
        mapaRutas.putIfAbsent(origen, new ArrayList<>());
        mapaRutas.get(origen).add(new Ruta(destino, costo, Arrays.asList(origen, destino)));
    }

    public List<String> encontrarRutaMasBarata(String origen, String destino) {
        PriorityQueue<Ruta> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Ruta(origen, 0, Arrays.asList(origen)));

        Set<String> visitados = new HashSet<>();

        while (!priorityQueue.isEmpty()) {
            Ruta actual = priorityQueue.poll();
            String ciudadActual = actual.ciudad;

            if (ciudadActual.equals(destino)) {
                System.out.println("Costo mínimo: $" + actual.costo);
                return actual.camino;
            }

            if (!visitados.contains(ciudadActual)) {
                visitados.add(ciudadActual);
                
                if (mapaRutas.containsKey(ciudadActual)) {
                    for (Ruta vecino : mapaRutas.get(ciudadActual)) {
                        if (!visitados.contains(vecino.ciudad)) {
                            List<String> nuevoCamino = new ArrayList<>(actual.camino);
                            nuevoCamino.add(vecino.ciudad);
                            priorityQueue.add(new Ruta(vecino.ciudad, actual.costo + vecino.costo, nuevoCamino));
                        }
                    }
                }
            }
        }
        return Collections.singletonList("No hay ruta disponible.");
    }
}

public class BuscadorDeRutas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Grafo grafo = new Grafo();
        grafo.agregarRuta("A", "B", 100);
        grafo.agregarRuta("A", "C", 300);
        grafo.agregarRuta("B", "D", 200);
        grafo.agregarRuta("C", "D", 100);
        grafo.agregarRuta("B", "C", 50);
        grafo.agregarRuta("D", "E", 150);
        grafo.agregarRuta("C", "E", 250);

        System.out.print("Ingrese la ciudad de origen: ");
        String origen = scanner.nextLine().toUpperCase();
        System.out.print("Ingrese la ciudad de destino: ");
        String destino = scanner.nextLine().toUpperCase();

        List<String> ruta = grafo.encontrarRutaMasBarata(origen, destino);
        System.out.println("Ruta más barata: " + String.join(" -> ", ruta));
    }
}