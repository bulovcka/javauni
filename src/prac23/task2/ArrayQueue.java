package prac23.task2;



// Инвариант: 0 <= size <= elements.length
// 0 <= head, tail < elements.length

public class ArrayQueue {
    private Object[] elements;
    private int size;
    private int head;
    private int tail;

    public ArrayQueue() {
        elements = new Object[10];
        size = 0;
        head = 0;
        tail = 0;
    }

    public void enqueue(Object element) {
        assert element != null : "Элемент не может быть null";
        ensureCapacity(size + 1);
        elements[tail] = element;
        tail = (tail + 1) % elements.length;
        size++;
    }

    public Object element() {
        assert size > 0 : "Очередь пуста";
        return elements[head];
    }

    public Object dequeue() {
        assert size > 0 : "Очередь пуста";
        Object result = elements[head];
        elements[head] = null;
        head = (head + 1) % elements.length;
        size--;
        return result;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        elements = new Object[10];
        size = 0;
        head = 0;
        tail = 0;
    }

    private void ensureCapacity(int capacity) {
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

