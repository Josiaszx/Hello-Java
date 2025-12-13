package poo.interfaces;

// Clase que implementa una interfaz
public class Avion implements Volador {
    private String modelo;

    public Avion(String modelo) {
        this.modelo = modelo;
    }

    // definicion de metodos implementados

    @Override
    public void despegar() {
        System.out.println(modelo + " está despegando");
    }

    @Override
    public void aterrizar() {
        System.out.println(modelo + " está aterrizando");
    }

    @Override
    public void volar() {
        System.out.println(modelo + " está volando a " + ALTURA_MAXIMA + " metros");
    }
}

