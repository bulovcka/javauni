package prac23.task3;

public abstract class BinaryOperation implements Expression {
    protected final Expression left;  // Левый операнд
    protected final Expression right; // Правый операнд

    public BinaryOperation(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
}
