import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<Integer> monedas = List.of(10, 1, 5, 2, 10, 10, 5, 2, 5, 5, 5, 5, 5, 5, 10);
        List<Integer> vuelto = actividad1(monedas, 35);
        System.out.println(vuelto);
    }

    static List<Integer> actividad1(List<Integer> monedas, Integer vuelto) {
        List<Integer> resultado = new ArrayList<>();
        Collections.sort(monedas); //ordenar de mayor a menor
        monedas.forEach(moneda -> {
            if (moneda <= vuelto) {
                resultado.add(moneda);
            }
        });
        return resultado;
    }
}
