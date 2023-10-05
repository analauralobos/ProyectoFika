package com.mycompany.proyectofika;

import lombok.Data;

@Data
public class Producto {
    private int id;
    private String nombre;
    private String categoria;
    private double precio;

    public Producto(int id, String nombre, String categoria, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                ", precio=" + precio +
                '}';
    }

    int getId() {
        return id; //To change body of generated methods, choose Tools | Templates.
    }
}
