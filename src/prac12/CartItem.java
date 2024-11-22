package prac12;

import java.time.LocalDateTime;

public class CartItem {
    OnlineShop.Product product;
    LocalDateTime addedTime;

    public CartItem(OnlineShop.Product product, LocalDateTime addedTime) {
        this.product = product;
        this.addedTime = addedTime;
    }
}
