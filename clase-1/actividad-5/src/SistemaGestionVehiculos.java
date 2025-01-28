import java.util.ArrayList;
import java.util.List;

public class SistemaGestionVehiculos {
    public static void main(String[] args) {
        Vehiculo auto = new Auto("ABC123", "Toyota", "Corolla", 4);
        Vehiculo camion = new Camion("DEF456", "Mercedes", "Actros", 18.5);
        Vehiculo moto = new Moto("GHI789", "Yamaha", "YZF-R3", "Deportiva");

        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(auto);
        vehiculos.add(camion);
        vehiculos.add(moto);

        // Mostrar la información de todos los vehículos
        for (Vehiculo vehiculo : vehiculos) {
            vehiculo.mostrarInformacion();
        }
    }
}
