package prac23.task2;

public class ArrayQueueADTTest {
    public static void main(String[] args) {
        ArrayQueueADT queue = new ArrayQueueADT();
        ArrayQueueADT.enqueue(queue,1);
        ArrayQueueADT.enqueue(queue,5);
        ArrayQueueADT.enqueue(queue,3);
        System.out.println(ArrayQueueADT.element(queue)); // 1
        System.out.println(ArrayQueueADT.dequeue(queue)); // 1
        System.out.println(ArrayQueueADT.size(queue)); // 2
        System.out.println(ArrayQueueADT.element(queue)); //5
        ArrayQueueADT.clear(queue);
        System.out.println(ArrayQueueADT.isEmpty(queue)); // true
    }
}
