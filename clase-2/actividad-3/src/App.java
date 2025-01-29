import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        List<Factura> comprobantes = new ArrayList<Factura>();
        Factura factura1 = new Factura("1", "1", 234D);
        Factura factura2 = new Factura("2", "1", 309D);
        Factura factura3 = new Factura("3", "2", 555D);
        Factura factura4 = new Factura("4", "3", 123D);
        comprobantes.add(factura1);
        comprobantes.add(factura2);
        comprobantes.add(factura3);
        comprobantes.add(factura4);

        List<Cliente> clientes = new ArrayList<Cliente>();
        Cliente client1 = new Cliente("1", "client1");
        Cliente client2 = new Cliente("2", "client2");
        Cliente client3 = new Cliente("3", "client3");
        clientes.add(client1);
        clientes.add(client2);
        clientes.add(client3);

        actividad3SinMap(comprobantes, clientes);
        actividad3ConMap(comprobantes, clientes);
    }

    static void actividad3SinMap(List<Factura> comprobantes, List<Cliente> clientes) {
        List<SumaImportePorCliente> importes = new ArrayList<SumaImportePorCliente>();

        clientes.forEach((client) -> {
            double sumaDeImportes = comprobantes.stream()
                .filter(factura -> factura.getClientId().equals(client.getId()))
                .mapToDouble(factura -> factura.getImporte())
                .sum();
            importes.add(new SumaImportePorCliente(client.getId(), client.getNombre(), sumaDeImportes));
        });

        importes.stream().forEach(importe -> System.out.println(importe.toString()));
    }

    static void actividad3ConMap(List<Factura> comprobantes, List<Cliente> clientes) {
        Map<Cliente, SumaImportePorCliente> facturasPorCliente = new HashMap<>();

        clientes.forEach((client) -> {
            double sumaDeImportes = comprobantes.stream()
                .filter(factura -> factura.getClientId().equals(client.getId()))
                .mapToDouble(factura -> factura.getImporte())
                .sum();
            facturasPorCliente.put(client, new SumaImportePorCliente(client.getId(), client.getNombre(), sumaDeImportes));
        });

        facturasPorCliente.forEach((cliente, importes) -> System.out.println(importes.toString()));
    }
}
