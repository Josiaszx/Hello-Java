import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    Calculadora calculadora = new Calculadora();

    @Test // indicar que el siguiente es un test
    void sumar1Mas2Igual3() {
        // guardamos resultado obtenido
        int resultado = calculadora.sumar(1, 2);

        // comparamos resultado con el esperado
        assertEquals(3, resultado);
        // el metodo assertEquals() nos permite comparar dos valores.
        // Si ambos valores son iguales, se pasa un test, de lo contrario,
        // el test falla y lanza un error.
    }

    @Test
    @DisplayName("Dividir entre 0 lanza error") // con @DisplayName() podemos definir el nombre del test (por defecto es el nombre del metodo)
    void testDivision() {
        // si queremos verificar si un metodo lanza un error segun alguna condicion especifica:
        assertThrows(ArithmeticException.class, () -> calculadora.dividir(1, 0));
        // assertThrows() recibe como parametro el tipo de error esperado y el bloque de codigo que genera el error
    }

    @Test
    @DisplayName("2 debe ser par y 3 no")
    void testPar() {
        // con assertTrue() podemos verificar si un valor es verdadero para pasar el test
        assertTrue(calculadora.esPar(2));
        // tambine podemos usar assertFalse() para verificar si un valor es falso
        assertFalse(calculadora.esPar(3));
    }
}