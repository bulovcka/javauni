package prac6_2;

public class Camera implements Pricable {
    public String name;
    public int price;
    public boolean microphone;

    public Camera(String name, int price, boolean microphone) {
        this.name = name;
        this.price = price;
        this.microphone = microphone;
    }

    @Override
    public void getPrice() {
        System.out.println(price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setMicrophone(boolean microphone) {
        this.microphone = microphone;
    }

    public boolean isMicrophone() {
        return microphone;
    }

    @Override
    public String toString() {
        return "Camera{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", microphone=" + microphone +
                '}';
    }
}
