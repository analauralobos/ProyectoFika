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
        
        for (Menu m : menu) {
        double precioTotal = 0.0;

        for (Producto producto : m.getProductos()) {
            precioTotal += producto.getPrecio();
        }

        m.setPrecioTotal(precioTotal);
    }
        Map<String, Object> model = new HashMap<>();
        model.put("menus", menu);

        return velocityTemplateEngine.render(new ModelAndView(model, "templates/menu.vm"));
    };

    public Route crearMenu = (Request request, Response response) -> {
        // Obtén los datos del menú enviados por el usuario desde 'request'
        String nombreMenu = request.queryParams("nombreMenu"); // Asegúrate de que coincida con el nombre del campo en el formulario HTML
        String descripcion = request.queryParams("descripcion");
        double precio = Double.parseDouble(request.queryParams("precio"));
        String categoria = request.queryParams("categoria");

        // Crea un nuevo menú con los datos proporcionados
        int nuevoId = menuDAO.generarIdUnico();
        Menu nuevoMenu = new Menu(nuevoId, nombreMenu);


        // Obten los datos de los productos
        String[] nombresProductos = request.queryParamsValues("nombreProducto");
        String[] categoriasProductos = request.queryParamsValues("categoriaProducto");
        String[] preciosProductos = request.queryParamsValues("precioProducto");

        // Verifica que se hayan proporcionado datos de productos
        if (nombresProductos != null && categoriasProductos != null && preciosProductos != null) {
            for (int i = 0; i < nombresProductos.length; i++) {
                String nombreProducto = nombresProductos[i];
                String categoriaProducto = categoriasProductos[i];
                double precioProducto = Double.parseDouble(preciosProductos[i]);

                Producto producto = new Producto(i + 1, nombreProducto, categoriaProducto, precioProducto);
                nuevoMenu.agregarProducto(producto);
            }
        }

        // Agrega el nuevo menú al DAO de menús
        menuDAO.agregarMenu(nuevoMenu);

        // Redirecciona al usuario a la página de menús o muestra una página de confirmación
        response.redirect("/menu-creado");
        return ""; // Esto es necesario para que Spark no genere una respuesta automáticamente
    };

    

}
