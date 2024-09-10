import java.util.Scanner;
import java.util.Arrays;

public class book2 {
    @Override
    public String toString() {
        return "book2{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", date=" + date +
                '}';
    }

    private String title;
    private String author;
    private int date;
    public book2(String title, String author, int date){
        this.title = title;
        this.author = author;
        this.date = date;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public int getDate(){
        return date;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setAuthor(String author){
        this.author = author;
    }
    public void setDate(int date){
        this.date = date;
    }
}
class Booktest2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bookshelf2 bookshelf2 = new Bookshelf2(3);
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter author: ");
            String author = sc.nextLine();
            System.out.println("Enter title: ");
            String title = sc.nextLine();
            System.out.println("Enter date: ");
            int date = sc.nextInt();
            sc.nextLine();

            book2 newbook = new book2(title, author, date);
            bookshelf2.add(newbook, i);
        }
        System.out.println("Books on shelf");
        bookshelf2.displayBooks2();
        System.out.println("Sorted books");
        bookshelf2.displayByDate();
    }
}
class Bookshelf2{
    private book2[] books;
    private int size;

    public Bookshelf2(int size){
        this.size = size;
        this.books = new book2[size];
    }

    public void add(book2 book, int index){
        if (index < 0 || index >= size){
            System.out.println("invalid index");
        }else {
            books[index] = book;
        }
    }

    public void displayBooks2(){
        for (book2 book : books){
            if (book != null){
                System.out.println(book.getTitle());
            }
        }
    }

    public void displayByDate(){
        for (int i  = 0;i < books.length - 1; i++){
            for (int j = i + 1;j < books.length;j++ ){
                if (books[i] != null && books[j] != null && books[i].getDate() > books[j].getDate()){
                    book2 temp = books[i];
                    books[i] = books[j];
                    books[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(books));
    }
}
