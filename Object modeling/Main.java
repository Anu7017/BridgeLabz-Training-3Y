import java.util.ArrayList;

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}

class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void showBooks() {
        for (Book b : books) {
            System.out.println(b.getTitle() + " by " + b.getAuthor());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Book b1 = new Book("1984", "George Orwell");
        Book b2 = new Book("To Kill a Mockingbird", "Harper Lee");
        Book b3 = new Book("The Great Gatsby", "F. Scott Fitzgerald");

        Library lib1 = new Library();
        Library lib2 = new Library();

        lib1.addBook(b1);
        lib1.addBook(b2);

        lib2.addBook(b2);
        lib2.addBook(b3);

        System.out.println("Library 1 books:");
        lib1.showBooks();

        System.out.println("Library 2 books:");
        lib2.showBooks();
    }
}
