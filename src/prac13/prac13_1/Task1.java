package prac13.prac13_1;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String x = sc.nextLine();
        System.out.println(x.charAt(x.length()-1));
        if (x.endsWith("!!!")){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
        if (x.startsWith("I like")){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
        if (x.contains("Java")){
            System.out.println("yes");
        }else{
            System.out.println("no");
        }
        System.out.println(x.indexOf("Java"));
        String y = x.replace("a", "o");
        System.out.println(y);
        System.out.println(x.toUpperCase());
        System.out.println(x.toLowerCase());
        int a = 0;
        int b = 0;
        for (int i = 0; i < x.length(); i++){
            if (x.charAt(i) == 'J'){
                a = i;
            }
            if (x.charAt(i) == '!'){
                b = i;
                break;
            }
        }
        System.out.println(x.substring(a,b));
    }
}
