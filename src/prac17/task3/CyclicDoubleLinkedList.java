package prac17.task3;


public class CyclicDoubleLinkedList {
    private Node head = null;

    public void add(String data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            head.setNext(head);
            head.setPrev(head);
            return;
        }

        // find pos
        Node current = head;
        do {
            if (shouldInsertBefore(current, newNode)) {
                insertBefore(current, newNode);
                if (current == head && shouldInsertBefore(current, newNode)) {
                    head = newNode;
                }
                return;
            }
            current = current.getNext();
        } while (current != head);
        //else
        insertBefore(head, newNode);
    }

    private boolean shouldInsertBefore(Node current, Node newNode) {
        String currentData = current.getData();
        String newData = newNode.getData();

        // length
        if (newData.length() < currentData.length()) {
            return true;
        } else if (newData.length() == currentData.length()) {
            // ALPHABET
            return newData.compareTo(currentData) < 0;
        }
        return false;
    }

    private void insertBefore(Node current, Node newNode) {
        Node prevNode = current.getPrev();

        newNode.setNext(current);
        newNode.setPrev(prevNode);
        prevNode.setNext(newNode);
        current.setPrev(newNode);
    }

    public void view() {
        if (head == null) {
            System.out.println("Список пуст.");
            return;
        }

        Node current = head;
        do {
            System.out.println(current.getData());
            current = current.getNext();
        } while (current != head);
    }

    @Override
    public String toString() {
        if (head == null) {
            return "CyclicDoubleLinkedList{[]}";
        }

        StringBuilder result = new StringBuilder("CyclicDoubleLinkedList{[");
        Node current = head;
        do {
            result.append(current.getData());
            current = current.getNext();
            if (current != head) {
                result.append(", ");
            }
        } while (current != head);
        result.append("]}");
        return result.toString();
    }
}