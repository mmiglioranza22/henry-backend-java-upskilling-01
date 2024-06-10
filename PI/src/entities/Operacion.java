package entities;

import entities.interfaces.ObtenerInformacion;

import java.util.Date;

public abstract class Operacion implements ObtenerInformacion, Comparable<Operacion> {
    private String categoria;
    private double monto;
    private Date fecha;
    private boolean esRecurrente;
    private Usuario usuario;

    public Operacion() {
    }

    public Operacion(String categoria, double monto, Date fecha, boolean esRecurrente) {
        this.categoria = categoria;
        this.monto = monto;
        this.fecha = fecha;
        this.esRecurrente = esRecurrente;
    }

    public Operacion(String categoria, double monto, Date fecha, boolean esRecurrente, Usuario usuario) {
        this.categoria = categoria;
        this.monto = monto;
        this.fecha = fecha;
        this.esRecurrente = esRecurrente;
        this.usuario = usuario;

        Categoria.agregarNuevaCategoria(categoria);
    }


    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getMonto() {
        return monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public boolean isEsRecurrente() {
        return esRecurrente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setEsRecurrente(boolean esRecurrente) {
        this.esRecurrente = esRecurrente;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
