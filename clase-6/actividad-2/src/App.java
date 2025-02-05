public class App {
    public static void main(String[] args) {
        GrafoDirigido grafo = new GrafoDirigido(5);
        
        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 2);
        grafo.agregarArista(1, 3);
        grafo.agregarArista(3, 4);
        
        System.out.println("Matriz de Adyacencia:");
        grafo.mostrarMatriz();
        
        System.out.println("Adyacentes de vertice 0: " + grafo.listarAdyacentes(0));
        System.out.println("Adyacentes de vertice 1: " + grafo.listarAdyacentes(1));
        System.out.println("Adyacentes de vertice 3: " + grafo.listarAdyacentes(3));
        System.out.println("Adyacentes de vertice 4: " + grafo.listarAdyacentes(4));

        /*
         * Grado de entrada: Es el número de aristas que llegan a un vértice.
         * Grado de salida: Es el número de aristas que salen de un vértice.
         */
        System.out.println("Grado de salida (fila) de vertice 0: " + grafo.contarGradoSalida(0));
        System.out.println("Grado de entrada (columna) de vertice 0: " + grafo.contarGradoEntrada(0));
        System.out.println("Grado de salida (fila) de vertice 3: " + grafo.contarGradoSalida(3));
        System.out.println("Grado de entrada (columna) de vertice 3: " + grafo.contarGradoEntrada(3));
        System.out.println("Grado de salida (fila) de vertice 4: " + grafo.contarGradoSalida(4));
        System.out.println("Grado de entrada (columna) de vertice 4: " + grafo.contarGradoEntrada(4));
    }
    
}
