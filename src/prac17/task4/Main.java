package prac17.task4;


public class Main {
    public static void main(String[] args) {
        SortedLinkedList list = new SortedLinkedList();

        list.add("banana");
        list.add("apple");
        list.add("cherry");
        list.add("date");

        System.out.println("Список после вставки:");
        list.printList();

        list.add("apricot");
        System.out.println("Список после вставки 'apricot':");
        list.printList();
    }
}
