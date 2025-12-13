package poo.encapsulacion;

// ========================================
// 2. ENCAPSULACIÓN
// ========================================

public class CuentaBancaria {
    // Atributos privados (encapsulados)
    private String numeroCuenta;
    private double saldo;
    private String titular;

    // Constructor
    public CuentaBancaria(String numeroCuenta, String titular, double saldoInicial) {
        this.numeroCuenta = numeroCuenta;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    // Getters (accesores)
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTitular() {
        return titular;
    }

    // Setters (mutadores) con validación
    public void setTitular(String titular) {
        if (titular != null && !titular.isEmpty()) {
            this.titular = titular;
        } else {
            System.out.println("Nombre de titular inválido");
        }
    }

    // Métodos para operaciones controladas
    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("Depósito exitoso. Nuevo saldo: " + saldo);
        } else {
            System.out.println("La cantidad debe ser positiva");
        }
    }

    public boolean retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= saldo) {
            saldo -= cantidad;
            System.out.println("Retiro exitoso. Nuevo saldo: " + saldo);
            return true;
        } else {
            System.out.println("Fondos insuficientes o cantidad inválida");
            return false;
        }
    }
}
