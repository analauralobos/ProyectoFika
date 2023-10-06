package com.mycompany.proyectofika;

import java.util.HashMap;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.List;
import java.util.Map;
import spark.ModelAndView;

import spark.template.velocity.VelocityTemplateEngine;

public class PedidoController {

    private PedidoDAO pedidoDAO;
    VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();

    public PedidoController(PedidoDAO pedidoDAO) {
        this.pedidoDAO = pedidoDAO;
    }

   public Route mostrarPedidos = (Request request, Response response) -> {
    List<Pedido> pedidos = pedidoDAO.obtenerTodosLosPedidos();

    Map<String, Object> model = new HashMap<>();
    model.put("pedidos", pedidos);

    return velocityTemplateEngine.render(new ModelAndView(model, "templates/pedidos.vm"));
};

}
