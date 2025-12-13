package streams;

import java.util.*;
import java.util.stream.*;

public class Streams {

    public static void main(String[] args) {
        System.out.println("=== GUÍA COMPLETA DE STREAMS EN JAVA ===\n");

        // 1. CREACIÓN DE STREAMS
        crearStreams();

        // 2. OPERACIONES INTERMEDIAS
        operacionesIntermedias();

        // 3. OPERACIONES TERMINALES
        operacionesTerminales();

        // 4. COLLECTORS AVANZADOS
        collectorsAvanzados();

        // 5. STREAMS NUMÉRICOS
        streamsNumericos();

        // 6. OPERACIONES AVANZADAS
        operacionesAvanzadas();

        // 7. STREAMS PARALELOS
        streamsParalelos();

        // 8. EJEMPLOS PRÁCTICOS
        ejemplosPracticos();
    }

    // ============================================
    // 1. CREACIÓN DE STREAMS
    // ============================================
    static void crearStreams() {
        System.out.println("\n--- 1. CREACIÓN DE STREAMS ---");

        // Desde colección
        List<String> lista = Arrays.asList("A", "B", "C");
        Stream<String> stream1 = lista.stream();

        // Desde array
        String[] array = {"X", "Y", "Z"};
        Stream<String> stream2 = Arrays.stream(array);

        // Con Stream.of()
        Stream<Integer> stream3 = Stream.of(1, 2, 3, 4, 5);

        // Stream vacío
        Stream<String> stream4 = Stream.empty();

        // Stream infinito con iterate
        Stream<Integer> infinito1 = Stream.iterate(0, n -> n + 2).limit(5);
        System.out.println("Infinito iterate: " + infinito1.collect(Collectors.toList()));

        // Stream infinito con generate
        Stream<Double> infinito2 = Stream.generate(Math::random).limit(3);
        System.out.println("Infinito generate: " + infinito2.collect(Collectors.toList()));

        // Desde rango
        IntStream rango = IntStream.range(1, 5); // 1,2,3,4
        System.out.println("Rango: " + rango.boxed().collect(Collectors.toList()));

        // Stream builder
        Stream<String> stream5 = Stream.<String>builder()
                .add("uno")
                .add("dos")
                .add("tres")
                .build();
        System.out.println("Builder: " + stream5.collect(Collectors.toList()));
    }

    // ============================================
    // 2. OPERACIONES INTERMEDIAS
    // ============================================
    static void operacionesIntermedias() {
        System.out.println("\n--- 2. OPERACIONES INTERMEDIAS ---");

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // filter: filtra elementos
        List<Integer> pares = numeros.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Pares: " + pares);

        // map: transforma elementos
        List<Integer> cuadrados = numeros.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("Cuadrados: " + cuadrados);

        // flatMap: aplana streams anidados
        List<List<Integer>> listas = Arrays.asList(
                Arrays.asList(1, 2),
                Arrays.asList(3, 4),
                Arrays.asList(5, 6)
        );
        List<Integer> aplanado = listas.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println("FlatMap: " + aplanado);

        // distinct: elimina duplicados
        List<Integer> conDuplicados = Arrays.asList(1, 2, 2, 3, 3, 3, 4);
        List<Integer> sinDuplicados = conDuplicados.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println("Sin duplicados: " + sinDuplicados);

        // sorted: ordena elementos
        List<String> palabras = Arrays.asList("banana", "manzana", "cereza");
        List<String> ordenadas = palabras.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Ordenadas: " + ordenadas);

        // sorted con comparador
        List<String> porLongitud = palabras.stream()
                .sorted(Comparator.comparing(String::length))
                .collect(Collectors.toList());
        System.out.println("Por longitud: " + porLongitud);

        // peek: realiza acción sin modificar (útil para debugging)
        List<Integer> conPeek = numeros.stream()
                .filter(n -> n > 5)
                .peek(n -> System.out.println("Después de filter: " + n))
                .map(n -> n * 2)
                .peek(n -> System.out.println("Después de map: " + n))
                .collect(Collectors.toList());

        // limit: limita cantidad de elementos
        List<Integer> primeros3 = numeros.stream()
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("Primeros 3: " + primeros3);

        // skip: salta elementos
        List<Integer> sinPrimeros3 = numeros.stream()
                .skip(3)
                .collect(Collectors.toList());
        System.out.println("Sin primeros 3: " + sinPrimeros3);
    }

    // ============================================
    // 3. OPERACIONES TERMINALES
    // ============================================
    static void operacionesTerminales() {
        System.out.println("\n--- 3. OPERACIONES TERMINALES ---");

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

        // forEach: itera sobre elementos
        System.out.print("forEach: ");
        numeros.stream().forEach(n -> System.out.print(n + " "));
        System.out.println();

        // collect: recolecta en colección
        Set<Integer> conjunto = numeros.stream().collect(Collectors.toSet());
        System.out.println("Collect a Set: " + conjunto);

        // toArray: convierte a array
        Integer[] array = numeros.stream().toArray(Integer[]::new);
        System.out.println("toArray: " + Arrays.toString(array));

        // reduce: reduce a un único valor
        Optional<Integer> suma = numeros.stream().reduce((a, b) -> a + b);
        System.out.println("Reduce suma: " + suma.orElse(0));

        // reduce con valor inicial
        Integer producto = numeros.stream().reduce(1, (a, b) -> a * b);
        System.out.println("Reduce producto: " + producto);

        // count: cuenta elementos
        long cantidad = numeros.stream().filter(n -> n > 2).count();
        System.out.println("Count > 2: " + cantidad);

        // anyMatch: verifica si alguno cumple condición
        boolean hayPares = numeros.stream().anyMatch(n -> n % 2 == 0);
        System.out.println("anyMatch (hay pares): " + hayPares);

        // allMatch: verifica si todos cumplen condición
        boolean todosPositivos = numeros.stream().allMatch(n -> n > 0);
        System.out.println("allMatch (todos positivos): " + todosPositivos);

        // noneMatch: verifica si ninguno cumple condición
        boolean ningunoCero = numeros.stream().noneMatch(n -> n == 0);
        System.out.println("noneMatch (ninguno es 0): " + ningunoCero);

        // findFirst: encuentra el primero
        Optional<Integer> primero = numeros.stream().filter(n -> n > 3).findFirst();
        System.out.println("findFirst > 3: " + primero.orElse(-1));

        // findAny: encuentra cualquiera (útil en paralelo)
        Optional<Integer> cualquiera = numeros.stream().findAny();
        System.out.println("findAny: " + cualquiera.orElse(-1));

        // min y max
        Optional<Integer> minimo = numeros.stream().min(Integer::compare);
        Optional<Integer> maximo = numeros.stream().max(Integer::compare);
        System.out.println("Min: " + minimo.orElse(0) + ", Max: " + maximo.orElse(0));
    }

    // ============================================
    // 4. COLLECTORS AVANZADOS
    // ============================================
    static void collectorsAvanzados() {
        System.out.println("\n--- 4. COLLECTORS AVANZADOS ---");

        List<Persona> personas = Arrays.asList(
                new Persona("Ana", 25, "IT"),
                new Persona("Luis", 30, "HR"),
                new Persona("María", 25, "IT"),
                new Persona("Carlos", 35, "IT"),
                new Persona("Sofia", 28, "HR")
        );

        // joining: concatena strings
        String nombres = personas.stream()
                .map(Persona::getNombre)
                .collect(Collectors.joining(", "));
        System.out.println("Joining: " + nombres);

        // groupingBy: agrupa por criterio
        Map<String, List<Persona>> porDepartamento = personas.stream()
                .collect(Collectors.groupingBy(Persona::getDepartamento));
        System.out.println("GroupingBy departamento: " + porDepartamento.keySet());

        // groupingBy con counting
        Map<String, Long> contarPorDept = personas.stream()
                .collect(Collectors.groupingBy(
                        Persona::getDepartamento,
                        Collectors.counting()
                ));
        System.out.println("Contar por dept: " + contarPorDept);

        // partitioningBy: divide en dos grupos
        Map<Boolean, List<Persona>> mayoresDe27 = personas.stream()
                .collect(Collectors.partitioningBy(p -> p.getEdad() > 27));
        System.out.println("Mayores de 27: " + mayoresDe27.get(true).size());

        // summarizingInt: estadísticas numéricas
        IntSummaryStatistics stats = personas.stream()
                .collect(Collectors.summarizingInt(Persona::getEdad));
        System.out.println("Estadísticas edad: avg=" + stats.getAverage() +
                ", min=" + stats.getMin() + ", max=" + stats.getMax());

        // mapping: transforma antes de colectar
        Map<String, List<String>> nombresPorDept = personas.stream()
                .collect(Collectors.groupingBy(
                        Persona::getDepartamento,
                        Collectors.mapping(Persona::getNombre, Collectors.toList())
                ));
        System.out.println("Nombres por dept: " + nombresPorDept);

        // toMap: crea un mapa
        Map<String, Integer> nombreEdad = personas.stream()
                .collect(Collectors.toMap(
                        Persona::getNombre,
                        Persona::getEdad,
                        (edad1, edad2) -> edad1 // manejo de duplicados
                ));
        System.out.println("Mapa nombre->edad: " + nombreEdad);
    }

    // ============================================
    // 5. STREAMS NUMÉRICOS
    // ============================================
    static void streamsNumericos() {
        System.out.println("\n--- 5. STREAMS NUMÉRICOS ---");

        // IntStream, LongStream, DoubleStream: especializados para primitivos

        // IntStream.range y rangeClosed
        int suma = IntStream.rangeClosed(1, 10).sum();
        System.out.println("Suma 1-10: " + suma);

        // Operaciones estadísticas
        IntStream numeros = IntStream.of(1, 2, 3, 4, 5);
        OptionalDouble promedio = numeros.average();
        System.out.println("Promedio: " + promedio.orElse(0));

        // mapToInt, mapToLong, mapToDouble
        List<String> strings = Arrays.asList("1", "2", "3", "4", "5");
        int sumaInt = strings.stream()
                .mapToInt(Integer::parseInt)
                .sum();
        System.out.println("Suma de strings: " + sumaInt);

        // boxed: convierte primitivo a objeto
        List<Integer> lista = IntStream.range(1, 6)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Boxed: " + lista);

        // Generación de números aleatorios
        DoubleStream aleatorios = new Random().doubles(5, 0.0, 100.0);
        System.out.println("Aleatorios: " +
                aleatorios.boxed().collect(Collectors.toList()));
    }

    // ============================================
    // 6. OPERACIONES AVANZADAS
    // ============================================
    static void operacionesAvanzadas() {
        System.out.println("\n--- 6. OPERACIONES AVANZADAS ---");

        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5);

        // Composición de funciones
        List<Integer> resultado = numeros.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("Composición: " + resultado);

        // Optional con streams
        Optional<Integer> max = numeros.stream()
                .filter(n -> n > 10)
                .max(Integer::compare);
        max.ifPresentOrElse(
                val -> System.out.println("Max encontrado: " + val),
                () -> System.out.println("No se encontró máximo")
        );

        // Encadenamiento de collectors
        Map<Boolean, Long> conteo = numeros.stream()
                .collect(Collectors.partitioningBy(
                        n -> n % 2 == 0,
                        Collectors.counting()
                ));
        System.out.println("Conteo pares/impares: " + conteo);

        // Uso de Comparator complejo
        List<Persona> personas = Arrays.asList(
                new Persona("Ana", 25, "IT"),
                new Persona("Luis", 30, "HR"),
                new Persona("María", 25, "IT")
        );

        List<Persona> ordenadas = personas.stream()
                .sorted(Comparator
                        .comparing(Persona::getDepartamento)
                        .thenComparing(Persona::getEdad)
                        .thenComparing(Persona::getNombre))
                .collect(Collectors.toList());
        System.out.println("Personas ordenadas: " + ordenadas);
    }

    // ============================================
    // 7. STREAMS PARALELOS
    // ============================================
    static void streamsParalelos() {
        System.out.println("\n--- 7. STREAMS PARALELOS ---");

        List<Integer> numeros = IntStream.rangeClosed(1, 1000)
                .boxed()
                .collect(Collectors.toList());

        // Stream secuencial
        long inicio1 = System.currentTimeMillis();
        long suma1 = numeros.stream()
                .mapToLong(n -> n * n)
                .sum();
        long tiempo1 = System.currentTimeMillis() - inicio1;
        System.out.println("Secuencial: " + suma1 + " en " + tiempo1 + "ms");

        // Stream paralelo
        long inicio2 = System.currentTimeMillis();
        long suma2 = numeros.parallelStream()
                .mapToLong(n -> n * n)
                .sum();
        long tiempo2 = System.currentTimeMillis() - inicio2;
        System.out.println("Paralelo: " + suma2 + " en " + tiempo2 + "ms");

        // Convertir a paralelo
        List<Integer> resultado = numeros.stream()
                .parallel()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Pares procesados en paralelo: " + resultado.size());

        // NOTA: Usar parallelStream solo cuando:
        // - Hay muchos datos a procesar
        // - Las operaciones son computacionalmente costosas
        // - No hay dependencias entre elementos
        // - Las operaciones son stateless
    }

    // ============================================
    // 8. EJEMPLOS PRÁCTICOS
    // ============================================
    static void ejemplosPracticos() {
        System.out.println("\n--- 8. EJEMPLOS PRÁCTICOS ---");

        List<Producto> productos = Arrays.asList(
                new Producto("Laptop", 1200.0, "Electrónica", true),
                new Producto("Mouse", 25.0, "Electrónica", true),
                new Producto("Mesa", 300.0, "Muebles", false),
                new Producto("Silla", 150.0, "Muebles", true),
                new Producto("Teclado", 80.0, "Electrónica", true)
        );

        // 1. Productos en stock con precio > 100
        System.out.println("\n1. Productos caros en stock:");
        productos.stream()
                .filter(Producto::isEnStock)
                .filter(p -> p.getPrecio() > 100)
                .forEach(p -> System.out.println("  " + p.getNombre() + " - $" + p.getPrecio()));

        // 2. Precio promedio por categoría
        System.out.println("\n2. Precio promedio por categoría:");
        Map<String, Double> promedios = productos.stream()
                .collect(Collectors.groupingBy(
                        Producto::getCategoria,
                        Collectors.averagingDouble(Producto::getPrecio)
                ));
        promedios.forEach((cat, prom) ->
                System.out.println("  " + cat + ": $" + String.format("%.2f", prom)));

        // 3. Producto más caro por categoría
        System.out.println("\n3. Producto más caro por categoría:");
        Map<String, Optional<Producto>> masCaro = productos.stream()
                .collect(Collectors.groupingBy(
                        Producto::getCategoria,
                        Collectors.maxBy(Comparator.comparing(Producto::getPrecio))
                ));
        masCaro.forEach((cat, prod) ->
                prod.ifPresent(p -> System.out.println("  " + cat + ": " + p.getNombre())));

        // 4. Total de inventario en stock
        double totalInventario = productos.stream()
                .filter(Producto::isEnStock)
                .mapToDouble(Producto::getPrecio)
                .sum();
        System.out.println("\n4. Total inventario en stock: $" + totalInventario);

        // 5. Nombres de productos ordenados
        System.out.println("\n5. Lista de productos:");
        String listaProductos = productos.stream()
                .map(Producto::getNombre)
                .sorted()
                .collect(Collectors.joining(", "));
        System.out.println("  " + listaProductos);
    }
}