package com.pispring.PISpring.entities;

import com.pispring.PISpring.entities.interfaces.ObtenerInformacion;

import java.util.Date;

public abstract class Operacion implements ObtenerInformacion, Comparable<Operacion> {
    private String categoria;
    private double monto;
    private Date fecha;
    private boolean esRecurrente;

    public Operacion() {
    }

    public Operacion(String categoria, double monto, Date fecha, boolean esRecurrente) {
        this.categoria = categoria;
        this.monto = monto;
        this.fecha = fecha;
        this.esRecurrente = esRecurrente;
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

    public void setEsRecurrente(boolean esRecurrente) {
        this.esRecurrente = esRecurrente;
    }

    @Override
    public String toString() {
        return "Operacion{" +
                "categoria='" + categoria + '\'' +
                ", monto=" + monto +
                ", fecha=" + fecha +
                ", esRecurrente=" + esRecurrente +
                '}';
    }
}