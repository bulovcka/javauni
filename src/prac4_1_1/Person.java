package prac4_1_1;

public class Person {
    public String fullName;
    public int age;

    @Override
    public String toString(){
        return fullName + " " + age;
    }
    public Person(String fullName, int age){
        this.fullName = fullName;
        this.age = age;
    }

    public Person(){
        this.fullName = "Unknown";
        this.age = 20;
    }

    public String getFullName(){
        return fullName;
    }
    public int getAge(){
        return age;
    }
    public void setFullName(String fullName){
        this.fullName = fullName;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void move(){
        System.out.println(fullName + "is moving");
    }

    public void talk(){
        System.out.println(fullName + "is talking");
    }
}
