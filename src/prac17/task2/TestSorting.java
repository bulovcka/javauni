package prac17.task2;



public class TestSorting {
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();

        list.add(6.4);
        list.add(2.5);
        list.add(9.0);
        list.add(1.0);
        list.add(5.2);

        System.out.println("Неотсортированный список:");
        System.out.println(list);

        list.sort();

        System.out.println("Отсортированный список:");
        System.out.println(list);
    }
}
