package prac7_3;

public class Test {
    public static void main(String[] args){
        Printable[] printables = {
                new Book("Book 1", "Author 1", 2001),
                new Book("Book 2", "Author 2", 2005),
                new Journal("Magazine 1"),  // Предположим, что есть класс Magazine
                new Journal("Magazine 2")
        };

        Book.printBooks(printables);
    }
}
