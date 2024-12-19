package prac23.task2;


// реализует очередь как единственный экземпляр через статические переменные
public class ArrayQueueModule {
    private static final int INITIAL_CAPACITY = 10;
    private static Object[] elements = new Object[INITIAL_CAPACITY];
    private static int size = 0;
    private static int head = 0;
    private static int tail = 0;

    // Инвариант: 0 <= size <= elements.length
    // 0 <= head, tail < elements.length

    // enqueue
    public static void enqueue(Object element) {
        assert element != null : "Элемент не может быть null";
        ensureCapacity(size + 1);
        elements[tail] = element;
        tail = (tail + 1) % elements.length;
        size++;
    }

    public static Object element() {
        assert size > 0 : "Очередь пуста";
        return elements[head];
    }

    // dequeue
    public static Object dequeue() {
        assert size > 0 : "Очередь пуста";
        Object result = elements[head];
        elements[head] = null;
        head = (head + 1) % elements.length;
        size--;
        return result;
    }

    public static int size() {
        return size;
    }

    public static boolean isEmpty() {
        return size == 0;
    }

    public static void clear() {
        elements = new Object[INITIAL_CAPACITY];
        size = 0;
        head = 0;
        tail = 0;
    }

    private static void ensureCapacity(int capacity) {
        if (capacity > elements.length) {
            Object[] newElements = new Object[2 * elements.length];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[(head + i) % elements.length];
            }
            elements = newElements;
            head = 0;
            tail = size;
        }
    }
}
