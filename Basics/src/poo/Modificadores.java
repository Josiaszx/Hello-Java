package poo;

// ========================================
// 7. MODIFICADORES Y PALABRAS CLAVE
// ========================================

public class Modificadores {

    // Variables de clase (static)
    public static int contador = 0;
    public static final double PI = 3.14159; // Constante

    // Variables de instancia
    private String nombre;
    protected int id;
    public String descripcion;

    // Constructor
    public Modificadores(String nombre) {
        this.nombre = nombre;
        this.id = ++contador;
    }

    // Método static
    public static void mostrarContador() {
        System.out.println("Total de objetos creados: " + contador);
    }

    // Método final (no puede ser sobrescrito)
    public final void metodoInmutable() {
        System.out.println("Este método no puede ser sobrescrito");
    }
}

