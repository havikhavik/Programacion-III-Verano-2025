import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<Cliente> clientes = new ArrayList<>();
        Cliente cliente1 = new Cliente("1", "cliente 1", 80);
        Cliente cliente2 = new Cliente("2", "cliente 2", 20);
        Cliente cliente3 = new Cliente("3", "cliente 3", 45);
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
        Cliente clienteMaxScore = actividad1(clientes, 0, clientes.size()-1);
        System.out.println("El cliente con scoring maximo es: " + clienteMaxScore.getNombre() + " con un score de " + clienteMaxScore.getScoring());
    }

    static Cliente actividad1(List<Cliente> clientes, int inicio, int fin) {
        if (inicio == fin) {
            return clientes.get(inicio);
        }

        int medio = (inicio + fin) / 2;
        Cliente maxIzq = actividad1(clientes, inicio, medio-1);
        Cliente maxDer = actividad1(clientes, medio+1, fin);
        
        if (maxDer.getScoring() > maxIzq.getScoring()) {
            return maxDer;
        } else {
            return maxIzq;
        }
    }
}
