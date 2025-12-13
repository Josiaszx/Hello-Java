
# Programacion Orientada a Objetos (POO)

## **Pilares de la POO**

### **1. Encapsulación**

**Concepto:** Ocultar los detalles internos de implementación y exponer solo lo necesario.

**Implementación:**

- Atributos `private`
- Métodos `public` para acceso controlado (getters/setters)
- Validación en los métodos de modificación

**Beneficios:**

- Protección de datos
- Control sobre cómo se modifican los atributos
- Facilita el mantenimiento del código

### **2. Herencia**

**Concepto:** Una clase (hija) hereda atributos y métodos de otra clase (padre).

**Palabras clave:**

- `extends`: Para heredar de una clase
- `super`: Acceder a miembros de la clase padre
- `@Override`: Indica sobreescritura de método

**Características:**

- Java solo permite herencia simple (una clase padre)
- La clase hija obtiene todo lo público y protegido del padre
- Puede sobrescribir métodos del padre

### **3. Polimorfismo**

**Concepto:** Un objeto puede tomar muchas formas. Permite tratar objetos de diferentes clases de manera uniforme.

**Tipos:**

- **Polimorfismo de sobrecarga:** Mismo método, diferentes parámetros (en tiempo de compilación)
- **Polimorfismo de sobreescritura:** Mismo método, diferente implementación en clases hijas (en tiempo de ejecución)

**Ejemplo:**

```java
Animal animal = new Perro(); // Referencia padre, objeto hijo
animal.hacerSonido(); // Ejecuta el método de Perro

```

### **4. Abstracción**

**Concepto:** Mostrar solo la funcionalidad esencial, ocultando los detalles de implementación.

**Implementación:**

- **Clases abstractas:** Pueden tener métodos abstractos y concretos
- **Interfaces:** Solo métodos abstractos (hasta Java 7)

## **Conceptos Clave**

### **Clases y Objetos**

- **Clase:** Plantilla o molde (blueprint)
- **Objeto:** Instancia de una clase
- **Atributos:** Características (variables)
- **Métodos:** Comportamientos (funciones)

### **Constructores**

- Método especial para inicializar objetos
- Mismo nombre que la clase
- No tiene tipo de retorno
- Puede estar sobrecargado
- Si no se define, Java crea uno por defecto

### **Modificadores de Acceso**

| Modificador | Misma Clase | Mismo Paquete | Subclases | Todos |
| --- | --- | --- | --- | --- |
| `private` | ✓ | ✗ | ✗ | ✗ |
| `default` | ✓ | ✓ | ✗ | ✗ |
| `protected` | ✓ | ✓ | ✓ | ✗ |
| `public` | ✓ | ✓ | ✓ | ✓ |

### **Palabra Clave `static`**

- Pertenece a la clase, no a instancias
- Compartido por todos los objetos
- Se accede con `NombreClase.miembro`
- Variables estáticas: una copia para toda la clase
- Métodos estáticos: no acceden a miembros de instancia

### **Palabra Clave `final`**

- **Variable final:** Constante (no puede cambiar)
- **Método final:** No puede ser sobrescrito
- **Clase final:** No puede ser heredada

### **Clases Abstractas vs Interfaces**

| Característica | Clase Abstracta | Interfaz |
| --- | --- | --- |
| Métodos | Abstractos y concretos | Solo abstractos (Java 7) |
| Variables | Cualquier tipo | Solo constantes |
| Herencia | Herencia simple | Múltiple implementación |
| Constructor | Puede tener | No puede tener |
| Cuándo usar | Relación "es-un" fuerte | Capacidades/contratos |

### **Ventajas de la POO**

- **Reutilización:** Código reusable mediante herencia
- **Modularidad:** Código organizado en clases
- **Mantenibilidad:** Cambios localizados
- **Escalabilidad:** Fácil agregar nuevas funcionalidades
- **Seguridad:** Encapsulación protege datos
- **Flexibilidad:** Polimorfismo permite código flexible

### **Principios SOLID (Básicos)**

- **S** - Single Responsibility: Una clase, una responsabilidad
- **O** - Open/Closed: Abierto a extensión, cerrado a modificación
- **L** - Liskov Substitution: Las subclases deben ser sustituibles por sus clases base
- **I** - Interface Segregation: Interfaces específicas mejor que generales
- **D** - Dependency Inversion: Depender de abstracciones, no de implementaciones

### **Buenas Prácticas**

1. **Usar encapsulación:** Atributos privados, acceso controlado
2. **Preferir composición sobre herencia** cuando sea apropiado
3. **Programar hacia interfaces** no hacia implementaciones
4. **Mantener clases cohesivas:** Una responsabilidad por clase
5. **Evitar herencia profunda:** Máximo 3-4 niveles
6. **Usar nombres descriptivos** para clases y métodos
7. **Documentar clases públicas** y métodos complejos

## Implementación en codigo

- [Encapsulación](../Basics/src/poo/encapsulacion/CuentaBancaria.java)
- [Herencia](../Basics/src/poo/herencia)
- [Polimorfismo](../Basics/src/poo/polimorfismo)
- [Abstraccion](../Basics/src/poo/abstraccion)
- [Interfaces](../Basics/src/poo/interfaces)
- [Clases anidadas](../Basics/src/poo/ClasesAnidadas.java)
- [Implementacion completa](../Basics/src/poo/POOCompleto.java)