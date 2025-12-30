# Optionals

Los Optionals son una clase contenedora introducida en Java 8 para representar valores que pueden o no estar presentes, evitando así los temidos `NullPointerException` y haciendo el código más expresivo y seguro.

## Concepto Fundamental

`Optional<T>` es un contenedor que puede contener un valor de tipo T o estar vacío. Es una forma de comunicar explícitamente que un valor puede no existir, en lugar de usar `null`.

## Resumen de Métodos Principales

**Creación:**

- `Optional.empty()` - Optional vacío
- `Optional.of(valor)` - Con valor no nulo (lanza excepción si es null)
- `Optional.ofNullable(valor)` - Puede ser null

**Verificación:**

- `isPresent()` - Retorna true si hay valor
- `isEmpty()` - Retorna true si está vacío (Java 11+)

**Obtención:**

- `get()` - Obtiene valor (lanza excepción si vacío)
- `orElse(valor)` - Valor por defecto
- `orElseGet(Supplier)` - Valor por defecto calculado perezosamente
- `orElseThrow(Supplier)` - Lanza excepción personalizada

**Transformación:**

- `map(Function)` - Transforma el valor
- `flatMap(Function)` - Transforma a otro Optional
- `filter(Predicate)` - Filtra según condición

**Acciones:**

- `ifPresent(Consumer)` - Ejecuta acción si hay valor
- `ifPresentOrElse(Consumer, Runnable)` - Acción condicional (Java 9+)

**Otros (Java 9+):**

- `or(Supplier<Optional>)` - Optional alternativo
- `stream()` - Convierte a Stream