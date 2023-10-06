package com.mycompany.proyectofika;

import java.util.HashMap;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.List;
import java.util.Map;
import spark.ModelAndView;

import spark.template.velocity.VelocityTemplateEngine;

public class MenuController {

    private MenuDAO menuDAO;
    VelocityTemplateEngine velocityTemplateEngine = new VelocityTemplateEngine();

    public MenuController(MenuDAO menuDAO) {
        this.menuDAO = menuDAO;
    }

    public Route mostrarMenus = (Request request, Response response) -> {
        List<Menu> menu = menuDAO.obtenerTodosLosMenus();
        
        Map<String, Object> model = new HashMap<>();
        model.put("menu", menu);

        return velocityTemplateEngine.render(new ModelAndView(model, "templates/menu.vm"));
    };

}
