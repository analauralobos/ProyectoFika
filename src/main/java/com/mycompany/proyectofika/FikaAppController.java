package com.mycompany.proyectofika;

import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.Spark;
import spark.template.velocity.VelocityTemplateEngine;

public class FikaAppController {
    private PedidoController pedidoController;
    private VelocityTemplateEngine velocityTemplateEngine;

    public FikaAppController(PedidoController pedidoController, VelocityTemplateEngine velocityTemplateEngine) {
       this.pedidoController = pedidoController;
       this.velocityTemplateEngine = velocityTemplateEngine;
    }
    
    public void init() {
        // Configurar rutas y controladores aquí
        Spark.get("/", (req, res) -> {
            // Crear un modelo como un mapa (java.util.Map)
            Map<String, Object> model = new HashMap<>();
            // Agregar datos al modelo
            model.put("mensaje", "¡Bienvenido a Fika Café!");

            // Renderizar la plantilla HTML home.vm utilizando tu motor de plantillas Velocity
            return velocityTemplateEngine.render(new ModelAndView(model, "templates/home.vm"));
        });

        Spark.get("/pedidos", (req, res) -> {
            return pedidoController.mostrarPedidos.handle(req, res);
        });

        // Agregar más rutas y controladores según sea necesario
    }
}
