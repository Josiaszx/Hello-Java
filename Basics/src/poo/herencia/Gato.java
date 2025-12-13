package poo.herencia;

// ========================================
// HERENCIA - CLASE HIJA
// ========================================

public class Gato extends Animal {

    private boolean esCallejero;

    public Gato(String nombre, int edad, boolean esCallejero) {
        super(nombre, edad); // llama al constructor del padre
        this.esCallejero = esCallejero;
    }

    public void maullar() {
        System.out.println(nombre + " dice: ¡Miau miau!");
    }

    // metodo heredado de la clase padre
    @Override
    public void hacerSonido() {
        System.out.println(nombre + " maúlla: ¡Miau!");
    }

}

