package prac13.prac13_2;

public class Main {
    public static void main(String[] args) {
        Person person1 = new Person("иван", "иванов", "иванович");
        Person person2 = new Person("", "kerg", "");
        System.out.println(person1.getFullName());
        System.out.println(person2.getFullName());
    }
}
