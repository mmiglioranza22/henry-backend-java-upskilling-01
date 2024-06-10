package entities;

public class Peon extends Pieza {
    public Peon() {
    }

    public Peon(String tipo, char color, int valor, String[] posición, Jugador jugador) {
        super(tipo, color, valor, posición, jugador);
    }

    @Override
    public void informacion() {
        System.out.println(this.getTipo() + ": se mueve en siempre en forma vertical hacie adelante de a 1 casillero. Su primer movimiento puede ser de 2 casilleros.\nEs la única pieza que captura en diagonal hacia adelante, moviéndose hacia donde se encuentra la pieza a capturar ó, si es otro peón que se movió 2 casilleros previamiente, puede capturarlo 'en passant' de igual modo.");
        super.valor();
    }

    public void coronar(Pieza pieza) {
        this.setTipo(pieza.getTipo());
        this.setColor(pieza.getColor());
        this.setValor(pieza.getValor());
    }
}
