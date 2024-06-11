package org.unidad14.unidad14.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unidad14.unidad14.domain.Product;

@RestController("/product")
public class ProductController {



    @GetMapping("/all")
    public ResponseEntity<Product> getAllProducts() {

        return new ResponseEntity<>()
    }

}
