package tipos_de_datos;

public class MetodosWrapper {

    public static void main(String[] args) {

        // ========== INTEGER ==========
        System.out.println("=== INTEGER ===");

        // Conversión String a int
        int num1 = Integer.parseInt("123");
        System.out.println("parseInt: " + num1);

        // Conversión a String
        String str1 = Integer.toString(456);
        System.out.println("toString: " + str1);

        // Valores máximo y mínimo
        System.out.println("MAX_VALUE: " + Integer.MAX_VALUE);
        System.out.println("MIN_VALUE: " + Integer.MIN_VALUE);

        // Conversión a binario, octal, hexadecimal
        System.out.println("toBinaryString(10): " + Integer.toBinaryString(10));
        System.out.println("toOctalString(10): " + Integer.toOctalString(10));
        System.out.println("toHexString(255): " + Integer.toHexString(255));

        // Comparación
        System.out.println("compare(10, 20): " + Integer.compare(10, 20));

        // Validar si es número
        try {
            Integer.parseInt("abc");
        } catch (NumberFormatException e) {
            System.out.println("'abc' no es un número válido");
        }

        // ========== DOUBLE ==========
        System.out.println("\n=== DOUBLE ===");

        // Conversión String a double
        double num2 = Double.parseDouble("3.14");
        System.out.println("parseDouble: " + num2);

        // Verificar si es NaN o Infinito
        double resultado = 0.0 / 0.0;
        System.out.println("isNaN(0.0/0.0): " + Double.isNaN(resultado));
        System.out.println("isInfinite(1.0/0.0): " + Double.isInfinite(1.0/0.0));

        // Valores especiales
        System.out.println("MAX_VALUE: " + Double.MAX_VALUE);
        System.out.println("MIN_VALUE: " + Double.MIN_VALUE);

        // Comparación con precisión
        System.out.println("compare(3.14, 2.71): " + Double.compare(3.14, 2.71));

        // ========== BOOLEAN ==========
        System.out.println("\n=== BOOLEAN ===");

        // Conversión String a boolean
        boolean bool1 = Boolean.parseBoolean("true");
        boolean bool2 = Boolean.parseBoolean("false");
        boolean bool3 = Boolean.parseBoolean("cualquiercosa"); // false
        System.out.println("parseBoolean('true'): " + bool1);
        System.out.println("parseBoolean('cualquiercosa'): " + bool3);

        // Conversión a String
        System.out.println("toString(true): " + Boolean.toString(true));

        // Operaciones lógicas
        System.out.println("logicalAnd(true, false): " + Boolean.logicalAnd(true, false));
        System.out.println("logicalOr(true, false): " + Boolean.logicalOr(true, false));

        // ========== CHARACTER ==========
        System.out.println("\n=== CHARACTER ===");

        char ch = 'A';

        // Verificar tipo de carácter
        System.out.println("isDigit('5'): " + Character.isDigit('5'));
        System.out.println("isLetter('A'): " + Character.isLetter(ch));
        System.out.println("isUpperCase('A'): " + Character.isUpperCase(ch));
        System.out.println("isLowerCase('a'): " + Character.isLowerCase('a'));
        System.out.println("isWhitespace(' '): " + Character.isWhitespace(' '));

        // Conversión de mayúsculas/minúsculas
        System.out.println("toUpperCase('a'): " + Character.toUpperCase('a'));
        System.out.println("toLowerCase('Z'): " + Character.toLowerCase('Z'));

        // Obtener valor numérico
        System.out.println("getNumericValue('5'): " + Character.getNumericValue('5'));

        // ========== LONG ==========
        System.out.println("\n=== LONG ===");

        long num3 = Long.parseLong("9876543210");
        System.out.println("parseLong: " + num3);
        System.out.println("MAX_VALUE: " + Long.MAX_VALUE);
        System.out.println("toBinaryString: " + Long.toBinaryString(100L));

        // ========== AUTOBOXING Y UNBOXING ==========
        System.out.println("\n=== AUTOBOXING Y UNBOXING ===");

        // Autoboxing (primitivo a objeto)
        Integer objInt = 100; // Automático: Integer.valueOf(100)
        System.out.println("Autoboxing: " + objInt);

        // Unboxing (objeto a primitivo)
        int primitivo = objInt; // Automático: objInt.intValue()
        System.out.println("Unboxing: " + primitivo);

        // ========== MÉTODOS ÚTILES ADICIONALES ==========
        System.out.println("\n=== MÉTODOS ADICIONALES ===");

        // Integer: suma, resta (Java 8+)
        System.out.println("Integer.sum(5, 3): " + Integer.sum(5, 3));
        System.out.println("Integer.max(10, 20): " + Integer.max(10, 20));
        System.out.println("Integer.min(10, 20): " + Integer.min(10, 20));

        // Double: suma
        System.out.println("Double.sum(2.5, 3.7): " + Double.sum(2.5, 3.7));

        // Conversión de bases
        System.out.println("parseInt('1010', 2): " + Integer.parseInt("1010", 2)); // binario a decimal
        System.out.println("parseInt('FF', 16): " + Integer.parseInt("FF", 16)); // hex a decimal

        // Número de bits
        System.out.println("bitCount(7): " + Integer.bitCount(7)); // cantidad de bits en 1
        System.out.println("highestOneBit(10): " + Integer.highestOneBit(10));

        // Character: comparación
        System.out.println("Character.compare('a', 'b'): " + Character.compare('a', 'b'));
    }
}
