package poo.interfaces;
// ========================================
// 6. INTERFACES
// ========================================

public interface Volador {

    // Métodos abstractos (implícitamente public abstract)
    void despegar();
    void aterrizar();
    void volar();

    // Constantes (implícitamente public static final)
    int ALTURA_MAXIMA = 10000;
}

