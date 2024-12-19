package prac24.task1;


public class Complex {
    private int real, im;
    public Complex(int real, int im) {
        this.real = real;
        this.im = im;
    }

    @Override
    public String toString() {
        return "Complex = %d + %dj".formatted(real, im);
    }
}