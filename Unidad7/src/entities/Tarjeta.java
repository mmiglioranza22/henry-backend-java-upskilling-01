package entities;

public class Tarjeta {
    private int id;
    private int numero;
    private String titular;

    public Tarjeta(int id) {
        this.id = id;
    }

    public Tarjeta(int id, int numero, String titular) {
        this.id = id;
        this.numero = numero;
        this.titular = titular;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }
}
