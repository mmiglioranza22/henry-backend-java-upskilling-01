package org.unidad14.unidad14.service;

import java.util.List;

public interface IProductService<T> {

    public List<T> getAllProducts();

    public String insertProduct(T product);
}
