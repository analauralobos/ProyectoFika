package com.mycompany.proyectofika;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
public class Pedido {
    private int id;
    private Cliente cliente;
    private List<Menu> menus;
    private Date fechaPedido;
    private Date fechaEntrega;
    private String estado;

    public Pedido(int id, Cliente cliente, Date fechaPedido, Date fechaEntrega, String estado) {
        this.id = id;
        this.cliente = cliente;
        this.menus = new ArrayList<>();
        this.fechaPedido = fechaPedido;
        this.fechaEntrega = fechaEntrega;
        this.estado = estado;
    }

    // Getters y setters (métodos para acceder y modificar los atributos)

    public int getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Menu> getMenus() {
        return menus;
    }

    public void agregarMenu(Menu menu) {
        menus.add(menu);
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
