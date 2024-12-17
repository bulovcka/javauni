package prac8_6;

import java.util.Scanner;
//7 zadanie
public class task6 {
    public static void factorize(int n, int d) {
        if (n == 1) {
            return;
        }
        if (n % d == 0) {
            System.out.print(d + " ");
            factorize(n / d, d);
        } else {
            factorize(n, d + 1);
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите натуральное число (n > 1): ");
        int n = scanner.nextInt();

        System.out.print("Простые множители: ");
        factorize(n, 2);
    }
}
