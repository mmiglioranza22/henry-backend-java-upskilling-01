package entities;

public class Alfil extends Pieza {
    public Alfil() {
    }

    public Alfil(String tipo, char color, int valor, String[] posición, Jugador jugador) {
        super(tipo, color, valor, posición, jugador);
    }

    @Override
    public void informacion() {
        System.out.println(this.getTipo() + ": se mueve en diagonal sin límites y captura piezas de la misma forma.");
        super.valor();
    }
}
