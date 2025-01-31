import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1, "Juan", 85));
        personas.add(new Persona(2, "María", 90));
        personas.add(new Persona(3, "Pedro", 78));
        personas.add(new Persona(4, "Lucía", 95));
        personas.add(new Persona(5, "Carlos", 80));
        personas.add(new Persona(6, "Ana", 88));
        personas.add(new Persona(7, "Luis", 92));
        personas.add(new Persona(8, "Sofía", 75));
        personas.add(new Persona(9, "Marta", 50));
        personas.add(new Persona(10, "Jorge", 70));

        List<Persona> top2 = buscarDosMaximos(personas, 0, personas.size() - 1);

        System.out.println("Top 2 personas con mayor scoring:");
        for (Persona p : top2) {
            System.out.println(p);
        }
    }

    private static List<Persona> buscarDosMaximos(List<Persona> personas, int inicio, int fin) {
        if (inicio == fin) {
            List<Persona> lista = new ArrayList<>();
            lista.add(personas.get(inicio));
            return lista;
        }

        int medio = (inicio + fin) / 2;
        List<Persona> maxIzq = buscarDosMaximos(personas, inicio, medio);
        List<Persona> maxDer = buscarDosMaximos(personas, medio + 1, fin);

        return combinarMaximos(maxIzq, maxDer);
    }

    private static List<Persona> combinarMaximos(List<Persona> izq, List<Persona> der) {
        List<Persona> todos = new ArrayList<>();
        todos.addAll(izq);
        todos.addAll(der);

        // Ordenar por scoring descendente
        todos.sort((p1, p2) -> Integer.compare(p2.scoring, p1.scoring));

        // Devolver solo las dos mejores
        return todos.subList(0, Math.min(2, todos.size()));
    }

    static class Persona {
        private int id;
        private String nombre;
        private int scoring;

        public Persona(int id, String nombre, int scoring) {
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
