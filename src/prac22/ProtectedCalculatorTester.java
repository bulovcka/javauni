package prac22;

import java.util.Scanner;

public class ProtectedCalculatorTester {
    public static void main(String[] args) {
        String arg1 = "2 3 +";
        String arg2 = "2 3 * 4 5 * +";
        String arg3 = "2 3 4 5 6 * + - / ";
        String arg4 = "2 3 + 5";
        System.out.println(ProtectedRPNCalculator.solveString(arg1));
        System.out.println(ProtectedRPNCalculator.solveString(arg2));
        System.out.println(ProtectedRPNCalculator.solveString(arg3));
        ProtectedRPNCalculator.solveString(arg4);
        System.out.println(ProtectedRPNCalculator.solveString(arg4));
    }
}
//"Wrong count of numbers and operators"
//"Wrong count of numbers and operators"
//"NaN or not an operator"