package com.mycompany.proyectofika;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ClienteDAO {
    private List<Cliente> clientes;
    private Random random;

    public ClienteDAO() {
        // Inicializa una lista de clientes en memoria
        this.clientes = new ArrayList<>();
        this.random = new Random();

        // Agregar algunos clientes de prueba aleatorios
        agregarClientesDePrueba();
    }

    // Método para agregar un nuevo cliente
    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    // Método para obtener todos los clientes
    public List<Cliente> obtenerTodosLosClientes() {
        return clientes;
    }

    // Método para obtener un cliente por su ID
    public Cliente obtenerClientePorId(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                return cliente;
            }
        }
        return null; // Retorna null si el cliente no se encuentra
    }

    // Método para agregar clientes de prueba aleatorios
    private void agregarClientesDePrueba() {
        for (int i = 1; i <= 10; i++) {
            String nombre = "Cliente" + i;
            String email = "cliente" + i + "@ejemplo.com";
            String telefono = "+123456789" + i;
            int edad = random.nextInt(50) + 20; // Edad aleatoria entre 20 y 69 años

            // Crea un nuevo cliente aleatorio y lo agrega a la lista
            Cliente cliente = new Cliente(i, nombre, email, telefono, edad);
            agregarCliente(cliente);
        }
    }
}
