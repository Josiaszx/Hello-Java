package poo.interfaces;

// Clase que implementa múltiples interfaces
public class Pato implements Volador, Nadador {

    private String nombre;

    public Pato(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void despegar() {
        System.out.println(nombre + " aletea y despega");
    }

    @Override
    public void aterrizar() {
        System.out.println(nombre + " aterriza en el agua");
    }

    @Override
    public void volar() {
        System.out.println(nombre + " vuela bajo");
    }

    @Override
    public void nadar() {
        System.out.println(nombre + " nada en el estanque");
    }

    @Override
    public void sumergirse() {
        System.out.println(nombre + " se sumerge brevemente");
    }
}

