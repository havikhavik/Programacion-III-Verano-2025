import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Sucursal {
    String nombre;
    int monto;

    public Sucursal(String nombre, int monto) {
        this.nombre = nombre;
        this.monto = monto;
    }
}

public class RutaCobrador {
    
    public static List<Sucursal> planificarRuta(int saldoInicial, List<Sucursal> sucursales) {
        List<Sucursal> ruta = new ArrayList<>();
        PriorityQueue<Sucursal> cola = new PriorityQueue<>((a, b) -> Integer.compare(b.monto, a.monto));
        cola.addAll(sucursales);
        int saldo = saldoInicial;
        
        while (!cola.isEmpty()) {
            boolean sucursalVisitada = false;
            List<Sucursal> opciones = new ArrayList<>(cola);
            opciones.sort((a, b) -> Integer.compare(b.monto, a.monto));

            for (Sucursal sucursal : opciones) {
                if (saldo + sucursal.monto >= 0) { // Asegurar que no se quede sin dinero
                    saldo += sucursal.monto;
                    ruta.add(sucursal);
                    cola.remove(sucursal);
                    sucursalVisitada = true;
                    break;
                }
            }
            
            if (!sucursalVisitada) {
                System.out.println("No es posible continuar sin quedarse sin dinero.");
                break;
            }
        }
        return ruta;
    }

    public static void main(String[] args) {
        List<Sucursal> sucursales = Arrays.asList(
            new Sucursal("Sucursal A", -500),
            new Sucursal("Sucursal B", -200),
            new Sucursal("Sucursal C", 300),
            new Sucursal("Sucursal D", -400),
            new Sucursal("Sucursal E", 600),
            new Sucursal("Sucursal F", -100)
        );
        
        int saldoInicial = 300;
        List<Sucursal> rutaOptima = planificarRuta(saldoInicial, sucursales);
        
        System.out.println("Ruta óptima: ");
        for (Sucursal sucursal : rutaOptima) {
            System.out.println(sucursal.nombre + " (Monto: " + sucursal.monto + ")");
        }
    }
}