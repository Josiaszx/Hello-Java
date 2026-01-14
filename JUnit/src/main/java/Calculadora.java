public class Calculadora {

    public int sumar(int a, int b) {
        return a + b;
    }

    public double dividir(double a, double b) {
        if (b == 0) throw new ArithmeticException("No se puede dividir entre cero");
        return a / b;
    }

    public boolean esPar(int numero) {
        return numero % 2 == 0;
    }
}
