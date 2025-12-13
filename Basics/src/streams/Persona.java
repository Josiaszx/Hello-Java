package streams;

public class Persona {
    private String nombre;
    private int edad;
    private String departamento;

    public Persona(String nombre, int edad, String departamento) {
        this.nombre = nombre;
        this.edad = edad;
        this.departamento = departamento;
    }

    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public String getDepartamento() { return departamento; }

    @Override
    public String toString() {
        return nombre + " (" + edad + ", " + departamento + ")";
    }
}

