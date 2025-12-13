package poo;

import poo.abstraccion.Circulo;
import poo.abstraccion.Figura;
import poo.abstraccion.Rectangulo;
import poo.encapsulacion.CuentaBancaria;
import poo.herencia.Animal;
import poo.herencia.Gato;
import poo.herencia.Perro;
import poo.interfaces.Avion;
import poo.interfaces.Pato;
import poo.polimorfismo.Auto;
import poo.polimorfismo.Moto;
import poo.polimorfismo.Vehiculo;

// ========================================
// CLASE PRINCIPAL CON EJEMPLOS
// ========================================

public class POOCompleto {
    public static void main(String[] args) {

        System.out.println("=== 1. CLASES Y OBJETOS ===");
        Persona p1 = new Persona("Juan", 25, "juan@email.com");
        Persona p2 = new Persona("María", 17);
        p1.saludar();
        p1.mostrarInfo();
        System.out.println("¿Es mayor de edad?: " + p1.esMayorDeEdad());

        System.out.println("\n=== 2. ENCAPSULACIÓN ===");
        CuentaBancaria cuenta = new CuentaBancaria("123456", "Ana García", 1000);
        System.out.println("Saldo inicial: " + cuenta.getSaldo());
        cuenta.depositar(500);
        cuenta.retirar(300);
        cuenta.retirar(2000); // Intento fallido

        System.out.println("\n=== 3. HERENCIA ===");
        Perro perro = new Perro("Max", 3, "Labrador");
        perro.mostrarInfo();
        perro.comer();
        perro.ladrar();
        perro.hacerSonido();

        Gato gato = new Gato("Michi", 2, false);
        gato.maullar();
        gato.hacerSonido();

        System.out.println("\n=== 4. POLIMORFISMO ===");
        // Referencia del padre, objeto del hijo
        Vehiculo v1 = new Auto("Toyota", "Corolla", 4);
        Vehiculo v2 = new Moto("Honda", "CBR", false);

        v1.acelerar(); // Llama al método de Coche
        v2.acelerar(); // Llama al método de Motocicleta

        // Array polimórfico
        Vehiculo[] vehiculos = {v1, v2};
        for (Vehiculo v : vehiculos) {
            v.acelerar();
        }

        System.out.println("\n=== 5. CLASES ABSTRACTAS ===");
        Figura rect = new Rectangulo("Rojo", 5, 3);
        Figura circ = new Circulo("Azul", 4);

        rect.mostrarColor();
        System.out.println("Área rectángulo: " + rect.calcularArea());
        System.out.println("Perímetro rectángulo: " + rect.calcularPerimetro());

        circ.mostrarColor();
        System.out.println("Área círculo: " + circ.calcularArea());
        System.out.println("Perímetro círculo: " + circ.calcularPerimetro());

        System.out.println("\n=== 6. INTERFACES ===");
        Avion avion = new Avion("Boeing 747");
        avion.despegar();
        avion.volar();
        avion.aterrizar();

        Pato pato = new Pato("Donald");
        pato.nadar();
        pato.despegar();
        pato.volar();
        pato.aterrizar();
        pato.sumergirse();

        System.out.println("\n=== 7. MODIFICADORES STATIC ===");
        Modificadores obj1 = new Modificadores("Objeto 1");
        Modificadores obj2 = new Modificadores("Objeto 2");
        Modificadores.mostrarContador();
        System.out.println("PI = " + Modificadores.PI);


        System.out.println("\n=== 8. CLASES INTERNAS ===");
        ClasesAnidadas externa = new ClasesAnidadas();
        ClasesAnidadas.ClaseInterna interna = externa.new ClaseInterna();
        interna.mostrarMensaje();

        ClasesAnidadas.ClaseInternaEstatica estatica = new ClasesAnidadas.ClaseInternaEstatica();
        estatica.saludar();

        System.out.println("\n=== INSTANCEOF ===");
        Animal animal = new Perro("Rex", 5, "Pastor Alemán");
        System.out.println("animal es Animal: " + (animal instanceof Animal));
        System.out.println("animal es Perro: " + (animal instanceof Perro));
        System.out.println("animal es Gato: " + (animal instanceof Gato));
    }
}

