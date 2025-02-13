import java.util.LinkedList;

class GraphDFS {
    private int V; // Número de vértices
    private LinkedList<Integer>[] adj; // Lista de adyacencia

    public static void main(String[] args) {
        GraphDFS graphDFS = new GraphDFS(9); // Grafo con 9 nodos (0-8)

        // Agregar las aristas basadas en la imagen
        graphDFS.addEdge(0, 1);
        graphDFS.addEdge(0, 2);
        graphDFS.addEdge(1, 3);
        graphDFS.addEdge(1, 4);
        graphDFS.addEdge(2, 5);
        graphDFS.addEdge(3, 6);
        graphDFS.addEdge(4, 7);
        graphDFS.addEdge(4, 8);

        int start = 0;
        System.out.println("Recorrido DFS desde el nodo " + start + ": ");
        graphDFS.DFS(start); // Llamar DFS desde el nodo 0
    }

    // Constructor
    @SuppressWarnings("unchecked")
    public GraphDFS(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    // Método para agregar una arista al grafo
    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v); // Grafo no dirigido
    }

    // Método auxiliar para DFS
    private void DFSUtil(int v, boolean[] visited) {
        // Marcar el nodo actual como visitado e imprimirlo
        visited[v] = true;
        System.out.print(v + " ");

        // Recorrer los nodos adyacentes
        for (int neighbor : adj[v]) {
            if (!visited[neighbor]) {
                DFSUtil(neighbor, visited);
            }
        }
    }

    public void DFS(int start) { // Depth-First Search desde un nodo dado
        boolean[] visited = new boolean[V]; // Arreglo para marcar nodos visitados
        DFSUtil(start, visited);
    }
}
