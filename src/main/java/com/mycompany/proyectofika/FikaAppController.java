package com.mycompany.proyectofika;

import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.Spark;
import spark.template.velocity.VelocityTemplateEngine;

public class FikaAppController {

    private PedidoController pedidoController;
    private MenuController menuController;
    private VelocityTemplateEngine velocityTemplateEngine;

    public FikaAppController(PedidoController pedidoController, MenuController menuController, VelocityTemplateEngine velocityTemplateEngine) {
        this.pedidoController = pedidoController;
        this.menuController = menuController;
        this.velocityTemplateEngine = velocityTemplateEngine;
    }

    public void init() {
        // Configurar rutas y controladores
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
        Spark.get("/menu", (req, res) -> {
            return menuController.mostrarMenus.handle(req, res);
        });
 
        Spark.get("/crear-menu", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            return velocityTemplateEngine.render(new ModelAndView(model, "templates/crear-menu.vm"));
        });

        Spark.post("/crear-menu", (req, res) -> {
            return menuController.crearMenu.handle(req, res);
        });
        
        Spark.get("/menu-creado", (req, res) -> {
            Map<String, Object> model = new HashMap<>();

            return velocityTemplateEngine.render(new ModelAndView(model, "templates/menu-creado.vm"));
        });
    }
}
