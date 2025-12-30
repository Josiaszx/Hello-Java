package optionals;

import java.util.Optional;

public class OptionalVerificacion {
    public static void main(String[] args) {
        Optional<String> presente = Optional.of("Valor presente");
        Optional<String> ausente = Optional.empty();

        // 1. isPresent() - verifica si hay valor
        System.out.println("¿Presente? " + presente.isPresent()); // true
        System.out.println("¿Ausente? " + ausente.isPresent()); // false

        // 2. isEmpty() - Java 11+ (inverso de isPresent)
        System.out.println("¿Vacío? " + ausente.isEmpty()); // true

        // 3. get() - obtiene el valor (lanza excepción si está vacío)
        try {
            String valor = presente.get();
            System.out.println("Valor obtenido: " + valor);

             String valorAusente = ausente.get(); // Esto lanzara NoSuchElementException
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // 4. orElse() - valor por defecto si está vacío
        String resultado1 = ausente.orElse("Valor por defecto");
        System.out.println("Con orElse: " + resultado1);

        // 5. orElseGet() - valor por defecto usando Supplier
        String resultado2 = ausente.orElseGet(() -> {
            System.out.println("Calculando valor por defecto...");
            return "Valor calculado";
        });
        System.out.println("Con orElseGet: " + resultado2);

        // 6. orElseThrow() - lanza excepción personalizada
        try {
            String resultado3 = ausente.orElseThrow(
                    () -> new IllegalStateException("¡No hay valor!")
            );
        } catch (IllegalStateException e) {
            System.out.println("Excepción capturada: " + e.getMessage());
        }
    }
}
