package prac8_7;
// 3 zadanie
public class task7 {
    public static void output(int a, int b){
        if (a == b){
            System.out.println(a + " ");
            return;
        }
        System.out.println(a + " ");
        output(a+1, b);
    }
    public static void main(String[] args) {
        output(10, 15);
    }
}
