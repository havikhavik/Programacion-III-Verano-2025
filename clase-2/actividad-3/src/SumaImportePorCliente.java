public class SumaImportePorCliente {
    private String clientId;
    private String nombre;
    private Double sumaDeImportes;

    public SumaImportePorCliente(String clientId, String nombre, Double sumaDeImportes) {
        this.clientId = clientId;
        this.nombre = nombre;
        this.sumaDeImportes = sumaDeImportes;
    }

    public String toString() {
        return "Suma de importes para el cliente id=" + clientId + ", nombre=" + nombre + ": $" + sumaDeImportes;
    }
}
