package anotaciones;

// ============================================
// -- ANOTACIONES PREDEFINIDAS --
// ============================================

public class AnotacionesPredefinidas {

    // @Override: Indica que sobrescribe un metodo de la superclase
    @Override
    public String toString() {
        return "Ejemplo de anotaciones";
    }

    // @Deprecated: Marca código obsoleto
    @Deprecated
    public void metodoAntiguo() {
        System.out.println("Este método está obsoleto");
    }

    // @SuppressWarnings: Suprime advertencias específicas
    @SuppressWarnings("unchecked")
    public void metodoConAdvertencias() {
        // Código que generaría advertencias
    }

}
