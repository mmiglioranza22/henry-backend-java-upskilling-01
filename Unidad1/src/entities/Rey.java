package entities;

public class Rey extends Pieza {
    public Rey() {
    }

    public Rey(String tipo, char color, int valor, String[] posición, Jugador jugador) {
        super(tipo, color, valor, posición, jugador);
    }

    @Override
    public void informacion() {
        System.out.println(this.getTipo() + ": se mueve en cualquier dirección de a 1 casillero y captura piezas de la misma forma.\nEs la pieza más importante.");
        super.valor();
    }

    public void enroque(Pieza torre) {
//        enroque largo o enroque corto
    }
}
