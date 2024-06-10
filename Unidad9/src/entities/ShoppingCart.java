package entities;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Product> productList;


    public ShoppingCart() {
        this.productList = new ArrayList<>();
    }

    public ShoppingCart(List<Product> productList) {
        this.productList = productList;
    }

    public List<Product> getProducts() {
        return this.productList;
    }

    public double getTotalProducts() {
        double total = this.productList.stream().map(el -> el.getPrice()).reduce(0.0, (acc, curr) -> acc + curr);
        System.out.println(total);
        return total;
    }

    public void addProduct(Product product) {
        this.productList.add(product);

    }
}
