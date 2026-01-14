# Threads

Un thread (hilo de ejecución) es la unidad más pequeña de procesamiento que puede ser programada por un sistema operativo. En Java, los threads permiten la ejecución concurrente de múltiples tareas dentro de un mismo programa, aprovechando mejor los recursos del sistema y mejorando el rendimiento en aplicaciones modernas.

## Conceptos Fundamentales

### Concurrencia vs Paralelismo

**Concurrencia** se refiere a la capacidad de un sistema para manejar múltiples tareas simultáneamente, alternando rápidamente entre ellas. **Paralelismo** implica la ejecución literal y simultánea de múltiples tareas en diferentes núcleos de procesador. Java soporta ambos conceptos a través de su API de threads.

### Proceso vs Thread

Un **proceso** es una instancia en ejecución de un programa con su propio espacio de memoria. Un **thread** es una secuencia de ejecución dentro de un proceso que comparte el mismo espacio de memoria con otros threads del mismo proceso. Esto hace que los threads sean más ligeros y la comunicación entre ellos sea más eficiente, pero también introduce desafíos de sincronización.

## Ciclo de Vida de un Thread

Un thread en Java pasa por varios estados durante su existencia:

**NEW**: El thread ha sido creado pero aún no ha comenzado su ejecución.

**RUNNABLE**: El thread está listo para ejecutarse o está en ejecución. En este estado, el thread puede estar esperando tiempo de CPU del planificador del sistema operativo.

**BLOCKED**: El thread está bloqueado esperando adquirir un monitor lock para entrar en una sección sincronizada.

**WAITING**: El thread está esperando indefinidamente a que otro thread realice una acción particular, como cuando se llama a `wait()` sin timeout.

**TIMED_WAITING**: El thread está esperando por un período de tiempo específico, como cuando se llama a `sleep()` o `wait()` con timeout.

**TERMINATED**: El thread ha completado su ejecución o ha sido terminado abruptamente.

## Creación de Threads en Java

### Extendiendo la clase Thread

La primera forma de crear un thread es extender la clase `Thread` y sobrescribir su método `run()`. El método `run()` contiene el código que será ejecutado por el thread. Para iniciar la ejecución, se debe llamar al método `start()`, no directamente a `run()`.

**Ejemplo:**

```java
public class HiloThread extends Thread {
    private String nombre;

    public HiloThread(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(nombre + " - Iteración: " + i);
            try {
                Thread.sleep(1000); // Pausa de 1 segundo
            } catch (InterruptedException e) {
                System.out.println("Hilo interrumpido");
            }
        }
    }
}

// Uso
public class Main {
    public static void main(String[] args) {
        HiloThread hilo1 = new HiloThread("Hilo-A");
        HiloThread hilo2 = new HiloThread("Hilo-B");

        hilo1.start(); // Inicia el thread
        hilo2.start();
    }
}

```

### Implementando la interfaz Runnable

La forma más flexible es implementar la interfaz `Runnable`, que tiene un solo método `run()`. Esta aproximación es mejor porque Java no soporta herencia múltiple, y usar Runnable permite que la clase extienda otra clase si es necesario. Se crea un objeto Thread pasando la instancia Runnable al constructor.

**Ejemplo:**

```java
public class HiloRunnable implements Runnable {
    private String nombre;

    public HiloRunnable(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(nombre + " - Contador: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

// Uso
public class Main {
    public static void main(String[] args) {
        Thread hilo1 = new Thread(new HiloRunnable("Runnable-1"));
        Thread hilo2 = new Thread(new HiloRunnable("Runnable-2"));

        hilo1.start();
        hilo2.start();
    }
}

```

### Expresiones Lambda (Java 8+)

Dado que Runnable y Callable son interfaces funcionales, pueden ser implementadas usando expresiones lambda, haciendo el código más conciso y legible.

## Métodos Importantes de la clase Thread

`start()`: Inicia la ejecución del thread, haciendo que la JVM llame al método `run()` en un nuevo hilo de ejecución.

`run()`: Contiene el código que será ejecutado por el thread. No debe ser llamado directamente.

`sleep(long millis)`: Pausa la ejecución del thread actual por el número especificado de milisegundos. Es un método estático.

`join()`: Espera a que el thread sobre el que se invoca termine su ejecución. Puede especificarse un timeout.

`interrupt()`: Interrumpe un thread, estableciendo su flag de interrupción. Si el thread está en sleep, wait o join, lanzará una InterruptedException.

`isAlive()`: Retorna true si el thread ha sido iniciado y no ha terminado.

`setName()` **/** `getName()`: Establece u obtiene el nombre del thread, útil para debugging.

`setPriority()` **/** `getPriority()`: Establece u obtiene la prioridad del thread (valores de 1 a 10). Los threads con mayor prioridad tienen preferencia en el planificador, aunque esto es solo una sugerencia para la JVM.

`setDaemon()` **/** `isDaemon()`: Los daemon threads son threads de servicio que no impiden que la JVM termine. La JVM termina cuando solo quedan daemon threads ejecutándose.

`currentThread()`: Método estático que retorna una referencia al thread actualmente en ejecución.

`yield()`: Sugerencia al planificador de que el thread actual está dispuesto a ceder su tiempo de CPU.

## Sincronización de Threads

Cuando múltiples threads acceden a recursos compartidos, pueden ocurrir **condiciones de carrera** (race conditions) donde el resultado depende del orden impredecible de ejecución de los threads. La sincronización es el mecanismo para controlar el acceso de múltiples threads a recursos compartidos.

### Synchronized

La palabra clave `synchronized` puede aplicarse a métodos o bloques de código. Garantiza que solo un thread pueda ejecutar ese código a la vez. Cada objeto en Java tiene un monitor lock asociado. Cuando un thread entra en un método o bloque sincronizado, adquiere el lock, y otros threads que intenten entrar deben esperar.

Los métodos sincronizados de instancia usan el lock del objeto (`this`). Los métodos sincronizados estáticos usan el lock del objeto Class. Los bloques sincronizados permiten especificar explícitamente qué objeto se usa como lock, ofreciendo un control más granular.

### Métodos wait(), notify() y notifyAll()

Estos métodos, heredados de la clase Object, permiten la comunicación entre threads:

`wait()`: Hace que el thread actual libere el lock y espere hasta que otro thread llame `notify()` o `notifyAll()` en el mismo objeto. Solo puede ser llamado dentro de código sincronizado.

`notify()`: Despierta un thread que está esperando en el monitor del objeto. La selección del thread es arbitraria.

`notifyAll()`: Despierta todos los threads que están esperando en el monitor del objeto.
