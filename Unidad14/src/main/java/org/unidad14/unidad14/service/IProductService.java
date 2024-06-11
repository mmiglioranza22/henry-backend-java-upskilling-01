package org.unidad14.unidad14.service;

public interface IProductService<T> {

    public T getAllProducts();

    public T insertProduct(T product);
}
