package prac17.task3;

// zadanie 6

public class Main {
    public static void main(String[] args) {
        CyclicDoubleLinkedList list = new CyclicDoubleLinkedList();

        list.add("apple");
        list.add("banana");
        list.add("pear");
        list.add("kiwi");
        list.add("orange");
        list.add("grape");

        System.out.println("Содержимое списка:");
        list.view();

        System.out.println("\nСписок в строковом представлении:");
        System.out.println(list);
    }
}
