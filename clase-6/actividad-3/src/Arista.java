public class Arista implements Comparable<Arista> {
    int origen, destino, peso;

    public Arista(int origen, int destino, int peso) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }

    @Override
    public int compareTo(Arista otra) {
        return this.peso - otra.peso;
    }
}