package prac8_5;

public class task5 {
    public static void recursion(int n){
        if (n == 0){
            return;
        }else{
            recursion(n / 10);
            System.out.println(n % 10);
        }
    }

    public static void main(String[] args){
        recursion(150);
    }
}
