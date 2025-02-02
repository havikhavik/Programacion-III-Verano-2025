import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Actividad5 {

    public static Map<String, Corredor> encontrarMejoresTiempos(List<Corredor> listaCorredores, int ini, int fin) {
        if (ini == fin) { // Caso base, un solo corredor
            Map<String, Corredor> resultado = new HashMap<>();
            resultado.put(listaCorredores.get(ini).categoria, listaCorredores.get(ini));
            return resultado;
        }

        int medio = (ini + fin) / 2;

        Map<String, Corredor> mejoresIzq = encontrarMejoresTiempos(listaCorredores, ini, medio);
        Map<String, Corredor> mejoresDer = encontrarMejoresTiempos(listaCorredores, medio + 1, fin);

        return combinarResultados(mejoresIzq, mejoresDer);
    }

    private static Map<String, Corredor> combinarResultados(Map<String, Corredor> izq, Map<String, Corredor> der) {
        Map<String, Corredor> resultado = new HashMap<>(izq);

        for (Map.Entry<String, Corredor> entry : der.entrySet()) {
            String categoria = entry.getKey();
            Corredor corredorDer = entry.getValue();

            if (!resultado.containsKey(categoria) || corredorDer.tiempoEnSegundos < resultado.get(categoria).tiempoEnSegundos) {
                resultado.put(categoria, corredorDer);
            }
        }

        return resultado;
    }

    public static void main(String[] args) {
        List<Corredor> corredores = Arrays.asList(
                new Corredor("Ana", "Juvenil", 320),
                new Corredor("Luis", "Mayor", 290),
                new Corredor("Maria", "Juvenil", 310),
                new Corredor("Carlos", "Mayor", 280),
                new Corredor("Sofia", "Juvenil", 305),
                new Corredor("Pedro", "Mayor", 275)
        );

        Map<String, Corredor> mejoresTiempos = encontrarMejoresTiempos(corredores, 0, corredores.size() - 1);

        for (Map.Entry<String, Corredor> entry : mejoresTiempos.entrySet()) {
            System.out.println("Categoría: " + entry.getKey() + " - Mejor Corredor: " + entry.getValue().nombre + " (" + entry.getValue().tiempoEnSegundos + "s)");
        }
    }
}

class Corredor {
    String nombre;
    String categoria;
    int tiempoEnSegundos;

    public Corredor(String nombre, String categoria, int tiempoEnSegundos) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.tiempoEnSegundos = tiempoEnSegundos;
    }
}

