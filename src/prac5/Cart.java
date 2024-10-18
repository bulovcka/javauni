package prac5;

import java.util.ArrayList;

class Cart {
    private ArrayList<OnlineShopGUI.Product> products = new ArrayList<>();

    public void addProduct(OnlineShopGUI.Product product) {
        products.add(product);
    }

    public ArrayList<OnlineShopGUI.Product> getProducts() {
        return products;
    }

    public void checkout() {
        products.clear();
    }
}