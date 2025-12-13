package funciones_y_control_de_flujo;

public class Funciones {

    // ========================================
    // 1. MÉTODOS BÁSICOS
    // ========================================

    // Método sin parámetros y sin retorno
    public static void saludar() {
        System.out.println("¡Hola, Mundo!");
    }

    // Método con parámetros y sin retorno
    public static void saludarPersona(String nombre) {
        System.out.println("¡Hola, " + nombre + "!");
    }

    // Método sin parámetros con retorno
    public static int obtenerNumeroAleatorio() {
        return (int) (Math.random() * 100);
    }

    // Método con parámetros y con retorno
    public static int sumar(int a, int b) {
        return a + b;
    }

    // Método con múltiples parámetros
    public static double calcularPromedio(double num1, double num2, double num3) {
        return (num1 + num2 + num3) / 3;
    }

    // ========================================
    // 2. SOBRECARGA DE MÉTODOS (Overloading)
    // ========================================

    // Mismo nombre, diferentes parámetros
    public static int multiplicar(int a, int b) {
        return a * b;
    }

    public static double multiplicar(double a, double b) {
        return a * b;
    }

    public static int multiplicar(int a, int b, int c) {
        return a * b * c;
    }

    // Sobrecarga con diferentes tipos
    public static void imprimir(String texto) {
        System.out.println("String: " + texto);
    }

    public static void imprimir(int numero) {
        System.out.println("Entero: " + numero);
    }

    public static void imprimir(double numero) {
        System.out.println("Decimal: " + numero);
    }

    // ========================================
    // 3. PARÁMETROS VARIABLES (Varargs)
    // ========================================

    // Acepta un número variable de argumentos
    public static int sumarTodos(int... numeros) {
        int suma = 0;
        for (int num : numeros) {
            suma += num;
        }
        return suma;
    }

    // Varargs con otros parámetros (varargs debe ser el último)
    public static void imprimirMensajes(String prefijo, String... mensajes) {
        for (String mensaje : mensajes) {
            System.out.println(prefijo + mensaje);
        }
    }

    // ========================================
    // 4. RECURSIÓN
    // ========================================

    // Factorial recursivo
    public static int factorialRecursivo(int n) {
        if (n == 0 || n == 1) {
            return 1; // Caso base
        }
        return n * factorialRecursivo(n - 1); // Llamada recursiva
    }

    // Fibonacci recursivo
    public static int fibonacciRecursivo(int n) {
        if (n <= 1) {
            return n; // Casos base
        }
        return fibonacciRecursivo(n - 1) + fibonacciRecursivo(n - 2);
    }

    // Suma de dígitos recursiva
    public static int sumaDigitosRecursiva(int n) {
        if (n == 0) {
            return 0;
        }
        return (n % 10) + sumaDigitosRecursiva(n / 10);
    }

    // Potencia recursiva
    public static int potenciaRecursiva(int base, int exponente) {
        if (exponente == 0) {
            return 1;
        }
        return base * potenciaRecursiva(base, exponente - 1);
    }

    // ========================================
    // 5. PASO POR VALOR VS PASO POR REFERENCIA
    // ========================================

    // Tipos primitivos: paso por valor
    public static void modificarPrimitivo(int numero) {
        numero = 100; // No afecta al original
    }

    // Objetos: paso por referencia
    public static void modificarArray(int[] array) {
        array[0] = 999; // SÍ afecta al original
    }

    // ========================================
    // 6. MÉTODOS QUE RETORNAN ARRAYS
    // ========================================

    public static int[] crearArraySecuencial(int tamaño) {
        int[] array = new int[tamaño];
        for (int i = 0; i < tamaño; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    public static String[] obtenerDiasSemana() {
        return new String[]{"Lunes", "Martes", "Miércoles", "Jueves", "Viernes"};
    }

    // ========================================
    // 7. MÉTODOS CON VALIDACIONES
    // ========================================

    public static int dividir(int dividendo, int divisor) {
        if (divisor == 0) {
            System.out.println("Error: División por cero");
            return 0;
        }
        return dividendo / divisor;
    }

    public static boolean esEdadValida(int edad) {
        return edad >= 0 && edad <= 150;
    }

    public static String validarEmail(String email) {
        if (email == null || email.isEmpty()) {
            return "Email vacío";
        }
        if (!email.contains("@")) {
            return "Email inválido";
        }
        return "Email válido";
    }

    // ========================================
    // 8. MÉTODOS MATEMÁTICOS
    // ========================================

    public static boolean esPrimo(int numero) {
        if (numero <= 1) return false;
        for (int i = 2; i <= Math.sqrt(numero); i++) {
            if (numero % i == 0) return false;
        }
        return true;
    }

    public static int mcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int mcm(int a, int b) {
        return (a * b) / mcd(a, b);
    }

    public static boolean esPalindromo(String texto) {
        texto = texto.toLowerCase().replaceAll("\\s+", "");
        int longitud = texto.length();
        for (int i = 0; i < longitud / 2; i++) {
            if (texto.charAt(i) != texto.charAt(longitud - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    // ========================================
    // 9. MÉTODOS DE UTILIDAD PARA ARRAYS
    // ========================================

    public static void imprimirArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static int encontrarMaximo(int[] array) {
        if (array.length == 0) return Integer.MIN_VALUE;
        int max = array[0];
        for (int num : array) {
            if (num > max) max = num;
        }
        return max;
    }

    public static int encontrarMinimo(int[] array) {
        if (array.length == 0) return Integer.MAX_VALUE;
        int min = array[0];
        for (int num : array) {
            if (num < min) min = num;
        }
        return min;
    }

    public static int[] invertirArray(int[] array) {
        int[] invertido = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            invertido[i] = array[array.length - 1 - i];
        }
        return invertido;
    }

    // ========================================
    // 10. MÉTODOS CON STRINGS
    // ========================================

    public static int contarVocales(String texto) {
        int contador = 0;
        texto = texto.toLowerCase();
        for (char c : texto.toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                contador++;
            }
        }
        return contador;
    }

    public static String invertirTexto(String texto) {
        StringBuilder invertido = new StringBuilder(texto);
        return invertido.reverse().toString();
    }

    public static String capitalizar(String texto) {
        if (texto == null || texto.isEmpty()) return texto;
        return texto.substring(0, 1).toUpperCase() + texto.substring(1).toLowerCase();
    }

    // ========================================
    // MÉTODO MAIN - PRUEBAS
    // ========================================

    public static void main(String[] args) {

        System.out.println("=== MÉTODOS BÁSICOS ===");
        saludar();
        saludarPersona("Juan");
        System.out.println("Número aleatorio: " + obtenerNumeroAleatorio());
        System.out.println("Suma: " + sumar(5, 3));
        System.out.println("Promedio: " + calcularPromedio(8.5, 7.0, 9.0));

        System.out.println("\n=== SOBRECARGA ===");
        System.out.println("Multiplicar(2, 3): " + multiplicar(2, 3));
        System.out.println("Multiplicar(2.5, 3.2): " + multiplicar(2.5, 3.2));
        System.out.println("Multiplicar(2, 3, 4): " + multiplicar(2, 3, 4));
        imprimir("Hola");
        imprimir(42);
        imprimir(3.14);

        System.out.println("\n=== VARARGS ===");
        System.out.println("Suma de 1,2,3,4,5: " + sumarTodos(1, 2, 3, 4, 5));
        System.out.println("Suma de 10,20: " + sumarTodos(10, 20));
        imprimirMensajes(">> ", "Mensaje 1", "Mensaje 2", "Mensaje 3");

        System.out.println("\n=== RECURSIÓN ===");
        System.out.println("Factorial de 5: " + factorialRecursivo(5));
        System.out.println("Fibonacci de 7: " + fibonacciRecursivo(7));
        System.out.println("Suma dígitos de 12345: " + sumaDigitosRecursiva(12345));
        System.out.println("2^8 = " + potenciaRecursiva(2, 8));

        System.out.println("\n=== PASO POR VALOR/REFERENCIA ===");
        int num = 10;
        modificarPrimitivo(num);
        System.out.println("Después de modificar primitivo: " + num);

        int[] arr = {1, 2, 3};
        modificarArray(arr);
        System.out.println("Después de modificar array: " + arr[0]);

        System.out.println("\n=== MÉTODOS QUE RETORNAN ARRAYS ===");
        int[] secuencia = crearArraySecuencial(5);
        imprimirArray(secuencia);
        String[] dias = obtenerDiasSemana();
        System.out.println("Primer día: " + dias[0]);

        System.out.println("\n=== VALIDACIONES ===");
        System.out.println("10 / 2 = " + dividir(10, 2));
        System.out.println("10 / 0 = " + dividir(10, 0));
        System.out.println("Edad 25 válida: " + esEdadValida(25));
        System.out.println("Edad 200 válida: " + esEdadValida(200));
        System.out.println(validarEmail("usuario@ejemplo.com"));
        System.out.println(validarEmail("invalido"));

        System.out.println("\n=== MÉTODOS MATEMÁTICOS ===");
        System.out.println("17 es primo: " + esPrimo(17));
        System.out.println("20 es primo: " + esPrimo(20));
        System.out.println("MCD(24, 36): " + mcd(24, 36));
        System.out.println("MCM(4, 6): " + mcm(4, 6));
        System.out.println("'anilina' es palíndromo: " + esPalindromo("anilina"));
        System.out.println("'hola' es palíndromo: " + esPalindromo("hola"));

        System.out.println("\n=== UTILIDADES ARRAYS ===");
        int[] numeros = {5, 2, 8, 1, 9, 3};
        System.out.print("Array original: ");
        imprimirArray(numeros);
        System.out.println("Máximo: " + encontrarMaximo(numeros));
        System.out.println("Mínimo: " + encontrarMinimo(numeros));
        System.out.print("Array invertido: ");
        imprimirArray(invertirArray(numeros));

        System.out.println("\n=== MÉTODOS CON STRINGS ===");
        String texto = "Hola Mundo";
        System.out.println("Vocales en '" + texto + "': " + contarVocales(texto));
        System.out.println("Invertido: " + invertirTexto(texto));
        System.out.println("Capitalizado: " + capitalizar("hOlA"));
    }
}
