package poo;

// ========================================
// 8. CLASE INTERNA Y ANIDADA
// ========================================

class ClasesAnidadas {
    private String mensaje = "Mensaje desde clase externa";

    // Clase interna (inner class)
    class ClaseInterna {
        public void mostrarMensaje() {
            System.out.println(mensaje); // Puede acceder a miembros privados
        }
    }

    // Clase interna estática
    static class ClaseInternaEstatica {
        public void saludar() {
            System.out.println("Hola desde clase interna estática");
        }
    }
}
