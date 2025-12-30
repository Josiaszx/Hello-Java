package optionals;

import java.util.Optional;

public class OptionalFuncional {
    public static void main(String[] args) {
        // 1. ifPresent() - ejecuta acción si hay valor
        Optional<String> nombre = Optional.of("María");
        nombre.ifPresent(n -> System.out.println("Hola, " + n));

        // 2. ifPresentOrElse() - Java 9+ (acción si presente, otra si ausente)
        Optional<String> apellido = Optional.empty();
        apellido.ifPresentOrElse(
                a -> System.out.println("Apellido: " + a),
                () -> System.out.println("Sin apellido")
        );

        // 3. filter() - filtra el valor según un predicado
        Optional<Integer> numero = Optional.of(42);
        Optional<Integer> par = numero.filter(n -> n % 2 == 0);
        System.out.println("Es par: " + par.isPresent());

        Optional<Integer> mayor50 = numero.filter(n -> n > 50);
        System.out.println("Mayor a 50: " + mayor50.isPresent());

        // 4. map() - transforma el valor si está presente
        Optional<String> nombreCompleto = Optional.of("juan pérez");
        Optional<String> mayusculas = nombreCompleto.map(String::toUpperCase);
        System.out.println("Mayúsculas: " + mayusculas.get());

        Optional<Integer> longitud = nombreCompleto.map(String::length);
        System.out.println("Longitud: " + longitud.get());

        // 5. flatMap() - transforma a otro Optional (evita Optional<Optional<T>>)
        Optional<Usuario> usuario = Optional.of(new Usuario("Ana", "ana@example.com"));
        Optional<String> email = usuario.flatMap(Usuario::getEmail);
        email.ifPresent(e -> System.out.println("Email: " + e));

        // Cadena de operaciones
        String resultado = Optional.of("  texto con espacios  ")
                .map(String::trim)
                .filter(s -> s.length() > 5)
                .map(String::toUpperCase)
                .orElse("Texto muy corto");

        System.out.println("Resultado: " + resultado);
    }
}

class Usuario {
    private String nombre;
    private String email;

    public Usuario(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }

    public String getNombre() {
        return nombre;
    }
}
