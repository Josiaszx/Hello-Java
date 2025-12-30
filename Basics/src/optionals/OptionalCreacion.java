package optionals;

import java.util.Optional;

public class OptionalCreacion {
    public static void main(String[] args) {
        // 1. Optional vacío
        Optional<String> vacio = Optional.empty();
        System.out.println("Vacío: " + vacio);

        // 2. Optional con valor (lanza excepción si es null)
        Optional<String> conValor = Optional.of("Hola Mundo");
        System.out.println("Con valor: " + conValor);

        // 3. Optional que puede ser null (más común)
        String nombre = obtenerNombre();
        Optional<String> nullable = Optional.ofNullable(nombre);
        System.out.println("Nullable: " + nullable);

        // Ejemplo con null
        String nulo = null;
        Optional<String> optionalNulo = Optional.ofNullable(nulo);
        System.out.println("Opcional nulo: " + optionalNulo);
    }

    private static String obtenerNombre() {
        return Math.random() > 0.5 ? "Juan" : null;
    }
}
