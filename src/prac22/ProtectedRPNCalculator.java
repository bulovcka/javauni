package prac22;

import java.util.Stack;

public class ProtectedRPNCalculator {
    private static  Stack<Double> stack = new Stack<>();

    private static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }

    private static boolean isOp(String str){
        return str.matches("[+\\-/*]");
    }

    public static Double solveString(String args){
        String[] tokens = args.split(" ");
        for(String token: tokens){
            if(isNumeric(token)){
                stack.add(Double.parseDouble(token));
            } else if (isOp(token)){
                if(!stack.empty()) {
                    Double arg2 = stack.pop();
                    if (!stack.empty()) {
                        Double arg1 = stack.pop();
                        stack.add(operate(token, arg1, arg2));
                    } else throw new IllegalArgumentException("Wrong count of numbers and operators");
                } else throw new IllegalArgumentException("Wrong count of numbers and operators");
            } else throw new IllegalArgumentException("NaN or not an operator");
        }
        if (!stack.empty()){
            Double res = stack.pop();
            if(!stack.empty()){
                throw new IllegalArgumentException("Wrong count of numbers and operators");
            }
            return res;
        } else throw new IllegalArgumentException("Wrong count of numbers and operators");
    }

    private static double operate(String op, Double arg1, Double arg2){
        switch (op){
            case "+" -> {
                return arg1 + arg2;
            }
            case "-" -> {
                return arg1 - arg2;
            }
            case "*" -> {
                return arg1 * arg2;
            }
            case "/" -> {
                if (arg2 != 0) {
                    return arg1 / arg2;
                } else {throw new IllegalArgumentException("DIVISION BY ZERO");}
            }
        }
        return 0;
    }
}
