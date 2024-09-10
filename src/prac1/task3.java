package prac1;

import java.util.Scanner;
public class task3 {
    public static void main(String[] args){
        System.out.println("Enter your number ");
        int n = 0;
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()){
            n = sc.nextInt();
        }
        else{
            System.out.println("Not a number");
        }
        System.out.println("Faktorial: " + faktorial(n));
    }
    static public int faktorial(int a){
        int x = 1;
        for (int i = 1; i <= a;i++){
            x *= i;
        }
        return x;
    }
}
