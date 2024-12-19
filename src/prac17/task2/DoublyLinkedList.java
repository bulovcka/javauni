package prac17.task2;

// zadanie 2
public class DoublyLinkedList {
    Node head = null;
    Node tail = null;

    public void add(Double data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
        } else {
            tail.setNext(node);
            node.setPrev(tail);
        }
        tail = node;
    }

    public void sort() {
        if (head == null || head == tail) {
            return;
        }
        Node cur = head;
        Node prevMin = null;
        while (cur != null) {
            Node minNode = findMinNode(cur);
            if (minNode != cur) {
                removeNode(minNode);
                insert(minNode, prevMin);
                prevMin = minNode;
            }
            cur = minNode.getNext();
        }
    }

    private Node findMinNode(Node start) {
        Node minNode = start;
        Node curNode = start;
        while (curNode != null) {
            if (curNode.compareTo(minNode) < 0) {
                minNode = curNode;
            }
            curNode = curNode.getNext();
        }
        return minNode;
    }

    private void removeNode(Node node) {
        if (node.getPrev() != null) {
            node.getPrev().setNext(node.getNext());
        } else {
            head = node.getNext();
        }

        if (node.getNext() != null) {
            node.getNext().setPrev(node.getPrev());
        } else {
            tail = node.getPrev();
        }
    }

    private void insert(Node node, Node start) {
        if (start != null){
            node.setNext(start.getNext());
            node.setPrev(start);
            start.setNext(node);
        }
        else {
            if (head == null) {
                head = node;
                tail = node;
            } else {
                node.setNext(head);
                head.setPrev(node);
                head = node;
            }
        }
    }

    @Override
    public String toString() {
        Node current = head;
        StringBuilder out = new StringBuilder("[");
        while (current != null) {
            out.append(current.getData() != null ? current.getData().toString() : "null");
            current = current.getNext();
            if (current != null) {
                out.append(", ");
            }
        }
        out.append("]");
        return "MyDoubleLinkedList{%s}".formatted(out.toString());
    }
}