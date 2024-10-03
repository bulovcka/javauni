package prac3_2;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
public class prac3_2 {
    public static void arrayOut(ArrayList<Integer> arr){
        for (int nums : arr){
            System.out.print(nums + " ");
        }
    }
    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> mas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        while (true){
            System.out.println("Enter size of array");
            if (sc.hasNextInt()){
                int n = sc.nextInt();
                if (n == 0){
                    break;
                }else if (n < 0){
                    System.out.println("Incorrect input try again");
                    continue;
                }
                for (int i = 0; i < n; i++){
                    arr.add(rand.nextInt(n));
                }
                System.out.println("Array");
                arrayOut(arr);
                System.out.println();
                break;
            }else{
                System.out.println("Incorrect input try again");
                sc.next();
            }
        }
        for (int i = 0; i < arr.size(); i++){
            if (arr.get(i) % 2 == 0){
                mas.add(arr.get(i));
            }
        }
        System.out.println("Array of even numbers ");
        arrayOut(mas);
    }
}
