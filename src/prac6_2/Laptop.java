package prac6_2;

public class Laptop implements Pricable{

    public String model;
    public int price;
    public Laptop(String model, int price) {
        this.model = model;
        this.price = price;
    }
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    @Override
    public void getPrice() {
        System.out.println(price);
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
