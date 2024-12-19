package prac17.task1;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.add("banana");
        list.add("apple");
        list.add("cherry");
        list.add("date");
        list.add("hay");

        System.out.println("Исходный список:");
        list.printList();

        list.moveMaxToFront();

        System.out.println("Список после перемещения максимального элемента в начало:");
        list.printList();
    }
}