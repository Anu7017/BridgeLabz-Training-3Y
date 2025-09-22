import java.util.*;

// Custom Exception
class InvalidBookFormatException extends Exception {
    public InvalidBookFormatException(String message) {
        super(message);
    }
}

// BookBuddy Class
class BookBuddy {
    private ArrayList<String> bookshelf;

    public BookBuddy() {
        bookshelf = new ArrayList<>();
    }

    // Add Book in "Title - Author" format
    public void addBook(String title, String author) throws InvalidBookFormatException {
        if (title == null || author == null || title.trim().isEmpty() || author.trim().isEmpty()) {
            throw new InvalidBookFormatException("❌ Invalid format! Book must be in 'Title - Author' format.");
        }
        bookshelf.add(title.trim() + " - " + author.trim());
        System.out.println("✅ Book added: " + title + " - " + author);
    }

    // Sort books alphabetically by title
    public void sortBooksAlphabetically() {
        try {
            if (bookshelf.isEmpty()) throw new Exception("❌ Bookshelf is empty. Nothing to sort.");
            Collections.sort(bookshelf);
            System.out.println("📚 Books sorted alphabetically by title.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Search by Author
    public void searchByAuthor(String author) {
        try {
            if (bookshelf.isEmpty()) throw new Exception("❌ Bookshelf is empty. Cannot search.");
            System.out.println("🔍 Books by author: " + author);
            boolean found = false;
            for (String book : bookshelf) {
                String[] parts = book.split(" - ");
                if (parts.length == 2 && parts[1].equalsIgnoreCase(author)) {
                    System.out.println("📖 " + book);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("❌ No books found by " + author);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Export as array
    public String[] exportAsArray() {
        try {
            if (bookshelf.isEmpty()) throw new Exception("❌ Bookshelf is empty. Cannot export.");
            String[] bookArray = new String[bookshelf.size()];
            return bookshelf.toArray(bookArray);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new String[0];
        }
    }

    // Display all books
    public void displayBooks() {
        try {
            if (bookshelf.isEmpty()) throw new Exception("❌ Bookshelf is empty.");
            System.out.println("📚 Your Digital Bookshelf:");
            for (String book : bookshelf) {
                System.out.println("   " + book);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

// Main Class
public class BookBuddyApp {
    public static void main(String[] args) {
        BookBuddy buddy = new BookBuddy();

        try {
            // Adding books
            buddy.addBook("The Hobbit", "J.R.R. Tolkien");
            buddy.addBook("Clean Code", "Robert C. Martin");
            buddy.addBook("Java Programming", "James Gosling");

            // Display books
            buddy.displayBooks();

            // Sort books
            buddy.sortBooksAlphabetically();
            buddy.displayBooks();

            // Search by Author
            buddy.searchByAuthor("Robert C. Martin");
            buddy.searchByAuthor("Guido van Rossum"); // Not found case

            // Export to Array
            System.out.println("\n📦 Exporting bookshelf as array:");
            String[] exportedBooks = buddy.exportAsArray();
            for (String b : exportedBooks) {
                System.out.println("   " + b);
            }

            // Uncomment to test invalid format
            // buddy.addBook("", "");

        } catch (InvalidBookFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}
