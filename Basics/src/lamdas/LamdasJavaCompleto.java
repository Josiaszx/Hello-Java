package lamdas;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;


// ========================================
// CLASE PRINCIPAL
// ========================================

public class LamdasJavaCompleto {

    public static void main(String[] args) {

        // ========================================
        // 1. SINTAXIS BÁSICA DE LAMBDAS
        // ========================================
        System.out.println("=== 1. SINTAXIS BÁSICA ===");

        // Forma tradicional con clase anónima
        Operacion sumaTradicional = new Operacion() {
            @Override
            public int calcular(int a, int b) {
                return a + b;
            }
        };
        System.out.println("Suma tradicional: " + sumaTradicional.calcular(5, 3));

        // Con lambda - sintaxis completa
        Operacion sumaLambda = (int a, int b) -> {
            return a + b;
        };
        System.out.println("Suma lambda completa: " + sumaLambda.calcular(5, 3));

        // Lambda simplificada (sin tipos, sin llaves, sin return)
        Operacion sumaSimple = (a, b) -> a + b;
        System.out.println("Suma lambda simple: " + sumaSimple.calcular(5, 3));

        // Otras operaciones
        Operacion resta = (a, b) -> a - b;
        Operacion multiplicacion = (a, b) -> a * b;
        Operacion division = (a, b) -> a / b;

        System.out.println("Resta: " + resta.calcular(10, 3));
        System.out.println("Multiplicación: " + multiplicacion.calcular(4, 5));
        System.out.println("División: " + division.calcular(20, 4));

        // Lambda sin parámetros
        Runnable saludar = () -> System.out.println("¡Hola desde lambda!");
        saludar.run();

        // Lambda con un parámetro (paréntesis opcionales)
        Saludador saludador = nombre -> System.out.println("Hola, " + nombre);
        saludador.saludar("Juan");

        // Lambda con múltiples líneas
        Validador validadorComplejo = texto -> {
            if (texto == null || texto.isEmpty()) {
                return false;
            }
            return texto.length() >= 5 && texto.matches("[a-zA-Z]+");
        };
        System.out.println("Validar 'Hola': " + validadorComplejo.validar("Hola"));
        System.out.println("Validar 'Ho': " + validadorComplejo.validar("Ho"));

        // ========================================
        // 2. INTERFACES FUNCIONALES PREDEFINIDAS
        // ========================================
        System.out.println("\n=== 2. INTERFACES FUNCIONALES JAVA ===");

        // Predicate<T> - recibe T, retorna boolean
        Predicate<Integer> esPar = n -> n % 2 == 0;
        Predicate<String> esLargo = s -> s.length() > 5;
        System.out.println("10 es par: " + esPar.test(10));
        System.out.println("'Hola' es largo: " + esLargo.test("Hola"));

        // Function<T, R> - recibe T, retorna R
        Function<String, Integer> longitud = s -> s.length();
        Function<Integer, Integer> cuadrado = n -> n * n;
        System.out.println("Longitud de 'Java': " + longitud.apply("Java"));
        System.out.println("Cuadrado de 5: " + cuadrado.apply(5));

        // Consumer<T> - recibe T, no retorna nada
        Consumer<String> imprimir = s -> System.out.println("Mensaje: " + s);
        Consumer<Integer> imprimirCuadrado = n -> System.out.println(n + "² = " + (n * n));
        imprimir.accept("Hola Mundo");
        imprimirCuadrado.accept(7);

        // Supplier<T> - no recibe nada, retorna T
        Supplier<Double> aleatorio = () -> Math.random();
        Supplier<String> saludo = () -> "¡Buenos días!";
        System.out.println("Número aleatorio: " + aleatorio.get());
        System.out.println("Saludo: " + saludo.get());

        // BiFunction<T, U, R> - recibe T y U, retorna R
        BiFunction<Integer, Integer, Integer> potencia = (base, exp) -> (int) Math.pow(base, exp);
        System.out.println("2^8 = " + potencia.apply(2, 8));

        // BinaryOperator<T> - recibe dos T, retorna T
        BinaryOperator<Integer> maximo = (a, b) -> a > b ? a : b;
        BinaryOperator<String> concatenar = (s1, s2) -> s1 + " " + s2;
        System.out.println("Máximo(10, 20): " + maximo.apply(10, 20));
        System.out.println("Concatenar: " + concatenar.apply("Hola", "Mundo"));

        // UnaryOperator<T> - recibe T, retorna T
        UnaryOperator<Integer> duplicar = n -> n * 2;
        UnaryOperator<String> mayusculas = String::toUpperCase;
        System.out.println("Duplicar 5: " + duplicar.apply(5));
        System.out.println("Mayúsculas: " + mayusculas.apply("java"));

        // ========================================
        // 3. COMPOSICIÓN DE FUNCIONES
        // ========================================
        System.out.println("\n=== 3. COMPOSICIÓN DE FUNCIONES ===");

        Function<Integer, Integer> multiplicarPor2 = x -> x * 2;
        Function<Integer, Integer> sumar10 = x -> x + 10;

        // andThen: primero f1, luego f2
        Function<Integer, Integer> multiplicarLuegoSumar = multiplicarPor2.andThen(sumar10);
        System.out.println("(5 * 2) + 10 = " + multiplicarLuegoSumar.apply(5));

        // compose: primero f2, luego f1
        Function<Integer, Integer> sumarLuegoMultiplicar = multiplicarPor2.compose(sumar10);
        System.out.println("(5 + 10) * 2 = " + sumarLuegoMultiplicar.apply(5));

        // Predicate: and, or, negate
        Predicate<Integer> mayorQue5 = x -> x > 5;
        Predicate<Integer> menorQue20 = x -> x < 20;
        Predicate<Integer> entre5y20 = mayorQue5.and(menorQue20);
        System.out.println("10 está entre 5 y 20: " + entre5y20.test(10));
        System.out.println("25 está entre 5 y 20: " + entre5y20.test(25));

        Predicate<Integer> fueraRango = entre5y20.negate();
        System.out.println("25 está fuera del rango: " + fueraRango.test(25));

        // ========================================
        // 4. LAMBDAS CON COLLECTIONS
        // ========================================
        System.out.println("\n=== 4. LAMBDAS CON COLLECTIONS ===");

        List<String> nombres = Arrays.asList("Ana", "Carlos", "María", "Pedro", "Lucía");

        // forEach
        System.out.print("forEach: ");
        nombres.forEach(nombre -> System.out.print(nombre + " "));
        System.out.println();

        // removeIf
        List<Integer> numeros = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        numeros.removeIf(n -> n % 2 == 0); // Eliminar pares
        System.out.println("Después de removeIf (pares): " + numeros);

        // sort
        List<String> frutas = new ArrayList<>(Arrays.asList("Banana", "Manzana", "Uva", "Naranja"));
        frutas.sort((s1, s2) -> s1.compareTo(s2)); // Orden alfabético
        System.out.println("Frutas ordenadas: " + frutas);

        // Orden por longitud
        frutas.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
        System.out.println("Frutas por longitud: " + frutas);

        // replaceAll
        List<String> palabras = new ArrayList<>(Arrays.asList("hola", "mundo", "java"));
        palabras.replaceAll(s -> s.toUpperCase());
        System.out.println("Palabras en mayúsculas: " + palabras);

        // ========================================
        // 5. LAMBDAS CON MAPS
        // ========================================
        System.out.println("\n=== 5. LAMBDAS CON MAPS ===");

        Map<String, Integer> edades = new HashMap<>();
        edades.put("Ana", 25);
        edades.put("Carlos", 30);
        edades.put("María", 28);

        // forEach
        System.out.println("Contenido del mapa:");
        edades.forEach((nombre, edad) ->
                System.out.println(nombre + " tiene " + edad + " años")
        );

        // compute
        edades.compute("Ana", (nombre, edad) -> edad + 1);
        System.out.println("Edad de Ana después de compute: " + edades.get("Ana"));

        // computeIfAbsent
        edades.computeIfAbsent("Pedro", nombre -> 35);
        System.out.println("Edad de Pedro (nuevo): " + edades.get("Pedro"));

        // merge
        edades.merge("Carlos", 5, (edadVieja, incremento) -> edadVieja + incremento);
        System.out.println("Edad de Carlos después de merge: " + edades.get("Carlos"));

        // replaceAll
        edades.replaceAll((nombre, edad) -> edad + 1);
        System.out.println("Todos envejecieron un año: " + edades);

        // ========================================
        // 6. REFERENCIAS A MÉTODOS (Method References)
        // ========================================
        System.out.println("\n=== 6. REFERENCIAS A MÉTODOS ===");

        List<String> palabrasRef = Arrays.asList("lambda", "java", "stream", "functional");

        // Referencia a método estático
        palabrasRef.forEach(System.out::println); // Equivale a: s -> System.out.println(s)

        // Referencia a método de instancia
        List<String> lista = Arrays.asList("manzana", "banana", "cereza");
        lista.sort(String::compareToIgnoreCase); // Equivale a: (s1, s2) -> s1.compareToIgnoreCase(s2)
        System.out.println("Ordenado con method reference: " + lista);

        // Referencia a método de un objeto particular
        String prefijo = "Fruta: ";
        Consumer<String> imprimirConPrefijo = prefijo::concat;

        // Referencia a constructor
        Function<String, StringBuilder> constructor = StringBuilder::new;
        StringBuilder sb = constructor.apply("Hola");
        System.out.println("StringBuilder creado: " + sb);

        // ========================================
        // 7. STREAMS CON LAMBDAS
        // ========================================
        System.out.println("\n=== 7. STREAMS CON LAMBDAS ===");

        List<Integer> numerosStream = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // filter
        List<Integer> pares = numerosStream.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Números pares: " + pares);

        // map
        List<Integer> cuadrados = numerosStream.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("Cuadrados: " + cuadrados);

        // reduce
        int suma = numerosStream.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println("Suma total: " + suma);

        // Operaciones encadenadas
        int sumaParesDobles = numerosStream.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .reduce(0, Integer::sum);
        System.out.println("Suma de pares duplicados: " + sumaParesDobles);

        // anyMatch, allMatch, noneMatch
        boolean hayMayorQue5 = numerosStream.stream().anyMatch(n -> n > 5);
        boolean todosMayorQue0 = numerosStream.stream().allMatch(n -> n > 0);
        boolean ningunNegativo = numerosStream.stream().noneMatch(n -> n < 0);
        System.out.println("Hay mayor que 5: " + hayMayorQue5);
        System.out.println("Todos mayor que 0: " + todosMayorQue0);
        System.out.println("Ningún negativo: " + ningunNegativo);

        // ========================================
        // 8. EJEMPLOS PRÁCTICOS
        // ========================================
        System.out.println("\n=== 8. EJEMPLOS PRÁCTICOS ===");

        // Ejemplo 1: Filtrar y transformar nombres
        List<String> nombresCompletos = Arrays.asList(
                "Ana García", "Carlos Ruiz", "María López", "Pedro Sánchez", "Lucía Martínez"
        );

        List<String> apellidos = nombresCompletos.stream()
                .map(nombre -> nombre.split(" ")[1])
                .filter(apellido -> apellido.length() > 5)
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());
        System.out.println("Apellidos largos en mayúsculas: " + apellidos);

        // Ejemplo 2: Calcular estadísticas
        List<Integer> calificaciones = Arrays.asList(85, 92, 78, 95, 88, 76, 90);

        double promedio = calificaciones.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);

        int maxima = calificaciones.stream()
                .max(Integer::compareTo)
                .orElse(0);

        long aprobados = calificaciones.stream()
                .filter(nota -> nota >= 80)
                .count();

        System.out.println("Promedio: " + promedio);
        System.out.println("Calificación máxima: " + maxima);
        System.out.println("Aprobados (>=80): " + aprobados);

        // Ejemplo 3: Agrupar datos
        List<String> productos = Arrays.asList("Manzana", "Banana", "Mango", "Melón", "Uva");

        Map<Integer, List<String>> productosPorLongitud = productos.stream()
                .collect(Collectors.groupingBy(String::length));

        System.out.println("Productos agrupados por longitud:");
        productosPorLongitud.forEach((longitud2, lista2) ->
                System.out.println(longitud2 + " letras: " + lista2)
        );

        // Ejemplo 4: Crear calculadora con lambdas
        Map<String, BiFunction<Double, Double, Double>> calculadora = new HashMap<>();
        calculadora.put("suma", (a, b) -> a + b);
        calculadora.put("resta", (a, b) -> a - b);
        calculadora.put("multiplicacion", (a, b) -> a * b);
        calculadora.put("division", (a, b) -> a / b);

        System.out.println("\nCalculadora con lambdas:");
        double resultado = calculadora.get("suma").apply(10.0, 5.0);
        System.out.println("10 + 5 = " + resultado);
        resultado = calculadora.get("multiplicacion").apply(4.0, 7.0);
        System.out.println("4 * 7 = " + resultado);

        // Ejemplo 5: Procesamiento de texto
        String texto = "Java es un lenguaje de programación orientado a objetos";
        long palabrasMayorA3Letras = Arrays.stream(texto.split(" "))
                .filter(palabra -> palabra.length() > 3)
                .count();
        System.out.println("\nPalabras con más de 3 letras: " + palabrasMayorA3Letras);

        // Ejemplo 6: Operaciones complejas con objetos
        class Producto {
            String nombre;
            double precio;
            String categoria;

            Producto(String nombre, double precio, String categoria) {
                this.nombre = nombre;
                this.precio = precio;
                this.categoria = categoria;
            }

            public String toString() {
                return nombre + " ($" + precio + ")";
            }
        }

        List<Producto> inventario = Arrays.asList(
                new Producto("Laptop", 1200.0, "Electrónica"),
                new Producto("Mouse", 25.0, "Electrónica"),
                new Producto("Teclado", 75.0, "Electrónica"),
                new Producto("Silla", 150.0, "Muebles"),
                new Producto("Escritorio", 300.0, "Muebles")
        );

        // Productos de electrónica con precio mayor a 50
        List<Producto> electronicaCaros = inventario.stream()
                .filter(p -> p.categoria.equals("Electrónica"))
                .filter(p -> p.precio > 50)
                .sorted((p1, p2) -> Double.compare(p1.precio, p2.precio))
                .collect(Collectors.toList());

        System.out.println("\nElectrónica cara (>$50):");
        electronicaCaros.forEach(System.out::println);

        // Precio promedio por categoría
        Map<String, Double> precioPromedioPorCategoria = inventario.stream()
                .collect(Collectors.groupingBy(
                        p -> p.categoria,
                        Collectors.averagingDouble(p -> p.precio)
                ));

        System.out.println("\nPrecio promedio por categoría:");
        precioPromedioPorCategoria.forEach((cat, prom) ->
                System.out.println(cat + ": $" + String.format("%.2f", prom))
        );


    }
}
