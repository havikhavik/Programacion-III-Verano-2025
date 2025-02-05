import java.util.*;

class Nodo implements Comparable<Nodo> {
    int vertice;
    int tiempo;

    public Nodo(int vertice, int tiempo) {
        this.vertice = vertice;
        this.tiempo = tiempo;
    }

    @Override
    public int compareTo(Nodo otro) {
        return Integer.compare(this.tiempo, otro.tiempo);
    }
}

public class Actividad4 {
    private int numVertices;
    private List<List<Nodo>> grafo;

    public Actividad4(int numVertices) {
        this.numVertices = numVertices;
        grafo = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            grafo.add(new ArrayList<>());
        }
    }

    public void agregarCarretera(int origen, int destino, int tiempo) {
        grafo.get(origen).add(new Nodo(destino, tiempo));
        grafo.get(destino).add(new Nodo(origen, tiempo)); // Si las carreteras son bidireccionales
    }

    public int[] dijkstra(int inicio) {
        PriorityQueue<Nodo> pq = new PriorityQueue<>();
        int[] tiempos = new int[numVertices];
        Arrays.fill(tiempos, Integer.MAX_VALUE);
        tiempos[inicio] = 0;
        pq.add(new Nodo(inicio, 0));

        while (!pq.isEmpty()) {
            Nodo nodoActual = pq.poll();
            int verticeActual = nodoActual.vertice;

            for (Nodo adyacente : grafo.get(verticeActual)) {
                int nuevoTiempo = tiempos[verticeActual] + adyacente.tiempo;

                if (nuevoTiempo < tiempos[adyacente.vertice]) {
                    tiempos[adyacente.vertice] = nuevoTiempo;
                    pq.add(new Nodo(adyacente.vertice, nuevoTiempo));
                }
            }
        }

        return tiempos;
    }

    public static void main(String[] args) {
        Actividad4 logistica = new Actividad4(5); // Número de centros de distribución (vértices)

        // Agregar carreteras (origen, destino, tiempo en minutos)
        logistica.agregarCarretera(0, 1, 10);
        logistica.agregarCarretera(0, 2, 5);
        logistica.agregarCarretera(1, 2, 2);
        logistica.agregarCarretera(1, 3, 1);
        logistica.agregarCarretera(2, 3, 9);
        logistica.agregarCarretera(2, 4, 2);
        logistica.agregarCarretera(3, 4, 4);

        // Centro de distribución principal es el vértice 0
        int[] tiempos = logistica.dijkstra(0);

        // Mostrar el tiempo mínimo de entrega desde el centro principal a todos los demás centros
        System.out.println("Tiempo mínimo de entrega desde el centro de distribución principal:");
        for (int i = 0; i < tiempos.length; i++) {
            System.out.println("Centro " + i + ": " + tiempos[i] + " minutos");
        }
    }
}
