package prac6_2;

public class Jeans implements Pricable{
    public int price;
    public String model;
    public int size;

    public Jeans(int price, String model, int size) {
        this.price = price;
        this.model = model;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Jeans{" +
                "price=" + price +
                ", model='" + model + '\'' +
                ", size=" + size +
                '}';
    }

    public void getPrice() {
        System.out.println(price);
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
