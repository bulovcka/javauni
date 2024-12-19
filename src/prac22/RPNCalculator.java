package prac22;


import java.util.Scanner;
import java.util.Stack;

public class RPNCalculator {
    static  Stack<Double> stack = new Stack<>();
    static Scanner scanner = new Scanner(System.in);
    static String next;
    static Double firstOp, secondOp;

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    public static void main(String[] args) {
        System.out.println("Введите арифметическое выражение в обратной польской нотации\n" +
                "А затем нажмите Ctrl+D для завершения ввода");
        while (scanner.hasNext()){
            next = scanner.next();
            if(isNumeric(next)){
                stack.add(Double.parseDouble(next));
            } else {
                secondOp = stack.pop();
                firstOp = stack.pop();
                switch (next){
                    case "+" -> stack.add(firstOp + secondOp);
                    case "-" -> stack.add(firstOp - secondOp);
                    case "*" -> stack.add(firstOp * secondOp);
                    case "/" -> {
                        if (secondOp != 0) {
                            stack.add(firstOp / secondOp);
                        } else {throw new IllegalArgumentException("DIVISION BY ZERO");}
                    }
                }
            }
        }
        System.out.println(stack.pop());
    }
}
