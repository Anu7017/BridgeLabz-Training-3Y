import java.util.*;

// Custom Exception
class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String message) {
        super(message);
    }
}

// Book Class
class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    // Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true; // default available
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return isAvailable; }

    // Checkout a book
    public void checkout() throws BookNotAvailableException {
        if (!isAvailable) {
            throw new BookNotAvailableException("❌ The book \"" + title + "\" is already checked out!");
        }
        isAvailable = false;
    }

    // Return a book
    public void returnBook() {
        isAvailable = true;
    }

    // Display book details
    public void display() {
        System.out.println("Title: " + title + " | Author: " + author +
                " | Status: " + (isAvailable ? "Available ✅" : "Checked Out ❌"));
    }
}

// Library Class
class Library {
    private List<Book> books;

    // Constructor (accepts array but stores in a List)
    public Library(Book[] bookArray) {
        this.books = new ArrayList<>(Arrays.asList(bookArray));
    }

    // Search by partial title
    public List<Book> searchByTitle(String keyword) {
        List<Book> results = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(book);
            }
        }
        return results;
    }

    // Display all books
    public void displayBooks() {
        for (Book book : books) {
            book.display();
        }
    }
}

// Main Class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        // Store book data in an Array
        Book[] bookArray = {
            new Book("Java Programming", "James Gosling"),
            new Book("Python Basics", "Guido van Rossum"),
            new Book("C++ Fundamentals", "Bjarne Stroustrup"),
            new Book("Effective Java", "Joshua Bloch")
        };

        Library library = new Library(bookArray);

        // Display all books
        System.out.println("📚 All Books in Library:");
        library.displayBooks();

        // Search by partial title
        System.out.println("\n🔍 Searching for 'Java':");
        List<Book> searchResults = library.searchByTitle("Java");
        for (Book book : searchResults) {
            book.display();
        }

        // Checkout a book
        System.out.println("\n➡️ Checking out 'Java Programming':");
        try {
            searchResults.get(0).checkout();
            searchResults.get(0).display();
        } catch (BookNotAvailableException e) {
            System.out.println(e.getMessage());
        }

        // Try checkout again (should throw exception)
        System.out.println("\n➡️ Trying to checkout again:");
        try {
            searchResults.get(0).checkout();
        } catch (BookNotAvailableException e) {
            System.out.println(e.getMessage());
        }

        // Return the book
        System.out.println("\n↩️ Returning 'Java Programming':");
        searchResults.get(0).returnBook();
        searchResults.get(0).display();
    }
}
