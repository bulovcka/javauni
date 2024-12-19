package prac23.task1;


public class LinkedQueue<E> extends AbstractQueue<E>{
    Node<E> head = null;
    @Override
    public void enqueue(E data) {
        Node<E> cur = head;
        if(cur == null){
            head = new Node<>(data);
        } else {
            while (cur.getNext() != null){
                cur = cur.getNext();
            }
            cur.setNext(new Node<>(data));
        }
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty()){
            System.out.println("LinkedQueue.dequeue() -> LinkedQueue is empty!");
            return null;
        } else {
            E ans = head.getData();
            head = head.getNext();
            size--;
            return ans;
        }
    }

    @Override
    public E element() {
        if (isEmpty()){
            System.out.println("LinkedQueue.element() -> LinkedQueue is empty!");
            return null;
        }
        return head.getData();
    }


    @Override
    public void clear() {
        size = 0;
        head = null;
    }

    @Override
    public void display() {
        if (isEmpty()){
            System.out.println("LinkedQueue.display() -> LinkedQueue is empty!");
        } else {
            Node<E> cur = head;
            System.out.print("Items -> ");
            while (cur != null){
                System.out.print(cur.getData().toString() + " ");
                cur = cur.getNext();
            }
            System.out.println();
        }
    }
}
