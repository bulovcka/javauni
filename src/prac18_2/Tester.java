package prac18_2;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ThrowDemo td = new ThrowDemo();
        try {
            System.out.println("Введите строку");
            td.printMessage(sc.next());
        } catch (NullPointerException e) {
            System.err.println("На вход программе было подано значение null");
        }

        try {
            td.printMessage(null);
        } catch (NullPointerException e) {
            System.err.println("На вход программе было подано значение null");
        }
    }
}
