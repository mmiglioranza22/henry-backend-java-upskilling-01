package com.pispring.PISpring.dto;

public class CategoriaDTO {
    private int id;
    private String categoria;

    public CategoriaDTO() {
    }

    public CategoriaDTO(String categoria) {
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "CategoriaDTO{" +
                "id=" + id +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
