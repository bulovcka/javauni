package prac8_1;
public class Triag {
    public static void recursion(int n, int currentNumber, int count){
        if (n == 0){
            return;
        }
        System.out.println(currentNumber + " ");
        if (count == currentNumber){
            recursion(n - 1, currentNumber + 1, 1);
        }else{
            recursion(n - 1, currentNumber, count + 1);
        }
    }
    public static void main(String[] args) {
        int n = 10;
        recursion(n, 1, 1);
    }
}
