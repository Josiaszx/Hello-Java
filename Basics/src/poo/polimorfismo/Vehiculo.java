package poo.polimorfismo;

// ========================================
// 4. POLIMORFISMO - CLASE PADRE
// ========================================

public class Vehiculo {
    protected String marca;
    protected String modelo;

    public Vehiculo(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public void acelerar() {
        System.out.println("El vehículo está acelerando");
    }

    public void frenar() {
        System.out.println("El vehículo está frenando");
    }
}
