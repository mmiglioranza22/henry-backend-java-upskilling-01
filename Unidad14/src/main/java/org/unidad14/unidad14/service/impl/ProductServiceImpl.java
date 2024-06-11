package org.unidad14.unidad14.service.impl;

import org.springframework.stereotype.Service;
import org.unidad14.unidad14.domain.Product;
import org.unidad14.unidad14.service.IProductService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements IProductService<Product> {

    List<Product> list = new ArrayList<>();

    @Override
    public List<Product> getAllProducts() {
        return list;
    }

    @Override
    public String insertProduct(Product product) {
        int previousSize = list.size();
        list.add(product);
        if (list.size() > previousSize) {
            return "Product inserted correctly!";
        } else {
            return "Error inserting product";
        }
    }
}
