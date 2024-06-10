package services;

import entities.Product;
import entities.ShoppingCart;
import interfaces.ProductService;

public class ProductServiceImpl implements ProductService {

    private ShoppingCart cart;

    public ProductServiceImpl(ShoppingCart cart) {
        this.cart = cart;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    @Override
    public void addProductToCart(Product product, int number) {
        int cycles = 0;
        while (cycles < number) {
            cart.addProduct(product);
            cycles++;
        }

    }
}
// service usa shopping cart