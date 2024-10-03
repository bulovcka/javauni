package prac3_1;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class prac3 {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        ArrayList<Integer> arr = new ArrayList<>();
        int[] mas = {1, 2, 4, 10};
        int min = 10, max = 99;
        while(true) {
            System.out.println("Enter size of array or 0 to exit ");
            if (sc.hasNextInt()) {
                int n = sc.nextInt();
                if (n == 0) {
                    break;
                } else if (n < 0) {
                    System.out.println("Incorrec size try again");
                    continue;
                }
                for (int i = 0; i < n; i++) {
                    arr.add(min + rand.nextInt(max - min + 1));
                }
                System.out.println("Array");
                for (int num : arr) {
                    System.out.printf(num + " ");
                }
                System.out.println();
                break;
            }else{
                System.out.println("Incorrect input try again");
                sc.next();
            }
        }
        if (isIncreasing(arr)){
            System.out.println("Array is increasing");
        }else{
            System.out.println("Array is not increasing");
        }
    }
    public static boolean isIncreasing(ArrayList<Integer> arr){
        for (int i = 1; i < arr.size();i++){
            if (arr.get(i) <= arr.get(i-1)){
                return false;
            }
        }
        return true;
    }
}
