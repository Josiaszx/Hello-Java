Los **Streams** en Java son una abstracción introducida en Java 8 que permite procesar colecciones de datos de manera declarativa y funcional. No son estructuras de datos, sino una secuencia de elementos que soportan operaciones agregadas.

## Implementacion en codigo

- [Código](../Basics/src/streams)

## Conceptos Fundamentales

Un Stream representa una secuencia de elementos y soporta diferentes tipos de operaciones para procesarlos. Las operaciones pueden ser:

- **Intermedias**: retornan un nuevo Stream (filter, map, sorted)
- **Terminales**: producen un resultado o efecto secundario (collect, forEach, reduce)

Los Streams son perezosos (lazy): las operaciones intermedias solo se ejecutan cuando se invoca una operación terminal.

## Características Principales

- **No almacenan datos**: son vistas de fuentes de datos
- **Funcionales**: no modifican la fuente original
- **Perezosos**: se evalúan bajo demanda
- **Consumibles**: solo se pueden usar una vez
- **Opcionalmente paralelos**: soportan procesamiento concurrente

## Mejores Prácticas

1. **Usar el método correcto**: Prefiere `filter` antes de `map` para reducir elementos procesados
2. **Evitar efectos secundarios**: Las operaciones deben ser puras y sin efectos laterales
3. **No reutilizar streams**: Un stream solo puede consumirse una vez
4. **Usar operaciones terminales cortas**: Prefiere `findFirst()` sobre `collect()` si solo necesitas un elemento
5. **Considerar paralelización cuidadosamente**: No siempre mejora el rendimiento
6. **Preferir method references**: `String::length` en lugar de `s -> s.length()`
7. **Manejar Optional correctamente**: Usa `ifPresent()`, `orElse()`, etc.

## Cuándo usar Streams vs Loops tradicionales

**Usar Streams cuando**:

- Necesitamos operaciones de filtrado, mapeo o reducción complejas
- Queremos código más declarativo y legible
- Necesitamos paralelización fácil
- Trabajamos con pipelines de transformación de datos

**Usar loops tradicionales cuando**:

- Necesitamos modificar la colección durante la iteración
- Requerimos control fino sobre el flujo (break, continue específicos)
- El rendimiento sea crítico en operaciones muy simples
- Necesitamos manejar excepciones checked