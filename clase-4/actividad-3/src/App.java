import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        List<Cliente> clientesVacio = new ArrayList<>();
        List<Cliente> unSoloCliente = new ArrayList<>();
        clientes.add(new Cliente(1, "Juan", 85));
        clientes.add(new Cliente(2, "María", 90));
        clientes.add(new Cliente(3, "Pedro", 78));
        clientes.add(new Cliente(4, "Lucía", 95));
        clientes.add(new Cliente(5, "Carlos", 80));
        clientes.add(new Cliente(6, "Ana", 88));
        clientes.add(new Cliente(7, "Luis", 92));
        clientes.add(new Cliente(8, "Sofía", 75));
        clientes.add(new Cliente(9, "Marta", 50));
        clientes.add(new Cliente(10, "Jorge", 70));


        List<Cliente> top2 = buscarDosMaximos(clientes, 0, clientes.size() - 1);

        System.out.println("Top 2 clientes con mayor scoring:");
        for (Cliente c : top2) {
            System.out.println(c);
        }
    }

    private static List<Cliente> buscarDosMaximos(List<Cliente> clientes, int inicio, int fin) {

        if (clientes == null || clientes.isEmpty()) {
            return new ArrayList<>(); // Retorna una lista vacía si el array de clientes es nulo
        }

        if (inicio == fin) { // caso base
            List<Cliente> lista = new ArrayList<>();
            lista.add(clientes.get(inicio));
            return lista;
        }

        int medio = (inicio + fin) / 2;
        List<Cliente> maxIzq = buscarDosMaximos(clientes, inicio, medio);
        List<Cliente> maxDer = buscarDosMaximos(clientes, medio + 1, fin);

        return combinarMaximos(maxIzq, maxDer);
    }

    private static List<Cliente> combinarMaximos(List<Cliente> izq, List<Cliente> der) {
        List<Cliente> todos = new ArrayList<>();
        todos.addAll(izq);
        todos.addAll(der);

        // Ordenar por scoring descendente
        todos.sort((p1, p2) -> Integer.compare(p2.scoring, p1.scoring));

        // Devolver solo las dos mejores
        return todos.subList(0, Math.min(2, todos.size()));
    }

    static class Cliente {
        private int id;
        private String nombre;
        private int scoring;

        public Cliente(int id, String nombre, int scoring) {
            this.id = id;
            this.nombre = nombre;
            this.scoring = scoring;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Nombre: " + nombre + ", Scoring: " + scoring;
        }
    }
}
