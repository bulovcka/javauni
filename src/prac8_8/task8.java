package prac8_8;

import java.util.Scanner;
//14 zadanie
public class task8 {
    public static void printDigits(int n) {
        if (n == 0) {
            return;
        }
        printDigits(n / 10);
        System.out.print(n % 10 + " ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        printDigits(N);
    }
}
