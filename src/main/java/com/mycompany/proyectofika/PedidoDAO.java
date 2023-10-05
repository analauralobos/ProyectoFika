package com.mycompany.proyectofika;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PedidoDAO {
    private List<Pedido> pedidos;

    public PedidoDAO() {
        // Inicializa una lista de pedidos en memoria y agrega algunos pedidos de ejemplo
        this.pedidos = new ArrayList<>();
        agregarPedidosDeEjemplo();
    }

    // Método para agregar un nuevo pedido
    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    // Método para obtener todos los pedidos
    public List<Pedido> obtenerTodosLosPedidos() {
        return pedidos;
    }

    // Método para obtener un pedido por su ID
    public Pedido obtenerPedidoPorId(int id) {
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == id) {
                return pedido;
            }
        }
        return null; // Retorna null si el pedido no se encuentra
    }

    // Método para agregar pedidos de ejemplo
    private void agregarPedidosDeEjemplo() {
        Pedido pedido1 = new Pedido(1, new Cliente(1, "Cliente1", "cliente1@example.com", "+1234567891", 30),
                new Date(), new Date(), "En proceso");
        pedido1.agregarMenu(new Menu(1, "Menú de Desayuno"));
        agregarPedido(pedido1);

        Pedido pedido2 = new Pedido(2, new Cliente(2, "Cliente2", "cliente2@example.com", "+1234567892", 35),
                new Date(), new Date(), "Entregado");
        pedido2.agregarMenu(new Menu(2, "Menú de Almuerzo"));
        agregarPedido(pedido2);
    }
}
