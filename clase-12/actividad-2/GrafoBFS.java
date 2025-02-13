import java.util.*;

public class GrafoBFS {
    private int cantidadVertices; // Número de vértices
    private LinkedList<Integer>[] listaAdyacencia; // Lista de adyacencia

    public GrafoBFS(int cantidadVertices) {
        this.cantidadVertices = cantidadVertices;
        listaAdyacencia = new LinkedList[cantidadVertices];
        for (int i = 0; i < cantidadVertices; i++) {
            listaAdyacencia[i] = new LinkedList<>();
        }
    }

    public void agregarArista(int origen, int destino) {
        listaAdyacencia[origen].add(destino);
        listaAdyacencia[destino].add(origen); // Es un grafo no dirigido
    }

    public void recorridoBFS(int nodoInicial) {
        boolean[] visitado = new boolean[cantidadVertices];
        Queue<Integer> cola = new LinkedList<>();

        visitado[nodoInicial] = true;
        cola.add(nodoInicial);

        while (!cola.isEmpty()) {
            int nodo = cola.poll();
            System.out.print(nodo + " ");

            for (int vecino : listaAdyacencia[nodo]) {
                if (!visitado[vecino]) {
                    visitado[vecino] = true;
                    cola.add(vecino);
                }
            }
        }
    }

    public static void main(String[] args) {
        GrafoBFS grafo = new GrafoBFS(9);

        // Agregamos las conexiones del grafo según la imagen
        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 2);
        grafo.agregarArista(2, 5);
        grafo.agregarArista(1, 3);
        grafo.agregarArista(1, 4);
        grafo.agregarArista(3, 6);
        grafo.agregarArista(4, 7);
        grafo.agregarArista(4, 8);

        System.out.println("Recorrido BFS desde el nodo 0:");
        grafo.recorridoBFS(0);
    }
}