package prac8_3;

public class task3 {
    public static int sum(int n){
        if (n < 10){
            return n;
        }

        return n % 10 + sum(n / 10);

    }
    public static void main(String[] args){
        System.out.println(sum(123456));
    }
}
