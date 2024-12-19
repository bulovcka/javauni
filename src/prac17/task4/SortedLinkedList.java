package prac17.task4;


public class SortedLinkedList {
    private Node head;

    public SortedLinkedList() {
        this.head = null;
    }

    public void add(String newData) {
        Node newNode = new Node(new String(newData));
        if (head == null || head.data.compareTo(newData) > 0) {
            newNode.next = head;
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null && current.next.data.compareTo(newData) < 0) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
}