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

    public void primMST() { //minimum cost spanning tree
        boolean[] visitado = new boolean[numVertices];
        PriorityQueue<Arista> pq = new PriorityQueue<>();
        List<Arista> resultado = new ArrayList<>();
        int costoTotal = 0;

        visitado[0] = true;
        pq.addAll(listaAdyacencia.get(0));

        while (!pq.isEmpty() && resultado.size() < numVertices - 1) {
            Arista arista = pq.poll();
            if (visitado[arista.destino]) continue;
            
            visitado[arista.destino] = true;
            resultado.add(arista);
            costoTotal += arista.peso;
            
            for (Arista adyacente : listaAdyacencia.get(arista.destino)) {
                if (!visitado[adyacente.destino]) {
                    pq.add(adyacente);
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