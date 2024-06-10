package entities;

public class Jugador {
    private String nombre;
    private int tiempoRestante;
    private Pieza[] piezasCapturadas;
    private Pieza[] piezasRestantes;

    public Jugador() {
    }

    public Jugador(String nombre, int tiempoRestante, Pieza[] piezasCapturadas, Pieza[] piezasRestantes) {
        this.nombre = nombre;
        this.tiempoRestante = tiempoRestante;
        this.piezasCapturadas = piezasCapturadas;
        this.piezasRestantes = piezasRestantes;
    }

    public void ofrecerTablas() {
    }

    ;

    public void rendirse() {
    }

    ;

    public void moverPieza(Pieza pieza, String[] posición) {
    }

    ;

    public void capturarPieza(Pieza pieza, String[] posición) {
    }

    ;

    public void enroque(Pieza torre) {
    }

    ;

    public void darJaque(Pieza pieza) {
    }

    ;

}

