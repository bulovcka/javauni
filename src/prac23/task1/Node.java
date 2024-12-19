package prac23.task1;

public class Node<E> {
    private E data;
    private Node<E> next;
    Node(E data){
        this.data = data;
        this.next = null;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public E getData() {
        return data;
    }
}
