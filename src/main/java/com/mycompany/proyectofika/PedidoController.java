package com.mycompany.proyectofika;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.List;

public class PedidoController {
    private PedidoDAO pedidoDAO;

    public PedidoController(PedidoDAO pedidoDAO) {
        this.pedidoDAO = pedidoDAO;
    }

    public Route mostrarPedidos = (Request request, Response response) -> {
        List<Pedido> pedidos = pedidoDAO.obtenerTodosLosPedidos();
        // Renderizar una vista o devolver los pedidos como JSON, según tus necesidades
        return "Lista de Pedidos: " + pedidos.toString();
    };

    // Agregar más métodos para crear, actualizar y eliminar pedidos según tus necesidades
}
