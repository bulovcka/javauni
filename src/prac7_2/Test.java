package prac7_2;

import java.util.Formatter;

public class Test {
    public static void main(String[] args){
        Formatter f = new Formatter();
        double r = 10.0;
        System.out.println("Возведение в степень " + MathFunc.pow(2, 0));
        f.format("Модуль коплексного числа %.2f%n", MathFunc.complexAbs(2, -2));
        f.format("Длина окружности %.2f%n", 2 * MathFunc.pi * r);
        System.out.println(f);
    }
}
