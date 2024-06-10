package entities;

public class Reina extends Pieza {
    public Reina() {
    }

    public Reina(String tipo, char color, int valor, String[] posición, Jugador jugador) {
        super(tipo, color, valor, posición, jugador);
    }

    @Override
    public void informacion() {
        System.out.println(this.getTipo() + ": se mueve en diagonales, horizontal y verticalmente sin límites y captura piezas de la misma forma.\nEs la pieza más fuerte.");
        super.valor();
    }

}
