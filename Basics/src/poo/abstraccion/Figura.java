package poo.abstraccion;

// ========================================
// 5. ABSTRACCIÓN - CLASES ABSTRACTAS
// ========================================

public abstract class Figura {
    protected String color;

    public Figura(String color) {
        this.color = color;
    }

    // Método abstracto (sin implementación)
    public abstract double calcularArea();
    public abstract double calcularPerimetro();

    // Método concreto
    public void mostrarColor() {
        System.out.println("Color: " + color);
    }
}

