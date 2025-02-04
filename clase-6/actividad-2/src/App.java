public class App {
    public static void main(String[] args) {
        Grafo grafo = new Grafo(5);
        
        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 2);
        grafo.agregarArista(1, 3);
        grafo.agregarArista(3, 4);
        
        System.out.println("Matriz de Adyacencia:");
        grafo.mostrarMatriz();
        
        System.out.println("Adyacentes de fila 0: " + grafo.listarAdyacentes(0));
        System.out.println("Adyacentes de fila 1: " + grafo.listarAdyacentes(1));
        System.out.println("Adyacentes de fila 3: " + grafo.listarAdyacentes(3));
        System.out.println("Grado de salida de fila 0: " + grafo.contarGradoSalida(0));
        System.out.println("Grado de entrada de fila 3: " + grafo.contarGradoEntrada(3));
    }
    
}
