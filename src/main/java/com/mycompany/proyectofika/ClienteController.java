package com.mycompany.proyectofika;

import spark.Request;
import spark.Response;
import spark.Route;

import java.util.List;

public class ClienteController {
    private ClienteDAO clienteDAO;

    public ClienteController(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    public Route mostrarClientes = (Request request, Response response) -> {
        List<Cliente> clientes = clienteDAO.obtenerTodosLosClientes();
        // Renderizar una vista o devolver los clientes como JSON, según tus necesidades
        return "Lista de Clientes: " + clientes.toString();
    };

    // Agregar más métodos para crear, actualizar y eliminar clientes según tus necesidades
}
