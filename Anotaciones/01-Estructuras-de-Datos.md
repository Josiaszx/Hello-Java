# Estructuras de datos

## 1. **Arrays**

- Tamaño fijo, elementos del mismo tipo
- Acceso rápido por índice O(1)
- No pueden cambiar de tamaño después de ser creados


## 2. **Lists**

### ArrayList

- Basado en array dinámico
- Acceso rápido O(1), inserción/eliminación lenta O(n)
- Ideal cuando necesitas acceso frecuente por índice

### LinkedList

- Basado en nodos enlazados
- Inserción/eliminación rápida O(1), acceso lento O(n)
- Ideal para operaciones frecuentes de agregar/eliminar al inicio/final

## 3. **Stack (Pila)**

- LIFO (Last In, First Out)
- Métodos: `push()`, `pop()`, `peek()`
- Útil para deshacer/rehacer, navegación de historial

## 4. **Queue (Cola)**

- FIFO (First In, First Out)
- Métodos: `offer()`, `poll()`, `peek()`
- Útil para procesar elementos en orden de llegada

### PriorityQueue

- Los elementos se ordenan según su prioridad natural
- Útil para algoritmos que requieren procesar elementos por prioridad

## 5. **Sets (Conjuntos)**

### HashSet

- No permite duplicados, sin orden garantizado
- Operaciones rápidas O(1)
- Ideal para verificar existencia de elementos

### LinkedHashSet

- Mantiene orden de inserción
- Ligeramente más lento que HashSet

### TreeSet

- Elementos ordenados automáticamente
- Operaciones O(log n)
- Ideal cuando necesitas elementos ordenados

## 6. **Maps (Mapas)**

### HashMap

- Pares clave-valor, sin orden garantizado
- Operaciones rápidas O(1)
- Más usado para búsquedas rápidas

### LinkedHashMap

- Mantiene orden de inserción
- Útil para cachés con política LRU

### TreeMap

- Claves ordenadas automáticamente
- Operaciones O(log n)
- Ideal cuando necesitas claves ordenadas

## Comparación de complejidad temporal
| Estructura | Acceso | Búsqueda | Inserción | Eliminación |
| --- | --- | --- | --- | --- |
| Array | O(1) | O(n) | O(n) | O(n) |
| ArrayList | O(1) | O(n) | O(n) | O(n) |
| LinkedList | O(n) | O(n) | O(1) | O(1) |
| HashSet | - | O(1) | O(1) | O(1) |
| TreeSet | - | O(log n) | O(log n) | O(log n) |
| HashMap | O(1) | O(1) | O(1) | O(1) |
| TreeMap | O(log n) | O(log n) | O(log n) | O(log n) |

## Cuándo usar cada una

- **ArrayList**: Acceso frecuente por índice
- **LinkedList**: Muchas inserciones/eliminaciones
- **HashSet**: Verificar duplicados, búsquedas rápidas
- **TreeSet**: Necesidad de elementos ordenados automáticamente
- **HashMap**: Búsquedas rápidas por clave
- **TreeMap**: Necesidad de claves ordenadas
- **Stack**: Operaciones LIFO
- **Queue**: Operaciones FIFO

## Implementacion
- [Codigo](../Basics/src/estructuras_de_datos/EstructurasDeDatos.java)