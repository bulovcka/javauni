import java.util.Scanner;
public class task1 {
    public static void main(String[] args){
        System.out.println("Enter array numbers");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] arr = input.split(" ");
        double avg = 0;
        int[] array = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            try{
                array[i] = Integer.parseInt(arr[i]);
            } catch (NumberFormatException e){
                System.out.println("Not a number " + array[i] + " Retry");
                return;
            }
        }
        System.out.print("Array is ");
        for (int i = 0; i < array.length;i++){
            System.out.print(array[i] + " ");
            avg += array[i];
        }
        System.out.println();
        System.out.println("Average " + avg/array.length);
    }
}