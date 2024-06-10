package dao.dto;

import entities.Usuario;

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
    public Usuario usuario;

    public GastoDTO() {
    }

    public GastoDTO(String categoria, int categoriaId, double monto, Date fecha, boolean esRecurrente) {
        this.categoria = categoria;
        this.categoriaId = categoriaId;
        this.monto = monto;
        this.fecha = fecha;
        this.esRecurrente = esRecurrente;
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
        this.categoria = categoria;
    }

    public void setCategoria(String categoria) {
        this.categoriaId = categoriaId;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoriaId) {
        this.categoriaId = categoriaId;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "GastoDTO{" +
                "saldado=" + saldado +
                ", fechaSaldado=" + fechaSaldado +
                ", categoriaId=" + categoriaId +
                ", categoria='" + categoria + '\'' +
                ", monto=" + monto +
                ", fecha=" + fecha +
                ", esRecurrente=" + esRecurrente +
                ", usuario=" + usuario +
                '}';
    }
}

