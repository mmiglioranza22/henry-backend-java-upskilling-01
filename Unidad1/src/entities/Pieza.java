package entities;

public class Pieza {
    private String tipo;
    private char color;
    private int valor;
    private String[] posición;
    public Jugador jugador;

    public Pieza() {
    }

    public Pieza(String tipo, char color, int valor, String[] posición, Jugador jugador) {
        this.tipo = tipo;
        this.color = color;
        this.valor = valor;
        this.posición = posición;
        this.jugador = jugador;
    }

    public void valor() {
        System.out.println("El valor de esta pieza es de " + this.getValor() + " puntos\n");
    }

    public void informacion() {
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setColor(char color) {
        this.color = color;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public char getColor() {
        return color;
    }

    public int getValor() {
        return valor;
    }

    public String[] getPosición() {
        return posición;
    }

    public Jugador getJugador() {
        return jugador;
    }
}
