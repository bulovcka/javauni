package prac22;

import java.util.Scanner;
import java.util.Stack;

public class RPNCalculator {
    static Stack<Double> stack = new Stack<>();
    static Scanner scanner = new Scanner(System.in);
    static String next;
    static Double firstOp, secondOp;

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }

    public static void main(String[] args) {
        System.out.println("Введите арифметическое выражение в обратной польской нотации. Введите '=' для завершения вычисления.");
        while (true) {
            next = scanner.next();
            if (next.equals("=")) {
                break;
            }
            if (isNumeric(next)) {
                stack.add(Double.parseDouble(next));
            } else {
                if (stack.size() < 2) {
                    System.out.println("Недостаточно операндов для операции: " + next);
                    continue;
                }
                secondOp = stack.pop();
                firstOp = stack.pop();
                switch (next) {
                    case "+" -> stack.push(firstOp + secondOp);
                    case "-" -> stack.push(firstOp - secondOp);
                    case "*" -> stack.push(firstOp * secondOp);
                    case "/" -> {
                        if (secondOp != 0) {
                            stack.push(firstOp / secondOp);
                        } else {
                            System.out.println("Ошибка: деление на ноль.");
                            stack.push(firstOp); // Возвращаем операнды в стек
                            stack.push(secondOp);
                        }
                    }
                    default -> System.out.println("Неизвестная операция: " + next);
                }
            }
        }
        if (stack.size() == 1) {
            System.out.println("Результат: " + stack.pop());
        } else {
            System.out.println("Ошибка: неверное выражение.");
        }
    }
}
