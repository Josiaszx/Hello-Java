package poo.herencia;

// ========================================
// HERENCIA - CLASE PADRE
// ========================================

// Clase base (superclase/padre)
public class Animal {
    protected String nombre;
    protected int edad;

    public Animal(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public void comer() {
        System.out.println(nombre + " está comiendo");
    }

    public void dormir() {
        System.out.println(nombre + " está durmiendo");
    }

    public void hacerSonido() {
        System.out.println("El animal hace un sonido");
    }
}

