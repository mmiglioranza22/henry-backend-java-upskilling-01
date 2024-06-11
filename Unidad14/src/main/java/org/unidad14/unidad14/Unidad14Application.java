package org.unidad14.unidad14;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.unidad14.unidad14.controller.ProductController;

@SpringBootApplication
public class Unidad14Application {

    @Autowired
    public ProductController productController;

    public static void main(String[] args) {
        SpringApplication.run(Unidad14Application.class, args);
    }

}
