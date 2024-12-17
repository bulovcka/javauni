package prac8_5;
//9 zadanie
public class task5 {
    public static int countSequences(int a, int b, boolean prevZero) {
        if (a == 0 && b == 0) {
            return 1;
        }

        int count = 0;

        if (a > 0 && !prevZero) {
            count += countSequences(a - 1, b, true);
        }

        if (b > 0) {
            count += countSequences(a, b - 1, false);
        }

        return count;
    }

    public static void main(String[] args) {
        int a = 3;
        int b = 3;

        int result = countSequences(a, b, false);
        System.out.println("Количество допустимых последовательностей: " + result);
    }
}
