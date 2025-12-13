package funciones_y_control_de_flujo;

public class EstructurasDeControl {
    public static void main(String[] args) {

        // ========================================
        // 1. CONDICIONALES IF-ELSE
        // ========================================
        System.out.println("=== IF-ELSE ===");

        int edad = 18;

        // If simple
        if (edad >= 18) {
            System.out.println("Eres mayor de edad");
        }

        // If-else
        if (edad >= 18) {
            System.out.println("Puedes votar");
        } else {
            System.out.println("No puedes votar");
        }

        // If-else if-else
        int nota = 85;
        if (nota >= 90) {
            System.out.println("Calificación: A");
        } else if (nota >= 80) {
            System.out.println("Calificación: B");
        } else if (nota >= 70) {
            System.out.println("Calificación: C");
        } else if (nota >= 60) {
            System.out.println("Calificación: D");
        } else {
            System.out.println("Calificación: F");
        }


        // Operador ternario (if-else corto)
        String resultado = (edad >= 18) ? "Mayor" : "Menor";
        System.out.println("Estado: " + resultado);

        // ========================================
        // 2. SWITCH
        // ========================================
        System.out.println("\n=== SWITCH ===");

        int dia = 3;
        String nombreDia;

        // Switch tradicional
        switch (dia) {
            case 1:
                nombreDia = "Lunes";
                break;
            case 2:
                nombreDia = "Martes";
                break;
            case 3:
                nombreDia = "Miércoles";
                break;
            case 4:
                nombreDia = "Jueves";
                break;
            case 5:
                nombreDia = "Viernes";
                break;
            case 6:
                nombreDia = "Sábado";
                break;
            case 7:
                nombreDia = "Domingo";
                break;
            default:
                nombreDia = "Día inválido";
                break;
        }
        System.out.println("Día: " + nombreDia);

        // Switch con múltiples casos
        int mes = 2;
        int diasDelMes;

        switch (mes) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                diasDelMes = 31;
                break;
            case 4: case 6: case 9: case 11:
                diasDelMes = 30;
                break;
            case 2:
                diasDelMes = 28;
                break;
            default:
                diasDelMes = 0;
                break;
        }
        System.out.println("Días del mes: " + diasDelMes);

        // Switch con String
        String fruta = "manzana";

        switch (fruta) {
            case "manzana":
                System.out.println("La manzana es roja");
                break;
            case "banana":
                System.out.println("La banana es amarilla");
                break;
            case "naranja":
                System.out.println("La naranja es naranja");
                break;
            default:
                System.out.println("Fruta desconocida");
        }

        // Switch expressions (Java 14+) - Sintaxis moderna
        String tipoComida = switch (dia) {
            case 1, 2, 3, 4, 5 -> "Comida de semana";
            case 6, 7 -> "Comida de fin de semana";
            default -> "Día inválido";
        };
        System.out.println(tipoComida);


        // ========================================
        // 3. BUCLE FOR
        // ========================================
        System.out.println("\n=== BUCLE FOR ===");

        // For clásico
        System.out.print("Números del 1 al 5: ");
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // For con múltiples variables
        for (int i = 0, j = 10; i < j; i++, j--) {
            System.out.println("i=" + i + ", j=" + j);
        }


        // ========================================
        // 4. FOR-EACH (Enhanced For)
        // ========================================
        System.out.println("\n=== FOR-EACH ===");

        int[] numeros = {10, 20, 30, 40, 50};

        System.out.print("Array con for-each: ");
        for (int numero : numeros) {
            System.out.print(numero + " ");
        }
        System.out.println();

        String[] frutas = {"Manzana", "Banana", "Naranja"};
        for (String f : frutas) {
            System.out.println("Fruta: " + f);
        }

        // ========================================
        // 5. BUCLE WHILE
        // ========================================
        System.out.println("\n=== WHILE ===");

        int contador = 1;
        System.out.print("Contador con while: ");
        while (contador <= 5) {
            System.out.print(contador + " ");
            contador++;
        }
        System.out.println();

        // While con condición compleja
        int suma = 0;
        int numero = 1;
        while (suma < 20) {
            suma += numero;
            numero++;
        }
        System.out.println("Suma alcanzó " + suma + " en " + (numero-1) + " iteraciones");

        // While infinito (con break)
        int intentos = 0;
        while (true) {
            intentos++;
            if (intentos == 3) {
                System.out.println("Saliendo del bucle infinito en intento " + intentos);
                break;
            }
        }

        // ========================================
        // 6. BUCLE DO-WHILE
        // ========================================
        System.out.println("\n=== DO-WHILE ===");

        int n = 1;
        do {
            System.out.print(n + " ");
            n++;
        } while (n <= 5);
        System.out.println();

        // Do-while se ejecuta al menos una vez
        int x = 10;
        do {
            System.out.println("Se ejecuta aunque x > 5");
        } while (x < 5);

        // ========================================
        // 7. BREAK
        // ========================================
        System.out.println("\n=== BREAK ===");

        // Break en for
        System.out.print("Buscar el 7: ");
        for (int i = 1; i <= 10; i++) {
            if (i == 7) {
                System.out.println("¡Encontrado en " + i + "!");
                break;
            }
            System.out.print(i + " ");
        }

        // Break en bucle anidado (solo sale del interno)
        System.out.println("\nBreak en bucle anidado:");
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (j == 2) break;
                System.out.println("i=" + i + ", j=" + j);
            }
        }

        // Break con etiqueta (sale de ambos bucles)
        System.out.println("Break con etiqueta:");
        externo:
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i == 2 && j == 2) {
                    System.out.println("Saliendo completamente");
                    break externo;
                }
                System.out.println("i=" + i + ", j=" + j);
            }
        }

        // ========================================
        // 8. CONTINUE
        // ========================================
        System.out.println("\n=== CONTINUE ===");

        // Continue salta a la siguiente iteración
        System.out.print("Números sin el 5: ");
        for (int i = 1; i <= 10; i++) {
            if (i == 5) {
                continue;
            }
            System.out.print(i + " ");
        }
        System.out.println();

        // Continue con números pares
        System.out.print("Solo impares: ");
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue;
            }
            System.out.print(i + " ");
        }
        System.out.println();

        // Continue con etiqueta
        System.out.println("Continue con etiqueta:");
        exterior:
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (j == 2) {
                    continue exterior;
                }
                System.out.println("i=" + i + ", j=" + j);
            }
        }

        // ========================================
        // 9. RETURN
        // ========================================
        System.out.println("\n=== RETURN ===");

        // Return sale de un método inmediatamente
        int resultadoBusqueda = buscarNumero(new int[]{1, 2, 3, 4, 5}, 3);
        System.out.println("Número encontrado en índice: " + resultadoBusqueda);

        // ========================================
        // 10. EJEMPLOS PRÁCTICOS
        // ========================================
        System.out.println("\n=== EJEMPLOS PRÁCTICOS ===");

        // Factorial
        int num = 5;
        int factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial *= i;
        }
        System.out.println("Factorial de " + num + " = " + factorial);

        // Fibonacci
        System.out.print("Serie Fibonacci (10 términos): ");
        int a = 0, b = 1;
        for (int i = 0; i < 10; i++) {
            System.out.print(a + " ");
            int temp = a + b;
            a = b;
            b = temp;
        }
        System.out.println();

        // Número primo
        int numPrimo = 17;
        boolean esPrimo = true;
        for (int i = 2; i <= Math.sqrt(numPrimo); i++) {
            if (numPrimo % i == 0) {
                esPrimo = false;
                break;
            }
        }
        System.out.println(numPrimo + " es primo: " + esPrimo);

        // Palíndromo
        String palabra = "anilina";
        boolean esPalindromo = true;
        int longitud = palabra.length();
        for (int i = 0; i < longitud / 2; i++) {
            if (palabra.charAt(i) != palabra.charAt(longitud - 1 - i)) {
                esPalindromo = false;
                break;
            }
        }
        System.out.println(palabra + " es palíndromo: " + esPalindromo);

        // Suma de dígitos
        int numeroOriginal = 12345;
        int sumaDigitos = 0;
        int temp = numeroOriginal;
        while (temp > 0) {
            sumaDigitos += temp % 10;
            temp /= 10;
        }
        System.out.println("Suma de dígitos de " + numeroOriginal + " = " + sumaDigitos);
    }

    // Método auxiliar para ejemplo de return
    public static int buscarNumero(int[] array, int objetivo) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == objetivo) {
                return i; // Sale del método inmediatamente
            }
        }
        return -1; // No encontrado
    }
}