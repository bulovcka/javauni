package prac8_4;

import java.util.Scanner;

public class task4 {
    public static boolean palindrome(String str){
        if (str.length() <= 1) return true;
        if (str.charAt(0) != str.charAt(str.length()-1)) return false;
        return palindrome(str.substring(1, str.length()-1));

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        if(palindrome(str)){
            System.out.println("YES");
        }else {
            System.out.println("NO");
        }
    }
}
