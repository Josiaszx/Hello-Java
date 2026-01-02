package anotaciones;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ProcesadorAnotaciones {

    // Procesar anotaciones de clase
    public static void procesarClase(Class<?> clase) {
        System.out.println("\n=== Anotaciones de la clase " + clase.getSimpleName() + " ===");

        // chequear si una clase tiene una anotacion presente
        if (clase.isAnnotationPresent(Info.class)) {
            Info info = clase.getAnnotation(Info.class);
            System.out.println("Autor: " + info.autor());
            System.out.println("Fecha: " + info.fecha());
            System.out.println("Versión: " + info.version());
            System.out.println("Tags: " + String.join(", ", info.tags()));
        } else {
            System.out.println("La anotacion @info no está presente en la clase.");
        }
    }

    // Procesar anotaciones de métodos
    public static void procesarMetodos(Class<?> clase) {
        System.out.println("\n=== Métodos con anotaciones ===");

        // obtener metodos de la clase
        for (Method metodo : clase.getDeclaredMethods()) {

            // chequear si un metodo tiene una anotacion
            if (metodo.isAnnotationPresent(Anotaciones.class)) {
                System.out.println("Método de prueba: " + metodo.getName());
            }

            if (metodo.isAnnotationPresent(Descripcion.class)) {
                Descripcion desc = metodo.getAnnotation(Descripcion.class);
                System.out.println("  Descripción: " + desc.value());
            }

            System.out.println();
        }

    }

    // Validar campos anotados
    public static boolean validarObjeto(Object obj) {
        System.out.println("\n=== Validando objeto ===");
        boolean esValido = true;

        // obtener los atributos de la clase
        for (Field campo : obj.getClass().getDeclaredFields()) {
            campo.setAccessible(true);

            try {
                Object valor = campo.get(obj);

                // Validar @NotNull
                if (campo.isAnnotationPresent(NotNull.class)) {
                    if (valor == null) {
                        System.out.println("ERROR: " + campo.getName() + " no puede ser null");
                        esValido = false;
                    }
                }

                // Validar @Email
                if (campo.isAnnotationPresent(Email.class) && valor != null) {
                    String email = (String) valor;
                    if (!email.contains("@")) {
                        System.out.println("ERROR: " + campo.getName() + " no es un email válido");
                        esValido = false;
                    }
                }

                // Validar @Min
                if (campo.isAnnotationPresent(Min.class) && valor != null) {
                    Min min = campo.getAnnotation(Min.class);
                    int valorInt = (Integer) valor;
                    if (valorInt < min.value()) {
                        System.out.println("ERROR: " + campo.getName() + " debe ser >= " + min.value());
                        esValido = false;
                    }
                }

                // Validar @Max
                if (campo.isAnnotationPresent(Max.class) && valor != null) {
                    Max max = campo.getAnnotation(Max.class);
                    int valorInt = (Integer) valor;
                    if (valorInt > max.value()) {
                        System.out.println("ERROR: " + campo.getName() + " debe ser <= " + max.value());
                        esValido = false;
                    }
                }

            } catch (IllegalAccessException e) {
                System.out.println("ERROR al acceder al campo: " + campo.getName());
                esValido = false;
            }
        }

        if (esValido) {
            System.out.println("El objeto es válido");
        }

        return esValido;
    }

}
