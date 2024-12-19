package prac23.task2;



// Инвариант: 0 <= size <= elements.length
// 0 <= head, tail < elements.length

public class ArrayQueueADT {
    private Object[] elements;
    private int size;
    private int head;
    private int tail;

    public ArrayQueueADT() {
        elements = new Object[10];
        size = 0;
        head = 0;
        tail = 0;
    }

    public static void enqueue(ArrayQueueADT queue, Object element) {
        assert element != null : "Элемент не может быть null";
        ensureCapacity(queue, queue.size + 1);
        queue.elements[queue.tail] = element;
        queue.tail = (queue.tail + 1) % queue.elements.length;
        queue.size++;
    }

    public static Object element(ArrayQueueADT queue) {
        assert queue.size > 0 : "Очередь пуста";
        return queue.elements[queue.head];
    }

    public static Object dequeue(ArrayQueueADT queue) {
        assert queue.size > 0 : "Очередь пуста";
        Object result = queue.elements[queue.head];
        queue.elements[queue.head] = null;
        queue.head = (queue.head + 1) % queue.elements.length;
        queue.size--;
        return result;
    }

    public static int size(ArrayQueueADT queue) {
        return queue.size;
    }

    public static boolean isEmpty(ArrayQueueADT queue) {
        return queue.size == 0;
    }

    public static void clear(ArrayQueueADT queue) {
        queue.elements = new Object[10];
        queue.size = 0;
        queue.head = 0;
        queue.tail = 0;
    }

    private static void ensureCapacity(ArrayQueueADT queue, int capacity) {
        if (capacity > queue.elements.length) {
            Object[] newElements = new Object[2 * queue.elements.length];
            for (int i = 0; i < queue.size; i++) {
                newElements[i] = queue.elements[(queue.head + i) % queue.elements.length];
            }
            queue.elements = newElements;
            queue.head = 0;
            queue.tail = queue.size;
        }
    }
}
