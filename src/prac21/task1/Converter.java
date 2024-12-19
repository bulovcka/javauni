package prac21.task1;



import java.util.ArrayList;
import java.util.Arrays;

public class Converter {
    public static ArrayList<String> toList(String[] array){
        return new ArrayList<>(Arrays.asList(array));
    }

    public static ArrayList<Integer> toList(int[] array) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (Integer num : array) {
            ans.add(num);
        }
        return ans;
    }
}