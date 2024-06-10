package entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import services.ProductServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ShoppingCart suite")
class ShoppingCartTest {

    @DisplayName("Agrega un producto al carrito")
    @Test
    public void testAddsProductToCart() {
//        GIVEN
        Product product = new Product(100, "papas", 2500);
        ShoppingCart cart = new ShoppingCart();

//        WHEN
        cart.addProduct(product);

//        THEN
        List<Product> list = cart.getProducts();
        Assertions.assertEquals(list.get(0), product);
    }

    @DisplayName("Devuelve lista vacía si no hay productos agregados")
    @Test
    public void testReturnsEmptyListIfNoProductsAdded() {
//    GIVEN
        ShoppingCart cart = new ShoppingCart();
//    WHEN
//    THEN
        List<Product> list = cart.getProducts();
        Assertions.assertEquals(list.size(), 0);

    }

    @DisplayName("Obtiene todos los productos del carrito")
    @Test
    public void testReturnsProductList() {
        //        GIVEN
        Product product1 = new Product(100, "papas", 2500);
        Product product2 = new Product(200, "manzanas", 2000);
        Product product3 = new Product(300, "peras", 3000);
        ShoppingCart cart = new ShoppingCart();

//        WHEN
        cart.addProduct(product1);
        cart.addProduct(product2);
        cart.addProduct(product3);

//        THEN
        List<Product> list = cart.getProducts();
        Assertions.assertEquals(list.size(), 3);
        Assertions.assertEquals(list.get(0), product1);
        Assertions.assertEquals(list.get(1), product2);
        Assertions.assertEquals(list.get(2), product3);
    }

    @DisplayName("Obtiene el total de los productos agregados")
    @Test
    public void testReturnsTotalOfAllProducts() {
//        GIVEN
        Product product1 = new Product(100, "papas", 2500);
        Product product2 = new Product(100, "papas", 2500);
        ShoppingCart cart = new ShoppingCart();

//        WHEN
        cart.addProduct(product1);
        cart.addProduct(product2);

//        THEN
        double total = cart.getTotalProducts();
        Assertions.assertEquals(product1.getPrice() + product2.getPrice(), total);
    }
}