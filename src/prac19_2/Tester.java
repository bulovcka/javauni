package prac19_2;

public class Tester {
    public static void main(String[] args) {
        User user1 = new User("Иванов Иван Иванович", "7707083893");
        User user2 = new User("Петров Петр Петрович", "123456789012");
        OrderProcessor op = new OrderProcessor();
        try{
            op.orderProcess(user1);
            op.orderProcess(user2);
        } catch (InnException e) {
            System.out.println(e.getMessage());
        }
    }
}
