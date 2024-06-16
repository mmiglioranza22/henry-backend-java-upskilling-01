package com.pispring.PISpring.entities;

import com.pispring.PISpring.entities.interfaces.Filtrable;

import java.util.Date;

public class Gasto extends Operacion {
    private int categoriaId;
    private int id;
    private boolean saldado;

    public Gasto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public boolean isSaldado() {
        return saldado;
    }

    public void setSaldado(boolean saldado) {
        this.saldado = saldado;
    }

    @Override
    public double obtenerMonto() {
        return 0;
    }

    @Override
    public String obtenerCategoria() {
        return "";
    }

    @Override
    public Date obtenerFecha() {
        return null;
    }

    @Override
    public int compareTo(Operacion o) {
        return 0;
    }

}
