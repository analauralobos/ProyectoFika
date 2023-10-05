package com.mycompany.proyectofika;

import spark.Request;
import spark.Response;
import spark.Route;

import java.util.List;

public class ProductoController {
    private ProductoDAO productoDAO;

    public ProductoController(ProductoDAO productoDAO) {
        this.productoDAO = productoDAO;
    }

    public Route mostrarProductos = (Request request, Response response) -> {
        List<Producto> productos = productoDAO.obtenerTodosLosProductos();
        // Renderizar una vista o devolver los productos como JSON, según tus necesidades
        return "Lista de Productos: " + productos.toString();
    };

    // Agregar más métodos para crear, actualizar y eliminar productos según tus necesidades
}
