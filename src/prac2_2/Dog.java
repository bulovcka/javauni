package prac2_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Dog {
    private int age;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Dog(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public int getHumanAge() {
        return age * 7;
    }
}

class DogKennel {
    private List<Dog> dogs;

    public void getDogsHumanAge(){
        for (Dog dog : dogs){

            System.out.println(dog.getName() + " " + dog.getHumanAge());
        }
    }
    public DogKennel() {
        this.dogs = new ArrayList<>();
    }

    public void dogAdd(Dog dog) {
        dogs.add(dog);
    }

    public void displayDogsName() {
        for (Dog dog : dogs) {
            System.out.println(dog.getName());
        }
    }

    public Dog getDogByIndex(int index) {
        if(index > 0 || index < dogs.size()) return dogs.get(index);
        else return null;
    }
}

class DogTest {
    public static boolean valideAnswer(String answer) {
        return answer.equals("1");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DogKennel dogKennel = new DogKennel();

        do{
            System.out.println("Enter name of the dog: ");
            String name = sc.nextLine();
            System.out.println("Enter age of the dog: ");
            int age = sc.nextInt();
            sc.nextLine();

            dogKennel.dogAdd(new Dog(age, name));
            System.out.println("To exit type exit: ");
        } while (!sc.nextLine().equals("exit"));

        dogKennel.displayDogsName();

        System.out.println("Do you want to add another dog to the kennel? Type 1 for yes or type 2 for no:");
        while (valideAnswer(sc.nextLine())) {
            System.out.println("Enter name of the dog: ");
            String name = sc.nextLine();
            System.out.println("Enter age of the dog: ");
            int age = sc.nextInt();
            sc.nextLine();

            dogKennel.dogAdd(new Dog(age, name));
            System.out.println("Another one? type 1 for yes or type 2 for no:");
        }
        dogKennel.displayDogsName();
        System.out.println("Dogs age -> Human age");
        dogKennel.getDogsHumanAge();

    }
}