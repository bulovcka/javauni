package prac7_1;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(String_interface.odd(s));
        System.out.println(String_interface.lenght(s));
        System.out.println(String_interface.reverse(s));
    }
}
