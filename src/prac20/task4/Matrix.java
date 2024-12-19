package prac20.task4;


public class Matrix<T extends Number> {
    private T[][] data;

    public Matrix(T[][] data) {
        this.data = data;
    }

    public Matrix<T> add(Matrix<T> other) {
        int rows = data.length;
        int cols = data[0].length;

        Number[][] result = new Number[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = data[i][j].doubleValue() + other.data[i][j].doubleValue();
            }
        }
        return new Matrix(result);
    }

    public Matrix<T> subtract(Matrix<T> other) {
        int rows = data.length;
        int cols = data[0].length;

        Number[][] result = new Number[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = data[i][j].doubleValue() - other.data[i][j].doubleValue();
            }
        }
        return new Matrix(result);
    }

    public void printMatrix() {
        for (T[] row : data) {
            for (T element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Double[][] data1 = {{1.5, 2.1},
                {3.0, 4.5}};
        Double[][] data2 = {{5.0, 6.2},
                {2.0, 8.0}};

        Matrix<Double> matrix1 = new Matrix<>(data1);
        Matrix<Double> matrix2 = new Matrix<>(data2);

        System.out.println("Сложение матриц\n");
        Matrix<Double> sumMatrix = matrix1.add(matrix2);
        sumMatrix.printMatrix();

        Matrix<Double> diffMatrix = matrix1.subtract(matrix2);
        System.out.println("\nВычитание матриц\n");
        diffMatrix.printMatrix();
    }
}