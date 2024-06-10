package interfaces;

import entities.Product;

public interface ProductService {
    public void addProductToCart(Product product, int number);
}
