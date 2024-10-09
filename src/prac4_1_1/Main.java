package prac4_1_1;

public class Main {
    public static void main(String args[]){
        Person person1 = new Person();
        Person person2 = new Person("Ivan", 11);
        System.out.println(person1.getFullName() + " " + person1.getAge());
        System.out.println(person2.getFullName() + " "+ person2.getAge());
        person1.setAge(9);
        System.out.println(person1.getFullName() + " " + person1.getAge());
    }
}
