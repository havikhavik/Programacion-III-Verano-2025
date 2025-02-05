public class App {
    
    public static void main(String[] args) {
        GrafoDirigidoConPeso grafo = new GrafoDirigidoConPeso(5);
        grafo.agregarArista(0, 1, 2);
        grafo.agregarArista(0, 3, 6);
        grafo.agregarArista(1, 2, 3);
        grafo.agregarArista(1, 3, 8);
        grafo.agregarArista(1, 4, 5);
        grafo.agregarArista(2, 4, 7);
        grafo.agregarArista(3, 4, 9);

        grafo.mostrarGrafo();
        grafo.primMST();
    }

}
