import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Almacen {
    private int id;
    private String nombre;

    public Almacen(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }
}

class GrafoAlmacenes {
    private Map<Integer, Almacen> almacenes;
    private Map<Integer, LinkedList<Integer>> adj;

    public GrafoAlmacenes() {
        almacenes = new HashMap<>();
        adj = new HashMap<>();
    }

    public void agregarAlmacen(int id, String nombre) {
        Almacen almacen = new Almacen(id, nombre);
        almacenes.put(id, almacen);
        adj.putIfAbsent(id, new LinkedList<>());
    }

    public void conectarAlmacenes(int id1, int id2) {
        adj.get(id1).add(id2);
        adj.get(id2).add(id1);
    }

    private void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(almacenes.get(v).getNombre() + " ");

        for (int neighbor : adj.get(v)) {
            if (!visited[neighbor]) {
                DFSUtil(neighbor, visited);
            }
        }
    }

    public void DFS(int start) { // Depth-First Search
        boolean[] visited = new boolean[almacenes.size()];
        DFSUtil(start, visited);
    }

    public void BFS(int start) { // Breadth-First Search
        boolean[] visited = new boolean[almacenes.size()];
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(almacenes.get(v).getNombre() + " ");
            
            for (int neighbor : adj.get(v)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        int start = 0;
        GrafoAlmacenes grafoAlmacenes = new GrafoAlmacenes();
        
        grafoAlmacenes.agregarAlmacen(0, "Almacen A");
        grafoAlmacenes.agregarAlmacen(1, "Almacen B");
        grafoAlmacenes.agregarAlmacen(2, "Almacen C");
        grafoAlmacenes.agregarAlmacen(3, "Almacen D");
        
        grafoAlmacenes.conectarAlmacenes(0, 1);
        grafoAlmacenes.conectarAlmacenes(0, 2);
        grafoAlmacenes.conectarAlmacenes(1, 3);
        grafoAlmacenes.conectarAlmacenes(2, 3);
        
        System.out.println("Recorrido DFS desde " + grafoAlmacenes.almacenes.get(start).getNombre() + ":");
        grafoAlmacenes.DFS(start);
        
        System.out.println("\nRecorrido BFS desde " + grafoAlmacenes.almacenes.get(start).getNombre() + ":");
        grafoAlmacenes.BFS(start);
    }
}
