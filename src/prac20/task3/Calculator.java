package prac20.task3;

public class Calculator {
    public static <T extends Number, V extends Number> double sum(T a, V b) {
        return a.doubleValue() + b.doubleValue();
    }

    public static <T extends Number, V extends Number> double multiply(T a, V b) {
        return a.doubleValue() * b.doubleValue();
    }

    public static <T extends Number, V extends Number> double divide(T a, V b) {
        if (b.doubleValue() == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a.doubleValue() / b.doubleValue();
    }

    public static <T extends Number, V extends Number> double subtraction(T a, V b) {
        return a.doubleValue() - b.doubleValue();
    }

    public static void main(String[] args) {
        System.out.println("Sum: " + Calculator.sum(5, 3.2));
        System.out.println("Multiply: " + Calculator.multiply(5, 3.2));
        System.out.println("Divide: " + Calculator.divide(5, 2));
        System.out.println("Subtraction: " + Calculator.subtraction(5, 3));
    }
}