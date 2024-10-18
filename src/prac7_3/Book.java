package prac7_3;

class Book implements Printable {
    String name;
    String author;
    int year;

    public Book(String name, String author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public void print() {
        System.out.printf("Книга '%s' (автор %s) была издана в %d году \n", name, author, year);
    }

    public static void printBooks(Printable[] printables){
        for(Printable printable : printables){
            if (printable instanceof Book){
                Book book = (Book) printable;
                System.out.println(book.getName());
            }
        }
    }

}
