package prac23.task2;


public class ArrayQueueModuleTest {
    public static void main(String[] args) {
        ArrayQueueModule queue = new ArrayQueueModule();
        ArrayQueueModule.enqueue(1);
        ArrayQueueModule.enqueue(5);
        ArrayQueueModule.enqueue(3);
        System.out.println(ArrayQueueModule.element()); // 1
        System.out.println(ArrayQueueModule.dequeue()); // 1
        System.out.println(ArrayQueueModule.size()); // 2
        System.out.println(ArrayQueueModule.element()); //5
        ArrayQueueModule.clear();
        System.out.println(ArrayQueueModule.isEmpty()); // true
    }
}
