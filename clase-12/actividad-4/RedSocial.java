import java.util.*;

public class RedSocial {
    private Map<Integer, String> usuarios; // Mapa de identificadores a nombres
    private Map<Integer, List<Integer>> amistades; // Lista de adyacencia

    public RedSocial() {
        usuarios = new HashMap<>();
        amistades = new HashMap<>();
    }

    public void agregarUsuario(int id, String nombre) {
        if (!usuarios.containsKey(id)) {
            usuarios.put(id, nombre);
            amistades.put(id, new ArrayList<>());
        } else {
            System.out.println("El usuario con ID " + id + " ya existe.");
        }
    }

    public void agregarAmistad(int id1, int id2) {
        if (usuarios.containsKey(id1) && usuarios.containsKey(id2)) {
            amistades.get(id1).add(id2);
            amistades.get(id2).add(id1); // Relación bidireccional
        } else {
            System.out.println("Uno o ambos usuarios no existen.");
        }
    }

    public void recorridoDFS(int id) {
        if (!usuarios.containsKey(id)) {
            System.out.println("El usuario no existe.");
            return;
        }

        Set<Integer> visitados = new HashSet<>();
        System.out.println("Recorrido DFS desde " + usuarios.get(id) + ":");
        dfs(id, visitados);
        System.out.println();
    }

    private void dfs(int id, Set<Integer> visitados) {
        visitados.add(id);
        System.out.print(usuarios.get(id) + " ");

        for (int amigo : amistades.get(id)) {
            if (!visitados.contains(amigo)) {
                dfs(amigo, visitados);
            }
        }
    }

    public void recorridoBFS(int id) {
        if (!usuarios.containsKey(id)) {
            System.out.println("El usuario no existe.");
            return;
        }

        Set<Integer> visitados = new HashSet<>();
        Queue<Integer> cola = new LinkedList<>();
        visitados.add(id);
        cola.add(id);

        System.out.println("Recorrido BFS desde " + usuarios.get(id) + ":");

        while (!cola.isEmpty()) {
            int actual = cola.poll();
            System.out.print(usuarios.get(actual) + " ");

            for (int amigo : amistades.get(actual)) {
                if (!visitados.contains(amigo)) {
                    visitados.add(amigo);
                    cola.add(amigo);
                }
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RedSocial red = new RedSocial();

        // Agregar usuarios
        red.agregarUsuario(1, "Alice");
        red.agregarUsuario(2, "Bob");
        red.agregarUsuario(3, "Carlos");
        red.agregarUsuario(4, "Diana");
        red.agregarUsuario(5, "Elena");

        // Crear relaciones de amistad
        red.agregarAmistad(1, 2);
        red.agregarAmistad(1, 3);
        red.agregarAmistad(2, 4);
        red.agregarAmistad(3, 5);
        red.agregarAmistad(4, 5);

        // Realizar recorridos desde Alice (ID 1)
        red.recorridoDFS(1);
        red.recorridoBFS(1);
    }
}