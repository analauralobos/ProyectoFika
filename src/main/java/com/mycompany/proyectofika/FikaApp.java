package com.mycompany.proyectofika;

import spark.ModelAndView;
import spark.Spark;
import spark.template.velocity.VelocityTemplateEngine;

public class FikaApp {
    public static void main(String[] args) {
        // Configuración de tu motor de plantillas Velocity
        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();

        // Otras configuraciones de Spark y rutas aquí

        // Ruta para la página de inicio del administrador
        Spark.get("/admin", (req, res) -> {
            // Renderizar la plantilla HTML del panel de control utilizando tu motor de plantillas Velocity
            return velocityTemplateEngine.render(new ModelAndView(null, "templates/paneldecontrol.vm"));
        });
    }
}
