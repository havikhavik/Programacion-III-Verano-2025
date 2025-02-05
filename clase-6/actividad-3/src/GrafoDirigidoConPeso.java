import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class GrafoDirigidoConPeso {
    private int numVertices;
    private List<List<Arista>> listaAdyacencia;

    public GrafoDirigidoConPeso(int numVertices) {
        this.numVertices = numVertices;
        listaAdyacencia = new ArrayList<>();
        for (int i = 0; i < numVertices; i++) {
            listaAdyacencia.add(new ArrayList<>());
        }
    }

    public void agregarArista(int origen, int destino, int peso) {
        listaAdyacencia.get(origen).add(new Arista(origen, destino, peso));
        listaAdyacencia.get(destino).add(new Arista(destino, origen, peso));
    }

    public void mostrarGrafo() {
        listaAdyacencia.forEach(aristas -> {
            aristas.forEach(arista -> 
                System.out.println(arista.origen + " -> " + arista.destino + ", peso: " + arista.peso)
            );
        });
    }

    public void primMST() { //minimum cost spanning tree
        boolean[] visitado = new boolean[numVertices]; //Array para marcar qué vértices ya han sido incluidos en el MST
        PriorityQueue<Arista> pq = new PriorityQueue<>();
        List<Arista> resultado = new ArrayList<>();
        int costoTotal = 0;

        visitado[0] = true; //Se marca el nodo 0 como visitado, comienza desde este nodo
        pq.addAll(listaAdyacencia.get(0)); //Se agregan las aristas conectadas al nodo 0 a la cola de prioridad

        while (!pq.isEmpty() && resultado.size() < numVertices - 1) {
            Arista arista = pq.poll(); //Se extrae la arista de menor costo
            if (visitado[arista.destino]) {
                continue; //Si el destino ya está en el MST, se ignora
            }
            visitado[arista.destino] = true; //Se marca el nuevo nodo como visitado
            resultado.add(arista); //Se agrega la arista al MST
            costoTotal += arista.peso; //Se suma el costo de la arista al costo total
            
            //Se recorren todas las aristas del nodo recién agregado
            for (Arista adyacente : listaAdyacencia.get(arista.destino)) {
                if (!visitado[adyacente.destino]) {
                    pq.add(adyacente); //Si el nodo destino no ha sido visitado, se agrega a la cola de prioridad
                }
            }
        }

        System.out.println("Árbol de Recubrimiento Mínimo:");
        for (Arista arista : resultado) {
            System.out.println(arista.origen + " - " + arista.destino + " (Costo: " + arista.peso + ")");
        }
        System.out.println("Costo total: " + costoTotal);
    }

}