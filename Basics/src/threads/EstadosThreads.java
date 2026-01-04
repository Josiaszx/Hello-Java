package threads;

public class EstadosThreads {
    public static void main(String[] args) throws InterruptedException {
        Thread hilo = new Thread(() -> {
            try {
                Thread.sleep(2000);
                synchronized(EstadosThreads.class) {
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("Estado inicial: " + hilo.getState()); // NEW

        hilo.start();
        System.out.println("Después de start(): " + hilo.getState()); // RUNNABLE

        Thread.sleep(100);
        System.out.println("Durante sleep(): " + hilo.getState()); // TIMED_WAITING

        Thread.sleep(2500);
        System.out.println("Después de finalizar: " + hilo.getState()); // TERMINATED
    }
}
