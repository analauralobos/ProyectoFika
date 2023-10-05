package com.mycompany.proyectofika;

import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    private List<Producto> productos;

    public ProductoDAO() {
        // Inicializa una lista de productos en memoria
        this.productos = new ArrayList<>();
        // Agrega algunos productos de prueba
        agregarProductosDePrueba();
    }

    // Método para agregar un nuevo producto
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    // Método para obtener todos los productos
    public List<Producto> obtenerTodosLosProductos() {
        return productos;
    }

    // Método para obtener un producto por su ID
    public Producto obtenerProductoPorId(int id) {
        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }
        return null; // Retorna null si el producto no se encuentra
    }

    // Método para agregar productos de prueba
    private void agregarProductosDePrueba() {
        agregarProducto(new Producto(1, "Café Espresso", "Café", 2.5));
        agregarProducto(new Producto(2, "Torta de Chocolate", "Torta", 3.0));
        agregarProducto(new Producto(3, "Sándwich de Jamón y Queso", "Sándwich", 5.5));
        agregarProducto(new Producto(4, "Batido de Fresa", "Batido", 4.0));
        agregarProducto(new Producto(5, "Jugo de Naranja", "Jugo", 2.0));
    }
}
