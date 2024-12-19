package prac21.task2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Object[] testArr = {1, -0.234, 010, 5L, "String", 2.5, 1.5f};
        ArrayHolder test = new ArrayHolder(testArr);
        System.out.println(Arrays.toString(test.getArray()));
    }
}
