package entities;

public class Caballo extends Pieza {
    public Caballo() {
    }

    public Caballo(String tipo, char color, int valor, String[] posición, Jugador jugador) {
        super(tipo, color, valor, posición, jugador);
    }

    @Override
    public void informacion() {
        System.out.println(this.getTipo() + ": se mueve en cualquier en forma de L (horizontal o verticalmente dos casilleros, y luego 1 casillero en forma opuesta al primer movimiento) y captura piezas de la misma forma.");
        super.valor();
    }
}

