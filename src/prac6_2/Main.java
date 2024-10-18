package prac6_2;

public class Main {
    public static void main(String[] args) {
        Jeans jeans = new Jeans(100, "Jeans", 42);
        Laptop laptop = new Laptop("Xiaomi", 200);
        Camera camera = new Camera("Sony", 100, true);
        System.out.println(jeans);
        System.out.println(laptop);
        System.out.println(camera);
    }
}
