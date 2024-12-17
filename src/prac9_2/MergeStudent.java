package prac9_2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class MergeStudent implements Comparable<MergeStudent> {
    private int ID;

    public MergeStudent(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    @Override
    public String toString() {
        return "MergeStudent{" +
                "ID=" + ID +
                '}';
    }

    @Override
    public int compareTo(MergeStudent o) {
        return Integer.compare(this.ID, o.ID);
    }

    public static void mergeSort(ArrayList<MergeStudent> students, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(students, left, mid);
            mergeSort(students, mid + 1, right);

            merge(students, left, mid, right);
        }
    }

    private static void merge(ArrayList<MergeStudent> students, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        MergeStudent[] leftArray = new MergeStudent[n1];
        MergeStudent[] rightArray = new MergeStudent[n2];

        System.arraycopy(students.toArray(), left, leftArray, 0, n1);
        System.arraycopy(students.toArray(), mid + 1, rightArray, 0, n2);

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (leftArray[i].compareTo(rightArray[j]) <= 0) {
                students.set(k, leftArray[i]);
                i++;
            } else {
                students.set(k, rightArray[j]);
                j++;
            }
            k++;
        }

        while (i < n1) {
            students.set(k, leftArray[i]);
            i++;
            k++;
        }

        while (j < n2) {
            students.set(k, rightArray[j]);
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        ArrayList<MergeStudent> list1 = new ArrayList<>();
        ArrayList<MergeStudent> list2 = new ArrayList<>();

        System.out.println("Enter number of students for list 1:");
        int num = sc.nextInt();
        System.out.println("Enter number of students for list 2:");
        int num2 = sc.nextInt();
        System.out.println("List1");
        for (int i = 0; i < num; i++) {
            MergeStudent student = new MergeStudent(rand.nextInt(1000)); // Генерируем ID от 0 до 999
            list1.add(student);
            System.out.println(student);
        }
        System.out.println("List2");
        for (int i = 0; i < num2; i++) {
            MergeStudent student = new MergeStudent(rand.nextInt(1000)); // Генерируем ID от 0 до 999
            list2.add(student);
            System.out.println(student);
        }

        list1.addAll(list2);
        mergeSort(list1, 0, list1.size() - 1);

        System.out.println("Sorted students:");
        for (MergeStudent student : list1) {
            System.out.println(student);
        }

        sc.close();
    }
}
