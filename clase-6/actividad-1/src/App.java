import java.util.*;

public class App {

    static class Usuario {
        private String nombre; 

        public Usuario(String nombre) {
            this.nombre = nombre;
        }
        public String getNombre() {
            return nombre;
        }

        // Sobrescribimos el método equals para comparar usuarios por su nombre
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null || getClass() != obj.getClass())
                return false;
            Usuario usuario = (Usuario) obj;
            return Objects.equals(nombre, usuario.nombre);
        }

        // Sobrescribimos el método hashCode para que coincida con equals
        @Override
        public int hashCode() {
            return Objects.hash(nombre);
        }
    }

    static class RedSocial {
        private Map<Usuario, Set<Usuario>> listaAdyacencia; 
        
        public RedSocial() {
            this.listaAdyacencia = new HashMap<>();
        }

        public void agregarUsuario(String nombre) {
            Usuario usuario = new Usuario(nombre);
            if (!listaAdyacencia.containsKey(usuario)) {
                listaAdyacencia.put(usuario, new HashSet<>());
            } else {
                System.out.println("El usuario ya existe.");
            }
        }

        public void seguir(String seguidor, String seguido) {
            Usuario usuarioSeguidor = new Usuario(seguidor);
            Usuario usuarioSeguido = new Usuario(seguido);

            if (listaAdyacencia.containsKey(usuarioSeguidor) && listaAdyacencia.containsKey(usuarioSeguido)) {
                listaAdyacencia.get(usuarioSeguidor).add(usuarioSeguido);
            } else {
                System.out.println("Uno o ambos usuarios no existen.");
            }
        }

        public void dejarDeSeguir(String seguidor, String seguido) {
            Usuario usuarioSeguidor = new Usuario(seguidor);
            Usuario usuarioSeguido = new Usuario(seguido);

            if (listaAdyacencia.containsKey(usuarioSeguidor) && listaAdyacencia.containsKey(usuarioSeguido)) {
                listaAdyacencia.get(usuarioSeguidor).remove(usuarioSeguido);
            } else {
                System.out.println("Uno o ambos usuarios no existen.");
            }
        }

        public Set<Usuario> obtenerSeguidos(String nombre) {
            Usuario usuario = new Usuario(nombre);
            return listaAdyacencia.getOrDefault(usuario, new HashSet<>());
        }

        public Set<Usuario> obtenerSeguidores(String nombre) {
            Usuario usuario = new Usuario(nombre);
            Set<Usuario> seguidores = new HashSet<>();

            for (Map.Entry<Usuario, Set<Usuario>> entry : listaAdyacencia.entrySet()) {
                if (entry.getValue().contains(usuario)) {
                    seguidores.add(entry.getKey());
                }
            }
            return seguidores;
        }

        public void mostrarRedSocial() {
            for (Map.Entry<Usuario, Set<Usuario>> entry : listaAdyacencia.entrySet()) {
                System.out.print(entry.getKey().getNombre() + " sigue a: ");
                for (Usuario seguido : entry.getValue()) {
                    System.out.print(seguido.getNombre() + " ");
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        RedSocial red = new RedSocial();

        red.agregarUsuario("Juan");
        red.agregarUsuario("Maria");
        red.agregarUsuario("Pedro");

        red.seguir("Juan", "Maria");
        red.seguir("Juan", "Pedro");
        red.seguir("Maria", "Pedro");

        red.mostrarRedSocial();

        System.out.println("Seguidores de Pedro: ");
        for (Usuario usuario : red.obtenerSeguidores("Pedro")) {
            System.out.println(usuario.getNombre());
        }
    }
}
