import java.util.ArrayList;
import java.util.List;

public class GrafoDirigido {
    private int[][] matriz;
    private int numVertices;

    public GrafoDirigido(int numVertices) {
        this.numVertices = numVertices;
        matriz = new int[numVertices][numVertices];
    }

    public void agregarArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            matriz[origen][destino] = 1;
        }
    }

    public void eliminarArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            matriz[origen][destino] = 0;
        }
    }

    // Verificar si existe una arista entre dos nodos
    public boolean verificarArista(int origen, int destino) {
        if (origen >= 0 && origen < numVertices && destino >= 0 && destino < numVertices) {
            return matriz[origen][destino] == 1;
        }
        return false;
    }

    // Listar los nodos adyacentes a un nodo dado
    public List<Integer> listarAdyacentes(int vertice) {
        List<Integer> adyacentes = new ArrayList<>();
        if (vertice >= 0 && vertice < numVertices) {
            for (int i = 0; i < numVertices; i++) {
                if (matriz[vertice][i] == 1) {
                    adyacentes.add(i);
                }
            }
        }
        return adyacentes;
    }

    // Contar el grado de salida de un vértice
    public int contarGradoSalida(int vertice) {
        int grado = 0;
        if (vertice >= 0 && vertice < numVertices) {
            for (int i = 0; i < numVertices; i++) {
                if (matriz[vertice][i] == 1) {
                    grado++;
                }
            }
        }
        return grado;
    }

    // Contar el grado de entrada de un vértice
    public int contarGradoEntrada(int vertice) {
        int grado = 0;
        if (vertice >= 0 && vertice < numVertices) {
            for (int i = 0; i < numVertices; i++) {
                if (matriz[i][vertice] == 1) {
                    grado++;
                }
            }
        }
        return grado;
    }

    public void mostrarMatriz() {
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }

}