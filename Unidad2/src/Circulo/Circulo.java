package Circulo;

public class Circulo {
    public static final double PI = 3.14159;

    public static double calcularArea(int r) {
        return PI * Math.pow(r, 2);
    }

    public static double calcularCircunferencia(int r) {
        return 2 * PI * r;
    }

}
