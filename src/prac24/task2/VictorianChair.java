package prac24.task2;



import prac24.task2.Interfaces.Chair;

public class VictorianChair implements Chair {
    private int age;
    public VictorianChair(int age){
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
