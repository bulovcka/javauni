package prac21.task3;

public class ArrayUtils {
    public static <T> T getElementAtIndex(Object[] array, int index) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        return (T) array[index];
    }
    public static void main(String[] args) {
        Integer[] intArray = {1, 2, 3, 4, 5};
        Integer number = getElementAtIndex(intArray, 2);  // Должен вернуть 3
        System.out.println("Element at index 2: " + number);

        String[] stringArray = {"apple", "banana", "cherry"};
        String str = getElementAtIndex(stringArray, 1);  // Должен вернуть "banana"
        System.out.println("Element at index 1: " + str);
    }
}
