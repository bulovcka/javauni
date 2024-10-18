package prac7_2;

public class MathFunc implements MathCalculable {
    public static double pow(double x, double y) {
        return MathCalculable.pow(x, y);
    }
    public static double complexAbs(int x , int y){
        return MathFunc.pow(x * x + y * y, 0.5);
    }
}
