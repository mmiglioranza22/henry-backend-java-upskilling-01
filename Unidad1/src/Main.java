import entities.*;

public class Main {
    public static void main(String[] args) {
        Jugador jugador1 = new Jugador();
        Pieza rey = new Rey("Rey", 'B', 0, new String[]{"E", "1"}, jugador1);
        Pieza reina = new Reina("Reina", 'B', 9, new String[]{"D", "1"}, jugador1);
        Pieza torre = new Torre("Torre", 'B', 5, new String[]{"A", "1"}, jugador1);
        Pieza alfil = new Alfil("Alfil", 'B', 3, new String[]{"C", "1"}, jugador1);
        Pieza caballo = new Caballo("Caballo", 'B', 3, new String[]{"B", "1"}, jugador1);
        Pieza peon = new Peon("Peón", 'B', 1, new String[]{"E", "2"}, jugador1);


        rey.informacion();
        reina.informacion();
        torre.informacion();
        alfil.informacion();
        caballo.informacion();
        peon.informacion();
    }
}