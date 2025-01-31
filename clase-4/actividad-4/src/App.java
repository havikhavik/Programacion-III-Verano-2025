import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {

    public static void main(String[] args) {
        List<Integer> lista = List.of(10, 15, 3, 7, 8, 23, 74, 18, 19);
        int n = 3;

        List<Integer> maximos = buscarNMaximos(lista, n, 0, lista.size() - 1);
        System.out.println("Los " + n + " elementos más grandes son: " + maximos);
    }

    private static List<Integer> buscarNMaximos(List<Integer> lista, int n, int inicio, int fin) {
        if (lista == null || lista.isEmpty()) {
            return new ArrayList<>(); // Retorna una lista vacía si el array es nulo
        }

        if (fin - inicio + 1 <= n) {
            return new ArrayList<>(lista.subList(inicio, fin + 1));
        }

        int medio = (inicio + fin) / 2;
        List<Integer> maximosIzq = buscarNMaximos(lista, n, inicio, medio);
        List<Integer> maximosDer = buscarNMaximos(lista, n, medio + 1, fin);

        return combinarMaximos(maximosIzq, maximosDer, n);
    }

    private static List<Integer> combinarMaximos(List<Integer> izq, List<Integer> der, int n) {
        List<Integer> todos = new ArrayList<>(izq);
        todos.addAll(der);

        // ordena en orden descendente
        Collections.sort(todos, Collections.reverseOrder());

        // devuelve solo los primeros n elementos
        return todos.subList(0, Math.min(n, todos.size()));
    }
}
