package prac9_1;

import java.util.Scanner;
import java.util.Random;

public class Student implements Comparable<Student> { ;
    private final int ID;

    public Student(int ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID=" + ID +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(ID, o.ID);
    }

    public static void gnomeSort(Student[] students){
        int index = 0;
        while (index < students.length) {
            if (index == 0){
                index ++;

            }

            if (students[index].compareTo(students[index - 1]) < 0) {
                Student temp = students[index];
                students[index] = students[index - 1];
                students[index - 1] = temp;
                index--;
            } else{
              index++;
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int n;
        System.out.println("Enter the number of students: ");
        n = sc.nextInt();
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            Student student = new Student(rand.nextInt());
            students[i] = student;
            System.out.println(students[i].ID);
        }

        gnomeSort(students);


        System.out.println("Sorted students by ID: ");
        for(Student student  : students){
            System.out.println(student.ID);
        }
    }
}