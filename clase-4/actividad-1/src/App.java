import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<Cliente> clientes = new ArrayList<>();
        Cliente cliente1 = new Cliente("1", "cliente 1", "80");
        Cliente cliente2 = new Cliente("2", "cliente 2", "20");
        Cliente cliente3 = new Cliente("3", "cliente 3", "45");
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
        actividad1(clientes);
    }

    static void actividad1(List<Cliente> clientes) {
        
    }
}
