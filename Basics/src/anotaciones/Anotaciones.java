package anotaciones;

// ============================================
// -- CREACIÓN DE ANOTACIONES PERSONALIZADAS --
// ============================================

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Retention(RetentionPolicy.RUNTIME)
/*
@Retention() Define en que momento del programa esta disponible la anotacion (SOURCE, CLASS, RUNTIME)
- SOURCE: Solo en código fuente, descartadas por el compilador
- CLASS: En bytecode pero no disponibles en runtime (por defecto)
- RUNTIME: Disponibles en runtime mediante reflexión
*/
@Target(ElementType.METHOD) // Especifica a que elemento aplicarse la anotación (TYPE, METHOD, FIELD, etc.).


// Anotación simple sin elementos
public @interface Anotaciones {

}

// Anotación con un solo elemento (puede usarse sin nombre)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Descripcion {
    String value(); // value se recibe como un parametro de la anotacion -> @Descripcion("Texto de descripción")
    // es obligatorio definirle un valor
}

// Anotación con múltiples elementos
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@interface Info {
    String autor();
    String fecha();
    int version() default 1; // Valor por defecto = 1
    String[] tags() default {};
}

// Anotación para validación
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface NotNull {
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Min {
    int value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Max {
    int value();
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface Email {

}

