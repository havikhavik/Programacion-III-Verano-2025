public abstract class Vehiculo {

    //Todos los vehículos tienen un número de matrícula, marca, modelo y un método para
    //mostrar información del vehículo
    protected String matricula;
    protected String marca;
    protected String modelo;

    public Vehiculo(String matricula, String marca, String modelo) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
    }

    public abstract void mostrarInformacion();

}
