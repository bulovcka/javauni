package prac10;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;
import java.util.Random;


public class SortingStudentGPA {
    public static ArrayList<Student> setArray(int n){
        Random rand = new Random();
        ArrayList<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Student student = new Student(
                    "Name" + (char) (rand.nextInt(65, 91)),
                    "Surname" + (char) (rand.nextInt(65, 91)),
                    "Specialization" + (char) (rand.nextInt(65, 91)),
                    rand.nextInt(1, 4),
                    "Group" + (char) (rand.nextInt(65, 91))
            );
            students.add(student);
        }
        return students;
    }
    public static void outArray(ArrayList<Student> arr) {
        for(Student student : arr){
            System.out.println(student);
        }
    }
    public static void quickSort(ArrayList<Student> arr, int low, int high, Comparator<Student> cmp){
        if (low < high) {
            int pivotIndex = partition(arr, low, high, cmp);

            quickSort(arr, low, pivotIndex - 1, cmp);
            quickSort(arr, pivotIndex + 1, high, cmp);
        }
    }

    private static int partition(ArrayList<Student> students, int low, int high, Comparator<Student> comparator) {
        Student pivot = students.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (comparator.compare(students.get(j), pivot) <= 0) {
                i++;

                Student temp = students.get(i);
                students.set(i, students.get(j));
                students.set(j, temp);
            }
        }

        Student temp = students.get(i + 1);
        students.set(i + 1, students.get(high));
        students.set(high, temp);

        return i + 1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of students1: ");
        int n = sc.nextInt();
        System.out.println("Enter the number of students2: ");
        int m = sc.nextInt();
        ArrayList<Student> arr1 = setArray(n);
        ArrayList<Student> arr2 = setArray(m);
        System.out.println("Students1");
        outArray(arr1);
        System.out.println("Students2");
        outArray(arr2);
        Comparator<Student> studentComparator = new
                SortByCourse().thenComparing(new
                SortByName()).thenComparing(new
                SortBySurname()).thenComparing(new
                SortBySpecialization()).thenComparing(new
                SortByGroup());
        arr1.addAll(arr2);
        System.out.println();

        quickSort(arr1, 0, arr1.size()-1, studentComparator);
        outArray(arr1);
    }
}
