package prac12;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<CartItem> products = new ArrayList<>();

    public void addProduct(OnlineShop.Product product, LocalDateTime addedTime) {
        products.add(new CartItem(product, addedTime));
    }

    public List<CartItem> getProducts() {
        return products;
    }

    public void checkout() {
        products.clear();
    }
}
