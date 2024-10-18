package prac7_2;

public interface MathCalculable {
    double pi = 3.14;

    static double pow(double x, double y) {
        return Math.pow(x, y);
    }

    static double complexAbs(int x , int y){
        return MathCalculable.pow(x * x + y * y, 0.5);
    }
}
