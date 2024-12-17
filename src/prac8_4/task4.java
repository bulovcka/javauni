package prac8_4;

import java.util.Scanner;
//zadanie 5
public class task4 {
    public static int sumDigits(int n) {

        if (n < 10) {
            return n;
        }

        return n % 10 + sumDigits(n / 10);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите натуральное число: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Число должно быть натуральным (n > 0)");
            return;
        }

        int result = sumDigits(n);
        System.out.println("Сумма цифр числа: " + result);
    }
}
