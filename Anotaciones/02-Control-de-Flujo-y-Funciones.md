## Implementación en código

- [Funciones](../Basics/src/funciones_y_control_de_flujo/Funciones.java)
- [Control de flujo](../Basics/src/funciones_y_control_de_flujo/EstructurasDeControl.java)

## **Control de Flujo en Java**

### **1. Condicionales**

- **if-else**: Evalúa condiciones booleanas
- **if-else if-else**: Múltiples condiciones en cadena
- **Operador ternario**: `condición ? valorSi : valorNo` (if-else en una línea)
- **switch**: Compara una variable contra múltiples casos
    - Soporta int, byte, short, char, String, enum
    - Switch expressions (Java 14+): sintaxis moderna con `->`

### **2. Bucles**

- **for**: Repetición con contador conocido
    - Sintaxis: `for (inicialización; condición; incremento)`
- **for-each**: Itera sobre colecciones/arrays
    - Sintaxis: `for (tipo variable : colección)`
- **while**: Repetición mientras condición sea verdadera (puede no ejecutarse)
- **do-while**: Se ejecuta al menos una vez, luego verifica condición

### **3. Control de Flujo**

- **break**: Sale del bucle o switch actual
- **continue**: Salta a la siguiente iteración
- **return**: Sale del método actual
- **Etiquetas**: Permiten controlar bucles anidados

### **Cuándo usar cada bucle:**

- **for**: Cuando sabes cuántas iteraciones necesitas
- **for-each**: Para recorrer colecciones completas
- **while**: Cuando no sabes cuántas iteraciones necesitas
- **do-while**: Cuando necesitas ejecutar al menos una vez

---

## **Funciones**

### **1. Componentes de un Método**

```java
modificadorAcceso tipoRetorno nombreMetodo(parametros) {
    // cuerpo del método
    return valor; // si no es void
}
```

### **2. Modificadores de Acceso**

- **public**: Accesible desde cualquier lugar
- **private**: Solo dentro de la misma clase
- **protected**: En la misma clase y subclases
- **default** (sin modificador): En el mismo paquete

### **3. Modificador Static**

- **static**: Pertenece a la clase, no a instancias
- Se llama con `NombreClase.metodo()` o directamente en la misma clase

### **4. Tipos de Métodos**

- **Sin retorno (void)**: Ejecuta acciones sin devolver valor
- **Con retorno**: Devuelve un valor de un tipo específico
- **Con/sin parámetros**: Reciben datos de entrada o no

### **5. Conceptos Importantes**

**Sobrecarga (Overloading):**

- Mismo nombre, diferentes parámetros
- Diferente número o tipo de parámetros
- Permite múltiples versiones del mismo método

**Varargs:**

- Parámetros variables: `tipo... nombre`
- Debe ser el último parámetro
- Se trata como un array dentro del método

**Recursión:**

- Método que se llama a sí mismo
- Necesita caso base para terminar
- Útil para problemas que se dividen en subproblemas similares

**Paso de Parámetros:**

- **Primitivos**: Paso por valor (copia del valor)
- **Objetos/Arrays**: Paso por referencia (referencia al objeto)

### **6. Buenas Prácticas**

- Nombres descriptivos en camelCase
- Un método debe hacer una cosa bien
- Mantener métodos cortos (máximo 20-30 líneas)
- Validar parámetros de entrada
- Documentar métodos complejos
- Evitar efectos secundarios inesperados
- Usar return temprano para validaciones