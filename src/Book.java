import java.util.Arrays;
import java.util.Date;

public class Book {
    @Override // перегрузка
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", date=" + date +
                ", author='" + author + '\'' +
                '}';
    }

    private String title;
    private Date date;
    private String author;

    public Book() {
    }

    public Book(String title, Date date, String author) {
        this.title = title;
        this.date = date;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate(){
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

class BookTest{
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(5);
        bookShelf.generateRandomBooks(5);
        bookShelf.displayBooks();
        System.out.println();
        System.out.println();
        System.out.println();
        bookShelf.displayBooksByDate();
    }
}

class BookShelf{
    private Book[] books;
    private int size;

    public BookShelf(int size) {
        this.size = size;
        this.books = new Book[size];
    }

    public void addBook(Book book, int index){
        if(index < 0 || index >= size){
            System.out.println("Invalid index");
            return;
        }
        books[index] = book;
    } // c

    public Book getBook(int index){
        if(index < 0 || index >= size){
            System.out.println("Invalid index");
            return null;
        }
        return books[index];
    } // r

    public void displayBooks(){
        for (Book book : books) {
            if(book != null){
                System.out.println(book.getTitle());
            }
        }
    } // r
    public void displayBooksByDate(){
        for (int i = 0; i < books.length; i++) {
            for(int j = i + 1; j < books.length; j++){
                if(books == null){
                    return;
                }
                if(books[i] != null && books[j] != null){
                    if(books[i].getDate().after(books[j].getDate())){
                        Book temp = books[i];
                        books[i] = books[j];
                        books[j] = temp;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(books));
    }
    public void generateRandomBooks(int i){
        for (int j = 0; j < i; j++) {
            Book book = new Book("Book" + j, new Date(), "Author" + j);
            addBook(book, j);
        }
    }
}