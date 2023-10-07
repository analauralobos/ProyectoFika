package com.mycompany.proyectofika;

import java.util.ArrayList;
import java.util.List;

public class MenuDAO {
    private List<Menu> menus;
    private int ultimoId = 0; // Registro del último ID asignado

    public MenuDAO() {
        // Inicializa una lista de menús en memoria y agrega algunos menús de ejemplo
        this.menus = new ArrayList<>();
        agregarMenusDeEjemplo();
    }

    // Método para agregar un nuevo menú
    public void agregarMenu(Menu menu) {
        // Asigna un ID único al menú antes de agregarlo
        menu.setId(generarIdUnico());
        this.menus.add(menu);
    }

    // Método para generar un ID único
    int generarIdUnico() {
        // Incrementa el último ID asignado y lo devuelve como un nuevo ID único
        return ++ultimoId;
    }
    // Método para obtener todos los menús
    public List<Menu> obtenerTodosLosMenus() {
        return menus;
    }

    // Método para obtener un menú por su ID
    public Menu obtenerMenuPorId(int id) {
        for (Menu menu : menus) {
            if (menu.getId() == id) {
                return menu;
            }
        }
        return null; // Retorna null si el menú no se encuentra
    }

    // Método para agregar menús de ejemplo
    private void agregarMenusDeEjemplo() {
        Menu menu1 = new Menu(1, "Menú de Desayuno");
        menu1.agregarProducto(new Producto(1, "Café Espresso", "Café", 2.5));
        menu1.agregarProducto(new Producto(2, "Croissant", "Panadería", 1.5));
        agregarMenu(menu1);

        Menu menu2 = new Menu(2, "Menú de Almuerzo");
        menu2.agregarProducto(new Producto(3, "Sándwich de Jamón y Queso", "Sándwich", 5.5));
        menu2.agregarProducto(new Producto(4, "Ensalada César", "Ensalada", 4.0));
        agregarMenu(menu2);
    }
    
    


}
