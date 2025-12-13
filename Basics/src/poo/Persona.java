package poo;

// ========================================
// 1. CLASES Y OBJETOS - CONCEPTOS BÁSICOS
// ========================================

// Clase simple
class Persona {
    // Atributos (variables de instancia)
    String nombre;
    int edad;
    String email;

    // Constructor por defecto
    public Persona() {
        this.nombre = "Desconocido";
        this.edad = 0;
        this.email = "";
    }

    // Constructor con parámetros
    public Persona(String nombre, int edad, String email) {
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
    }

    // Constructor sobrecargado
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.email = "no-disponible@ejemplo.com";
    }

    // Métodos (comportamiento)
    public void saludar() {
        System.out.println("Hola, soy " + nombre);
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre + ", Edad: " + edad + ", Email: " + email);
    }

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }
}