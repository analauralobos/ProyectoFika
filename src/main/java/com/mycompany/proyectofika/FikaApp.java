package com.mycompany.proyectofika;

import spark.Spark;

public class FikaApp {
    public static void main(String[] args) {
        // Configuraciones iniciales de Spark y otras configuraciones generales aquí

        // Iniciar controladores y rutas
        FikaAppController.init();
    }
}
