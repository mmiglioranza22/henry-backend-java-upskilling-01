import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Calculator suite")
class CalculatorTest {

    @DisplayName("La calculadora debe tener un método `add(a, b)` que reciba dos números y devuelva la suma.")
    @Test
    public void testAddMethod() {
        int expected = 4;
        int result1 = Calculator.add(2,2);
        int result2 = Calculator.add(0,4);
        int result3 = Calculator.add(8,-4);

        int expected2 = 5;
        int result4 = Calculator.add(-10,15);

        Assertions.assertEquals(expected, result1);
        Assertions.assertEquals(expected, result2);
        Assertions.assertEquals(expected, result3);
        Assertions.assertEquals(expected2, result4);
    }

    @DisplayName("La calculadora debe tener un método `substract(a, b)` que reciba dos números y devuelva la resta.")
    @Test
    public void testSubstractMethod() {
        int expected = 4;
        int result1 = Calculator.substract(8,4);
        int result2 = Calculator.substract(10, 6);
        int result3 = Calculator.substract(6,2);

        int expected2 = 5;
        int result4 = Calculator.substract(-10,-15);

        Assertions.assertEquals(expected, result1);
        Assertions.assertEquals(expected, result2);
        Assertions.assertEquals(expected, result3);
        Assertions.assertEquals(expected2, result4);
    }

    @DisplayName("La calculadora debe tener un método `multiply(a, b)` que reciba dos números y devuelva la multiplicación.")
    @Test
    public void testMultiplyMethod() {
        int expected = 50;
        int result1 = Calculator.multiply(10,5);
        int result2 = Calculator.multiply(2, 25);
        int result3 = Calculator.multiply(-2,-25);

        int expected2 = 0;
        int result4 = Calculator.multiply(2, 0);

        Assertions.assertEquals(expected, result1);
        Assertions.assertEquals(expected, result2);
        Assertions.assertEquals(expected, result3);
        Assertions.assertEquals(expected2, result4);
    }

    @DisplayName("La calculadora debe tener un método `divide(a, b)` que reciba dos números y devuelva la división.")
    @Test
    public void testDivideMethod() {
        try {
        int expected = 2;
        int result1 = Calculator.divide(10,5);
        int result2 = Calculator.divide(100, 50);
        int result3 = Calculator.divide(-50,-25);

        int expected2 = 3;
        int result4 = Calculator.divide(6, 2);

        Assertions.assertEquals(expected, result1);
        Assertions.assertEquals(expected, result2);
        Assertions.assertEquals(expected, result3);
        Assertions.assertEquals(expected2, result4);

        } catch (BadInputException | ArithmeticException e) {

        }
    }

    @DisplayName("El metodo divide(a, b) arroja un error si se invoca con 0")
    @Test
    public void testDivideByZero() {
        Throwable exception = assertThrows(BadInputException.class, () -> Calculator.divide(5,0));
        assertEquals("You can't divide by zero!!", exception.getMessage());
    }

}