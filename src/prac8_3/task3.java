package prac8_3;
import java.util.Scanner;

public class task3{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        do {
            System.out.print("Введите натуральное число n (n > 1): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Ошибка: необходимо ввести натуральное число больше 1.");
                scanner.next();
            }
            n = scanner.nextInt();
        } while (n <= 1);
        int reversed = reverse(n);
        System.out.println("Разворот числа: " + reversed);
        scanner.close();
    }
    public static int reverse(int n) {
        if (n < 10) {
            return n;
        }

        int lastDigit = n % 10;
        int digits = (int) Math.log10(n);

        return lastDigit * (int) Math.pow(10, digits) + reverse(n / 10);
    }
}