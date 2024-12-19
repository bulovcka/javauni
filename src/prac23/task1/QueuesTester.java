package prac23.task1;

public class QueuesTester {
    public static void main(String[] args) {
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        LinkedQueue<Integer> linkedQueue = new LinkedQueue<>();
        System.out.println("ARRAY QUEUE TEST");
        testQueue(arrayQueue);
        System.out.println("LINKED QUEUE TEST");
        testQueue(linkedQueue);

    }

    public static void testQueue(Queue<Integer> queue){
        for (int i = 0; i < 15; i++){
            queue.enqueue(i);
        }
        queue.display();
        for (int i = 0; i < 16; i++){
            queue.dequeue();
        }
        queue.display();
    }
}
