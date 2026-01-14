## Testing Unitario

El testing unitario es una práctica fundamental en el desarrollo de software que consiste en probar componentes individuales del código (generalmente métodos o clases) de forma aislada para verificar que funcionan correctamente. Cada prueba unitaria debe ser independiente, repetible y rápida de ejecutar.

## ¿Qué es JUnit?

JUnit es el framework de testing más popular para Java. Proporciona anotaciones, aserciones y utilidades para escribir y ejecutar pruebas de manera estructurada.

## Principios Fundamentales del Testing Unitario

**Características de una buena prueba unitaria:**

- **Rápida**: Debe ejecutarse en milisegundos
- **Aislada**: No depende de otras pruebas ni del orden de ejecución
- **Repetible**: Produce el mismo resultado cada vez que se ejecuta
- **Autovalidable**: Pasa o falla sin intervención manual
- **Oportuna**: Se escribe junto con el código de producción

**Patrón AAA (Arrange-Act-Assert):**
Este patrón estructura cada prueba en tres secciones: preparación del escenario (Arrange), ejecución de la acción a probar (Act) y verificación del resultado (Assert).

## Estructura Básica de JUnit

### Anotaciones Principales

`@Test`: Marca un método como método de prueba que debe ser ejecutado por el framework.

`@BeforeEach`: Ejecuta un método antes de cada prueba individual, útil para inicializar objetos o configurar el estado necesario.

`@AfterEach`: Ejecuta un método después de cada prueba, ideal para limpiar recursos o restablecer estados.

`@BeforeAll`: Ejecuta un método una sola vez antes de todas las pruebas de la clase. El método debe ser estático.

`@AfterAll`: Ejecuta un método una sola vez después de todas las pruebas. El método debe ser estático.

`@DisplayName`: Permite asignar un nombre descriptivo a la prueba que aparecerá en los reportes.

`@Disabled`: Desactiva temporalmente una prueba sin eliminarla del código.

`@RepeatedTest`: Ejecuta una prueba múltiples veces con el número de repeticiones especificado.

`@ParameterizedTest`: Permite ejecutar la misma prueba con diferentes parámetros de entrada.

### Aserciones (Assertions)

Las aserciones son métodos estáticos de la clase `Assertions` que verifican condiciones esperadas:

`assertEquals(expected, actual)`: Verifica que dos valores sean iguales.

`assertNotEquals(unexpected, actual)`: Verifica que dos valores sean diferentes.

`assertTrue(condition)`: Verifica que una condición booleana sea verdadera.

`assertFalse(condition)`: Verifica que una condición booleana sea falsa.

`assertNull(object)`: Verifica que un objeto sea null.

`assertNotNull(object)`: Verifica que un objeto no sea null.

`assertThrows(Exception.class, executable)`: Verifica que se lance una excepción específica.

`assertTimeout(duration, executable)`: Verifica que la ejecución no exceda un tiempo límite.

`assertAll(executables)`: Agrupa múltiples aserciones y ejecuta todas, reportando todas las que fallan.

`assertArrayEquals(expectedArray, actualArray)`: Verifica que dos arrays sean iguales.

`assertSame(expected, actual)`: Verifica que dos referencias apunten al mismo objeto.

`assertNotSame(unexpected, actual)`: Verifica que dos referencias apunten a objetos diferentes.

## Configuración de JUnit en un Proyecto

Maven:

```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>6.0.1</version>
    <scope>test</scope>
</dependency>
```

Gradle:

```
dependencies {
    testImplementation 'org.junit.jupiter:junit-jupiter:6.0.1'
}
```

## Buenas Prácticas

**Nomenclatura**: Los nombres de métodos de prueba deben ser descriptivos y seguir convenciones como `should_ReturnValue_When_Condition` o `givenCondition_whenAction_thenResult`.

**Una aserción por concepto**: cada prueba debería verificar un solo comportamiento o concepto.

**Independencia**: Las pruebas no deben depender unas de otras ni del orden de ejecución.

**No probar métodos privados**: Los métodos privados se prueban indirectamente a través de los métodos públicos que los utilizan.

**Mantenibilidad**: Las pruebas son código que también debe mantenerse, así que deben ser claras y fáciles de entender.

**Prueba casos límite**: Incluir valores nulos, vacíos, negativos, muy grandes, y casos extremos según el contexto.

**Velocidad**: Mantener las pruebas rápidas evitando I/O, acceso a bases de datos o llamadas a servicios externos sin usar mocks.

## Test-Driven Development (TDD)

TDD es una metodología donde se escribe la prueba antes del código de producción, siguiendo el ciclo Red-Green-Refactor: primero se escribe una prueba que falla (Red), luego se escribe el código mínimo para hacerla pasar (Green), y finalmente se refactoriza mejorando el diseño sin romper las pruebas.

## Organización de Pruebas

Las pruebas unitarias típicamente se organizan en el directorio `src/test/java`, reflejando la estructura de paquetes de `src/main/java`. La convención común es nombrar las clases de prueba con el sufijo `Test`, como `CalculadoraTest` para probar la clase `Calculadora`.