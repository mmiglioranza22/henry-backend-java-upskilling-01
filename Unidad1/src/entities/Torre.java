package entities;

public class Torre extends Pieza {
    public Torre() {
    }

    public Torre(String tipo, char color, int valor, String[] posición, Jugador jugador) {
        super(tipo, color, valor, posición, jugador);
    }

    @Override
    public void informacion() {
        System.out.println(this.getTipo() + ": se mueve horizontal y verticalmente sin límites y captura piezas de la misma forma.");
        super.valor();
    }
}
