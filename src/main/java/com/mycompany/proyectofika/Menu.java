package com.mycompany.proyectofika;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class Menu {
    private int id;
    private String nombre;
    private List<Producto> productos;

    public Menu(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.productos = new ArrayList<>();
    }

    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    int getId() {
        return id; //To change body of generated methods, choose Tools | Templates.
    }
}
