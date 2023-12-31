package com.mycompany.proyectofika;

import spark.template.velocity.VelocityTemplateEngine;

public class FikaApp {

    public static void main(String[] args) {
        // Crear una instancia de VelocityTemplateEngine
        VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();
        // Crear una instancia de PedidoDAO
        PedidoDAO pedidoDAO = new PedidoDAO();
        // Crear una instancia de MenuDAO
        MenuDAO menuDAO = new MenuDAO();
        // Crear una instancia de PedidoController y pasar el PedidoDAO
        PedidoController pedidoController = new PedidoController(pedidoDAO);
        // Crear una instancia de MenuController y pasar el PedidoDAO
        MenuController menuController = new MenuController(menuDAO);
        
        // Crear una instancia de FikaAppController 
        FikaAppController fikaAppController = new FikaAppController(pedidoController, menuController, velocityTemplateEngine);
        // Llamar al método init() en la instancia de FikaAppController
        fikaAppController.init();
    }
}
