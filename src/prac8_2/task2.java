package prac8_2;
import java.util.Scanner;

public class task2 {
    public static void recursion(int cur, int n){
        if (cur > n){
            return;
        }
        System.out.print(cur + " ");
        recursion(cur+1, n);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int n = sc.nextInt();
            int cur = sc.nextInt();
            recursion(cur, n);
        }else{
            System.out.println("Invalid input");
        }
    }
}
