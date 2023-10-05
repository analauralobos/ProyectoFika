package com.mycompany.proyectofika;

import spark.Request;
import spark.Response;
import spark.Route;

import java.util.List;

public class MenuController {
    private MenuDAO menuDAO;

    public MenuController(MenuDAO menuDAO) {
        this.menuDAO = menuDAO;
    }

    public Route mostrarMenus = (Request request, Response response) -> {
        List<Menu> menus = menuDAO.obtenerTodosLosMenus();
        // Renderizar una vista o devolver los menús como JSON, según tus necesidades
        return "Lista de Menús: " + menus.toString();
    };

    // Agregar más métodos para crear, actualizar y eliminar menús según tus necesidades
}

