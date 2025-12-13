# Lambdas en Java

Las lambdas son funciones anónimas introducidas en Java 8 que permiten escribir código más conciso y funcional. Representan una implementación de una interfaz funcional (interfaz con un solo método abstracto).

Las expresiones lambda solo pueden ser usadas con objetos que implementan una interfaz funcional.

## Implementacion en codigo
[Codigo](../Basics/src/lamdas)

## **Sintaxis de Lambda**

### **Formas básicas:**

```java
// Forma completa
(parametro1, parametro2) -> {
        // cuerpo con múltiples líneas
        return resultado;
}

// Forma simplificada (una línea, return implícito)
        (parametro1, parametro2) -> expresion

// Sin parámetros
() -> expresion

// Un parámetro (paréntesis opcionales)
parametro -> expresion

// Sin tipos (inferencia automática)
(a, b) -> a + b

```

### **Ejemplos de sintaxis:**

```java
// Con tipos explícitos
(int a, int b) -> a + b

// Sin tipos (inferidos)
(a, b) -> a + b

// Un parámetro sin paréntesis
x -> x * x

// Sin parámetros
() -> System.out.println("Hola")

// Múltiples líneas
(a, b) -> {
int suma = a + b;
    return suma * 2;
        }

```

## **Interfaces Funcionales**

Una interfaz funcional es una interfaz que tiene exactamente un método abstracto. Se marca con `@FunctionalInterface`.

### **Interfaces funcionales predefinidas en Java:**

| Interfaz | Método | Descripción | Ejemplo |
| --- | --- | --- | --- |
| `Predicate<T>` | `boolean test(T t)` | Recibe T, retorna boolean | `n -> n > 0` |
| `Function<T,R>` | `R apply(T t)` | Recibe T, retorna R | `s -> s.length()` |
| `Consumer<T>` | `void accept(T t)` | Recibe T, no retorna | `s -> print(s)` |
| `Supplier<T>` | `T get()` | No recibe, retorna T | `() -> Math.random()` |
| `BiFunction<T,U,R>` | `R apply(T t, U u)` | Recibe T y U, retorna R | `(a,b) -> a+b` |
| `BinaryOperator<T>` | `T apply(T t1, T t2)` | Recibe dos T, retorna T | `(a,b) -> Math.max(a,b)` |
| `UnaryOperator<T>` | `T apply(T t)` | Recibe T, retorna T | `x -> x * 2` |
| `Runnable` | `void run()` | No recibe ni retorna | `() -> doSomething()` |
| `Comparator<T>` | `int compare(T o1, T o2)` | Compara dos objetos | `(s1,s2) -> s1.compareTo(s2)` |

## **Composición de Funciones**

### **Function - andThen y compose:**

```java
Function<Integer, Integer> f1 = x -> x * 2;
Function<Integer, Integer> f2 = x -> x + 10;

// andThen: primero f1, luego f2
f1.andThen(f2).apply(5); // (5*2)+10 = 20

// compose: primero f2, luego f1
f1.compose(f2).apply(5); // (5+10)*2 = 30

```

### **Predicate - and, or, negate:**

```java
Predicate<Integer> mayor5 = x -> x > 5;
Predicate<Integer> menor20 = x -> x < 20;

// Combinar con AND
mayor5.and(menor20).test(10); // true

// Combinar con OR
mayor5.or(menor20).test(3); // true

// Negar
mayor5.negate().test(3); // true

```

## **Referencias a Métodos (Method References)**

Forma abreviada de escribir ciertas lambdas usando `::`.

| Tipo | Sintaxis | Equivalente Lambda |
| --- | --- | --- |
| Método estático | `Clase::metodo` | `x -> Clase.metodo(x)` |
| Método de instancia | `objeto::metodo` | `x -> objeto.metodo(x)` |
| Método de instancia arbitraria | `Clase::metodo` | `(obj, x) -> obj.metodo(x)` |
| Constructor | `Clase::new` | `x -> new Clase(x)` |

### **Ejemplos:**

```java
// Método estático
Integer::parseInt       // s -> Integer.parseInt(s)
Math::sqrt             // x -> Math.sqrt(x)

// Método de instancia
System.out::println    // x -> System.out.println(x)
String::length         // s -> s.length()

// Constructor
ArrayList::new         // () -> new ArrayList()
String::new           // () -> new String()

```

## **Lambdas con Collections**

### **List:**

```java
// forEach
lista.forEach(elemento -> System.out.println(elemento));

// removeIf
        lista.removeIf(n -> n < 0);

// sort
        lista.sort((a, b) -> a.compareTo(b));

// replaceAll
        lista.replaceAll(s -> s.toUpperCase());

```

### **Map:**

```java
// forEach
mapa.forEach((k, v) -> System.out.println(k + "=" + v));

// compute
        mapa.compute(key, (k, v) -> v + 1);

// computeIfAbsent
        mapa.computeIfAbsent(key, k -> defaultValue);

// merge
        mapa.merge(key, value, (old, nuevo) -> old + nuevo);

```

## **Streams con Lambdas**

Los streams son fundamentales para programación funcional en Java:

### **Operaciones intermedias (devuelven Stream):**

```java
// filter - filtrar elementos
stream.filter(n -> n > 5)

// map - transformar elementos
        stream.map(s -> s.toUpperCase())

// sorted - ordenar
        stream.sorted((a, b) -> a.compareTo(b))

// distinct - eliminar duplicados
        stream.distinct()

// limit - limitar cantidad
stream.limit(10)

// skip - saltar elementos
stream.skip(5)

```

### **Operaciones terminales (devuelven resultado):**

```java
// collect - recolectar en colección
stream.collect(Collectors.toList())

// forEach - ejecutar acción
        stream.forEach(System.out::println)

// reduce - reducir a un valor
stream.reduce(0, (a, b) -> a + b)

// count - contar elementos
        stream.count()

// anyMatch - si alguno cumple
stream.anyMatch(n -> n > 10)

// allMatch - si todos cumplen
        stream.allMatch(n -> n > 0)

// findFirst - encontrar primero
        stream.findFirst()

// max/min - máximo/mínimo
stream.max(Integer::compareTo)

```

## **Ventajas de las Lambdas**

- **Código más conciso:** Menos código boilerplate
- **Legibilidad:** Código más expresivo y claro
- **Programación funcional:** Permite estilo funcional en Java
- **Paralelización:** Fácil procesamiento paralelo con streams paralelos
- **Reutilización:** Funciones como objetos de primera clase

## **Cuándo Usar Lambdas**

**✓ Usar lambdas cuando:**

- Se implementan interfaces con un solo método
- Se necesitan callbacks o listeners simples
- Se trabaja con colecciones (filter, map, reduce)
- El código es corto y claro

**✗ Evitar lambdas cuando:**

- La lógica es compleja (mejor método separado)
- Se necesita reutilizar la lógica en muchos lugares
- El código se vuelve difícil de leer
- Se necesita manejar excepciones chequeadas

## **Buenas Prácticas**

1. **Mantener las lambdas cortas** (1-3 líneas idealmente)
2. **Usar method references** cuando sea posible para mayor claridad
3. **Nombrar las lambdas** si se reutilizan
4. **Evitar modificar variables externas** (efectos secundarios)
5. **Preferir streams sobre loops** para operaciones en colecciones
6. **Usar interfaces funcionales estándar** en lugar de crear propias
7. **Combinar operaciones de stream** en pipelines claros

## **Diferencia: Clase Anónima vs Lambda**

```java
// Clase anónima (verboso)
Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Hola");
            }
        };

// Lambda (conciso)
Runnable r2 = () -> System.out.println("Hola");

```

Las lambdas son más que sintaxis azucarada: permiten un estilo de programación más funcional y expresivo en Java.