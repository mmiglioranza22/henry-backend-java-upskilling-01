package com.pispring.PISpring;

import com.pispring.PISpring.controller.CategoriaController;
import com.pispring.PISpring.controller.GastosController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExpenseTracker implements CommandLineRunner {
    @Autowired
    private CategoriaController categoriaController;
    @Autowired
    private GastosController gastosController;

    public static void main(String[] args) {
        SpringApplication.run(ExpenseTracker.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Inicializando... Base de datos creada y conectada!");
        System.out.println("Servidor escuchando en localhost:8080/api/v1");
        ;
    }
}
