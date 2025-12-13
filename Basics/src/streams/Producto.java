package streams;

public class Producto {
    private String nombre;
    private double precio;
    private String categoria;
    private boolean enStock;

    public Producto(String nombre, double precio, String categoria, boolean enStock) {
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.enStock = enStock;
    }

    public String getNombre() { return nombre; }
    public double getPrecio() { return precio; }
    public String getCategoria() { return categoria; }
    public boolean isEnStock() { return enStock; }

    @Override
    public String toString() {
        return nombre + " - $" + precio;
    }
}

