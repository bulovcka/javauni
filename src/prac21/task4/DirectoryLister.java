package prac21.task4;

import java.util.ArrayList;
import java.util.List;

public class DirectoryLister {
    public static void listItems() {
        List<?> items = new ArrayList<>();

        // Мы добавляем элементы с конкретным типом
        ((ArrayList<String>)items).add("Australia");
        ((ArrayList<String>)items).add("China");
        ((ArrayList<String>)items).add("England");
        ((ArrayList<String>)items).add("Russia");
        ((ArrayList<String>)items).add("Germany");

        // Теперь мы хотим вывести элементы
        System.out.println("Первые 5 элементов:");

        // Преобразуем обратно в ArrayList<String> (например, через приведение)
        for (int i = 0; i < Math.min(5, items.size()); i++) {
            System.out.println(((ArrayList<String>) items).get(i));
        }
    }

    public static void main(String[] args) {
        // Вызов метода для вывода элементов из списка
        listItems();
    }
}
