package com.mycompany.proyectofika;

import lombok.Data;

@Data
public class Cliente {
    private int id;
    private String nombre;
    private String email;
    private String telefono;
    private int edad;

    public Cliente(int id, String nombre, String email, String telefono, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.edad = edad;
    }
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", edad=" + edad +
                '}';
    }

    int getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
