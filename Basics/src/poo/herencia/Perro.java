package poo.herencia;

// ========================================
// HERENCIA - CLASE HIJA
// ========================================

public class Perro extends Animal {
    private String raza;

    public Perro(String nombre, int edad, String raza) {
        super(nombre, edad); // Llama al constructor del padre
        this.raza = raza;
    }

    // Método específico de Perro
    public void ladrar() {
        System.out.println(nombre + " dice: ¡Guau guau!");
    }

    // Sobrescritura de método (Override)
    @Override
    public void hacerSonido() {
        System.out.println(nombre + " ladra: ¡Guau!");
    }

    public void mostrarInfo() {
        System.out.println("Perro: " + nombre + ", Edad: " + edad + ", Raza: " + raza);
    }
}
