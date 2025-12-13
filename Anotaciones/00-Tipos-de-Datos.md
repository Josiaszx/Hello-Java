# Tipos de Datos

Java es un lenguaje fuertemente tipado que divide sus tipos de datos en dos categorías principales: **tipos primitivos** y **tipos de referencia**.

## Tipos primitivos

Java tiene 8 tipos primitivos que almacenan valores directamente en memoria:

### Tipos enteros

- **byte**: 8 bits, rango de -128 a 127
- **short**: 16 bits, rango de -32,768 a 32,767
- **int**: 32 bits, rango de -2³¹ a 2³¹-1 (el más usado)
- **long**: 64 bits, rango de -2⁶³ a 2⁶³-1 (se marca con 'L' al final)

### Tipos de punto flotante

- **float**: 32 bits, precisión simple (se marca con 'f' al final)
- **double**: 64 bits, precisión doble (el más usado para decimales)

### Otros tipos

- **char**: 16 bits, representa un carácter Unicode (entre comillas simples)
- **boolean**: representa verdadero o falso

## Tipos de referencia

Los tipos de referencia almacenan direcciones de memoria donde se encuentran los objetos. Incluyen clases, interfaces, arrays y enumeraciones.

## Puntos clave a recordar

**Diferencias entre primitivos y referencias:**

- Los tipos primitivos almacenan el valor directamente, mientras que las referencias almacenan la dirección de memoria del objeto
- Los primitivos son más eficientes en memoria y rendimiento
- Las referencias pueden ser `null`, los primitivos no

**Conversiones:**

- **Implícita (widening)**: de menor a mayor capacidad automáticamente (int → long → double)
- **Explícita (casting)**: de mayor a menor capacidad requiere conversión manual y puede perder información

**Clases Wrapper:**
Cada tipo primitivo tiene su clase equivalente: Integer, Double, Boolean, Character, etc. Estas permiten usar primitivos como objetos y proporcionan métodos útiles para conversiones y operaciones.

## Métodos útiles de clases wrapper

**Integer, Long, Short, Byte:**

- `parseInt()` / `parseLong()`: convierte String a primitivo
- `toString()`: convierte a String
- `compare()`: compara dos valores
- `MAX_VALUE` / `MIN_VALUE`: límites del tipo
- `toBinaryString()`, `toHexString()`, `toOctalString()`: conversión de bases
- `sum()`, `max()`, `min()`: operaciones matemáticas

**Double, Float:**

- `parseDouble()` / `parseFloat()`: convierte String a primitivo
- `isNaN()`: verifica si es "Not a Number"
- `isInfinite()`: verifica si es infinito
- `compare()`: comparación con manejo de NaN e infinitos

**Boolean:**

- `parseBoolean()`: convierte String a boolean (solo "true" es verdadero)
- `logicalAnd()`, `logicalOr()`, `logicalXor()`: operaciones lógicas

**Character:**

- `isDigit()`, `isLetter()`, `isUpperCase()`, `isLowerCase()`: verificaciones de tipo
- `toUpperCase()`, `toLowerCase()`: conversión de mayúsculas/minúsculas
- `getNumericValue()`: obtiene valor numérico del carácter

## Implementación en Código
[Tipos de datos](../Basics/src/tipos_de_datos/TiposDeDatos.java)
|
[Metdos de clases wrapper](../Basics/src/tipos_de_datos/MetodosWrapper.java)
