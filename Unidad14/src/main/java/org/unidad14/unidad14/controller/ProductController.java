package org.unidad14.unidad14.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.unidad14.unidad14.domain.Product;
import org.unidad14.unidad14.service.IProductService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    IProductService<Product> productService;

    public ProductController(IProductService<Product> productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        return new ResponseEntity<>(this.productService.getAllProducts(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> insertProduct(@RequestBody Product newProduct) {
//        Product need to be called with new so the id counter is not set to 0 (being a @Component)
        return ResponseEntity.ok(this.productService.insertProduct(new Product(newProduct.getNombre(), newProduct.getPrecio())));
    }

}
