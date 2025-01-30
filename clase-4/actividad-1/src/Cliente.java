public class Cliente {
    private String id;
    private String nombre;
    private String scoring;

    public Cliente(String id, String nombre, String scoring) {
        this.id = id;
        this.nombre = nombre;
        this.scoring = scoring;
    }
    
    public String getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public String getScoring() {
        return scoring;
    }
}
