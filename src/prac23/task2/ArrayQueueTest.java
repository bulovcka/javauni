package prac23.task2;


public class ArrayQueueTest {
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue();
        queue.enqueue(1);
        queue.enqueue(5);
        queue.enqueue(3);
        System.out.println(queue.element()); // 1
        System.out.println(queue.dequeue()); // 1
        System.out.println(queue.size()); // 2
        System.out.println(queue.element()); //5
        queue.clear();
        System.out.println(queue.isEmpty()); // true
    }
}
