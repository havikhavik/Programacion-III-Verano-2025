public class Cliente {
    private String id;
    private String nombre;
    private int scoring;

    public Cliente(String id, String nombre, int scoring) {
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
    public int getScoring() {
        return scoring;
    }
}
