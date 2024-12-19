package prac23.task3;


public class Variable implements Expression {
    private final String name;

    public Variable(String name) {
        this.name = name;
    }

    @Override
    public double evaluate(double x) {
        return x; // Всегда возвращает значение переданного параметра
    }
}
