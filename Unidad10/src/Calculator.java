public class Calculator {

    public static int add(int a, int b )  {
        return a + b;
    }

    public static int substract(int a, int b) {
        return a - b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static int divide(int a, int b) throws BadInputException {
        try {

        return a / b;
        } catch (ArithmeticException e) {
            throw new BadInputException("You can't divide by zero!!");
        }
    }
}
