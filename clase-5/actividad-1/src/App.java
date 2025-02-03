import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<Integer> monedas = List.of(10, 1, 5, 2, 10, 10, 5, 2, 5, 5, 5, 5, 5, 5, 10);
        List<Integer> vuelto = actividad1(new ArrayList<>(monedas), 33);
        System.out.println(vuelto);
    }

    static List<Integer> actividad1(List<Integer> monedas, Integer vuelto) throws Exception {
        List<Integer> resultado = new ArrayList<>();
        Collections.sort(monedas, Comparator.reverseOrder()); //ordenar de mayor a menor
        
        int suma = 0;
        for(int i = 0; i < monedas.size(); i++) {
            if (suma + monedas.get(i) <= vuelto) {
                resultado.add(monedas.get(i));
                suma += monedas.get(i);
            }
        }

        if(suma < vuelto){
            throw new Exception("No se pudo completar el vuelto");
        }

        return resultado;
    }
}
