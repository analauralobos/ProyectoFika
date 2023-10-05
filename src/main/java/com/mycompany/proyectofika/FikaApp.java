package com.mycompany.proyectofika;
import static spark.Spark.*;

public class FikaApp {
    public static void main(String[] args) {
        // Configuración del puerto en el que se ejecutará la aplicación Spark
        port(4567);

        // Crear instancias de controladores y servicios
        MenuDAO menuDAO = new MenuDAO(); // Reemplaza con tu implementación real
        PedidoDAO pedidoDAO = new PedidoDAO(); // Reemplaza con tu implementación real
        MenuService menuService = new MenuService(menuDAO);
        PedidoService pedidoService = new PedidoService(pedidoDAO);
        MenuController menuController = new MenuController(menuService);
        PedidoController pedidoController = new PedidoController(pedidoService);

        // Configurar rutas y controladores
        menuController.registrarRutasCrearMenu();
        pedidoController.registrarRutasConsultarPedidos();

        // Otros ajustes y configuraciones

        // Para detener la aplicación, puedes usar Ctrl+C en la línea de comandos
        awaitInitialization();
        System.out.println("La aplicación Spark Java se está ejecutando en el puerto 4567.");
    }
}
