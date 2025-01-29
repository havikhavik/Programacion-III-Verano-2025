public class Factura {
    private String id;
    private String clientId;
    private Double importe;

    public Factura(String id, String clientId, Double importe) {
        this.id = id;
        this.clientId = clientId;
        this.importe = importe;
    }
    
    public String getClientId() {
        return clientId;
    }
    public Double getImporte() {
        return importe;
    }
}
