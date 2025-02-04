import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class App {    
    public static List<Comprobante> obtenerComprobantesMinimos(List<Comprobante> comprobantes, int montoObjetivo) throws Exception {
        comprobantes.sort((a, b) -> Integer.compare(b.valor, a.valor)); // Orden descendente por valor     
        List<Comprobante> seleccionados = new ArrayList<>();        
        int sumaTotal = 0;        
        for (Comprobante comprobante : comprobantes) {
            while (sumaTotal + comprobante.valor <= montoObjetivo) { 
                seleccionados.add(comprobante);                
                sumaTotal += comprobante.valor;            
            }            
            if (sumaTotal == montoObjetivo) {                
                return seleccionados; // Se encontró la combinación exacta            
            }
        }        
        throw new Exception("No es posible alcanzar el monto exacto con los comprobantes disponibles.");    
    }    
    
    public static void main(String[] args) throws Exception { 
       List<Comprobante> comprobantes = Arrays.asList(  
            new Comprobante("Billete de 10", 10),                
            new Comprobante("Moneda de 1", 1),                
            new Comprobante("Billete de 5", 5),                
            new Comprobante("Moneda de 2", 2),                
            new Comprobante("Billete de 10", 10),                
            new Comprobante("Billete de 10", 10),                
            new Comprobante("Billete de 5", 5),                
            new Comprobante("Moneda de 2", 2),                
            new Comprobante("Billete de 5", 5),                
            new Comprobante("Billete de 5", 5),                
            new Comprobante("Billete de 5", 5),                
            new Comprobante("Billete de 5", 5),                
            new Comprobante("Billete de 5", 5),                
            new Comprobante("Billete de 5", 5),                
            new Comprobante("Billete de 10", 10)        
        );        
        int montoObjetivo = 33;  
        List<Comprobante> resultado = obtenerComprobantesMinimos(comprobantes, montoObjetivo);
        System.out.println("Comprobantes seleccionados: " + resultado);
    }    
    
    public static class Comprobante {        
        String descripcion;        
        int valor;        
        
        public Comprobante(String descripcion, int valor) {            
            this.descripcion = descripcion;            
            this.valor = valor;        
        }        
        
        @Override        
        public String toString() {            
            return descripcion;        
        }
    }
}