## ¿Qué son las Anotaciones?

Las anotaciones en Java son metadatos que proporcionan información sobre el código pero no forman parte directa de la lógica del programa. Se introdujeron en Java 5 y se utilizan para dar instrucciones al compilador, herramientas de desarrollo o al runtime.

## Sintaxis Básica

Las anotaciones comienzan con `@` seguido del nombre de la anotación. Pueden aplicarse a clases, métodos, campos, parámetros y otros elementos del código.

## Anotaciones Predefinidas Comunes

**`@Override`**: Indica que un método sobrescribe uno de la superclase.

**`@Deprecated`**: Marca código obsoleto que no debería usarse.

**`@SuppressWarnings`**: Suprime advertencias específicas del compilador.

**`@FunctionalInterface`**: Indica que una interfaz es funcional (un solo método abstracto).

**`@SafeVarargs`**: Suprime advertencias sobre operaciones inseguras con varargs.

## Creación de Anotaciones Personalizadas

Las anotaciones se definen usando `@interface`. Pueden tener elementos que actúan como parámetros.

## Retención y Objetivos

**`@Retention`**: Define hasta cuándo está disponible la anotación (SOURCE, CLASS, RUNTIME).

**`@Target`**: Especifica dónde puede aplicarse la anotación (TYPE, METHOD, FIELD, etc.).

## Conceptos importantes

### Retención de Anotaciones

- **SOURCE**: Solo en código fuente, descartadas por el compilador
- **CLASS**: En bytecode pero no disponibles en runtime (por defecto)
- **RUNTIME**: Disponibles en runtime mediante reflexión

### Objetivos (Targets)

Definen dónde pueden aplicarse las anotaciones:

- `TYPE`: clases
- `FIELD`: campos
- `METHOD`: métodos
- `PARAMETER`: parámetros
- `CONSTRUCTOR`: constructores
- `LOCAL_VARIABLE`: variables locales
- `ANNOTATION_TYPE`: otra anotaciones
- `PACKAGE`: paquetes
- `TYPE_PARAMETER`: parámetros de funciones

### Procesamiento

Las anotaciones pueden procesarse en dos momentos:

1. **Tiempo de compilación**: Usando Annotation Processors (APT) para generar código o validar
2. **Runtime**: Usando reflexión para leer y actuar según las anotaciones