package prac17.task1;
//zadanie 10

public class LinkedList {
    private Node head; // Голова списка

    public void add(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void moveMaxToFront() {
        if (head == null || head.next == null) {
            return;
        }

        Node maxNode = head;
        Node maxPrev = null;
        Node current = head;
        Node prev = null;

        while (current != null) {
            if (current.data.compareTo(maxNode.data) > 0) {
                maxNode = current;
                maxPrev = prev;
            }
            prev = current;
            current = current.next;
        }

        if (maxNode == head) {
            return;
        }
        if (maxPrev != null) {
            maxPrev.next = maxNode.next; //удаляем макс
        }
        maxNode.next = head; //перемещаем
        head = maxNode;
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