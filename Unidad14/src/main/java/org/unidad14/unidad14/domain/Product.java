package org.unidad14.unidad14.domain;

import org.springframework.stereotype.Component;

@Component
public class Product {
    private int id;
    private String nombre;
    private double precio;

    private static int idCounter = 1;

    public Product() {
    }

    public Product(String nombre, double precio) {
        this.id = Product.idCounter;
        this.nombre = nombre;
        this.precio = precio;
        idCounter++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}
