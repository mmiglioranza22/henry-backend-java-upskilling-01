package com.pispring.PISpring.dto;

import java.util.Date;

public class GastoDTO {
    public int id;
    public boolean saldado;
    public Date fechaSaldado;
    public int categoriaId;
    public String categoria;
    public double monto;
    public Date fecha;
    public boolean esRecurrente;

    public GastoDTO() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isSaldado() {
        return saldado;
    }

    public void setSaldado(boolean saldado) {
        this.saldado = saldado;
    }

    public Date getFechaSaldado() {
        return fechaSaldado;
    }

    public void setFechaSaldado(Date fechaSaldado) {
        this.fechaSaldado = fechaSaldado;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isEsRecurrente() {
        return esRecurrente;
    }

    public void setEsRecurrente(boolean esRecurrente) {
        this.esRecurrente = esRecurrente;
    }

    @Override
    public String toString() {
        return "GastoDTO{" +
                "id=" + id +
                ", saldado=" + saldado +
                ", fechaSaldado=" + fechaSaldado +
                ", categoriaId=" + categoriaId +
                ", categoria='" + categoria + '\'' +
                ", monto=" + monto +
                ", fecha=" + fecha +
                ", esRecurrente=" + esRecurrente +
                '}';
    }
}
