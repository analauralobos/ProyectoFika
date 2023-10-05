package com.mycompany.proyectofika;

import java.util.HashMap;
import java.util.Map;
import spark.ModelAndView;
import spark.Spark;
import spark.template.velocity.VelocityTemplateEngine;

public class FikaAppController {
    public static void init() {
        // Configuración de tu motor de plantillas Velocity
        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();

        // Configurar rutas y controladores aquí
        Spark.get("/", (req, res) -> {
            // Crear un modelo como un mapa (java.util.Map)
            Map<String, Object> model = new HashMap<>();
            // Agregar datos al modelo
            model.put("mensaje", "¡Bienvenido a Fika Café!");

            // Renderizar la plantilla HTML home.vm utilizando tu motor de plantillas Velocity
            return velocityTemplateEngine.render(new ModelAndView(model, "templates/home.vm"));
        });

        // Agregar más rutas y controladores según sea necesario
    }
}
