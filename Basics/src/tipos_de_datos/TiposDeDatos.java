package tipos_de_datos;

public class TiposDeDatos {
    public static void main(String[] args) {

        // ========== TIPOS PRIMITIVOS ==========

        // Tipos enteros
        byte edad = 25; // 8 bits, de -128 a 127
        short poblacion = 30000; // 16 bits, de -32,768 a 32,767
        int habitantes = 1500000; // 32 bits, de -2,147,483,648 a 2,147,483,647
        long distanciaEstelar = 9460730472580800L; // L al final para long, 64 bits, de -2⁶³ a 2⁶³-1

        // Tipos de punto flotante
        float precio = 19.99f; // 32 bits, f al final para float
        double pi = 3.141592653589793; // 64 bits

        // Tipo carácter (formato UNICODE)
        char inicial = 'J'; // 16 bits
        char simbolo = '\u0041'; // Código Unicode para 'A'

        // Tipo booleano
        boolean esEstudiante = true;
        boolean tieneLicencia = false;

        // Imprimiendo tipos primitivos
        System.out.println("=== TIPOS PRIMITIVOS ===");
        System.out.println("byte - Edad: " + edad);
        System.out.println("short - Población: " + poblacion);
        System.out.println("int - Habitantes: " + habitantes);
        System.out.println("long - Distancia: " + distanciaEstelar);
        System.out.println("float - Precio: " + precio);
        System.out.println("double - Pi: " + pi);
        System.out.println("char - Inicial: " + inicial);
        System.out.println("char - Símbolo Unicode: " + simbolo);
        System.out.println("boolean - Es estudiante: " + esEstudiante);

        // ========== TIPOS DE REFERENCIA ==========

        // String (tipo de referencia, no primitivo)
        String nombre = "Juan Pérez";
        String mensaje = new String("Hola Mundo");

        // Arrays (tipos de referencia)
        int[] numeros = {1, 2, 3, 4, 5};
        String[] frutas = new String[3];
        frutas[0] = "Manzana";
        frutas[1] = "Banana";
        frutas[2] = "Naranja";

        // Clases wrapper (envolturas de tipos primitivos)
        Integer numeroObjeto = 100;
        Double precioObjeto = 99.99;
        Boolean activoObjeto = true;

        System.out.println("\n=== TIPOS DE REFERENCIA ===");
        System.out.println("String - Nombre: " + nombre);
        System.out.println("String - Mensaje: " + mensaje);
        System.out.print("Array int - Números: ");
        for (int num : numeros) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println("Array String - Primera fruta: " + frutas[0]);

        // ========== CONVERSIONES DE TIPOS ==========

        System.out.println("\n=== CONVERSIONES ===");

        // Conversión implícita (widening)
        int valorInt = 100;
        long valorLong = valorInt; // int a long (automático)
        double valorDouble = valorInt; // int a double (automático)
        System.out.println("Conversión implícita - int a double: " + valorDouble);

        // Conversión explícita (casting/narrowing)
        double decimal = 9.78;
        int entero = (int) decimal; // Pierde la parte decimal
        System.out.println("Conversión explícita - double a int: " + entero);

        // Conversión con wrapper classes
        String numeroTexto = "123";
        int numeroConvertido = Integer.parseInt(numeroTexto);
        System.out.println("String a int: " + numeroConvertido);

        // ========== VALORES POR DEFECTO ==========

        System.out.println("\n=== INFORMACIÓN ADICIONAL ===");
        System.out.println("Tamaño de byte: " + Byte.SIZE + " bits");
        System.out.println("Tamaño de int: " + Integer.SIZE + " bits");
        System.out.println("Valor máximo de int: " + Integer.MAX_VALUE);
        System.out.println("Valor mínimo de int: " + Integer.MIN_VALUE);
        System.out.println("Valor máximo de double: " + Double.MAX_VALUE);

        // ========== OPERACIONES CON TIPOS ==========

        System.out.println("\n=== OPERACIONES ===");
        int a = 10;
        int b = 3;
        System.out.println("Suma: " + (a + b));
        System.out.println("División entera: " + (a / b));
        System.out.println("División decimal: " + ((double)a / b));
        System.out.println("Módulo: " + (a % b));

        // Concatenación con String
        String resultado = "El resultado es: " + (a + b);
        System.out.println(resultado);


    }
}
