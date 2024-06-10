package entities;

import entities.interfaces.Filtrable;

import java.util.Date;

public class Gasto extends Operacion {
    private static int _id = 1;
    private int id;

    private boolean saldado;

    private Date fechaSaldado;

    public Gasto() {
    }

    public Gasto(boolean generarId) {
        if (generarId) {
            this.id = Gasto._id;
            Gasto._id++;
        }
    }

    public Gasto(int categoriaId, String categoria, double monto, Date fecha, boolean esRecurrente) {
        super(categoria, monto, fecha, esRecurrente);
        this.id = categoriaId;
    }

    public Gasto(String categoria, double monto, Date fecha, boolean esRecurrente, Usuario usuario) {
        super(categoria.toLowerCase().strip(), monto, fecha, esRecurrente, usuario);
        this.id = Gasto._id;
        Gasto._id++;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public double obtenerMonto() {
        return this.getMonto();
    }

    @Override
    public String obtenerCategoria() {
        return this.getCategoria();
    }

    @Override
    public Date obtenerFecha() {
        return this.getFecha();
    }

    public int compareTo(Operacion gasto) {
        return (int) (this.obtenerMonto() - gasto.obtenerMonto());
    }

    public boolean gastoSaldado() {
        Filtrable saldado = gasto -> gasto.getMonto() == 0;
        return saldado.cumpleFiltro(this);
    }

    @Override
    public String toString() {
        return "Gasto Nº" + this.getId() +
                ", categoria = " + this.getCategoria() +
                ", monto = " + this.getMonto() +
                ", fecha = " + this.getFecha();
    }
}