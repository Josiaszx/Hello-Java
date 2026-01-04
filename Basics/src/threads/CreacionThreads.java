package threads;

// FORMAS DE CREAR THREADS

// 1. extends Thread
public class CreacionThreads extends Thread{

    // dentro del metodo run escribimos el codigo a ejecutar dentro del hilo
    @Override
    public void run() {
        System.out.println("Mensaje desde un nuevo hilo");
    }
}

// 2. implements Runnable
class HiloRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("Mensaje desde un nuevo hilo implementando Runnable");
    }
}

// 3. Lambda
class HiloLambda {
    public void ejecutarNuevoHilo() {
        Thread thread1 = new Thread(() -> {
            System.out.println("Mensaje desde un nuevo hilo usando Lambda");
        });

        // para iniciar el hilo llamamos al metodo start
        thread1.start();
    }
}
