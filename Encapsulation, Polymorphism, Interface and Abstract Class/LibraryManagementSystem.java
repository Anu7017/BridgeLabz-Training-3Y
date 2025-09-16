import java.util.ArrayList;
import java.util.List;

// Abstract Class
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    private String borrower; // sensitive info (encapsulation)

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.borrower = null; // initially no borrower
    }

    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // Encapsulation for borrower
    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public abstract int getLoanDuration();

    public void getItemDetails() {
        System.out.println("ID: " + itemId + ", Title: " + title + ", Author: " + author);
    }
}

// Interface
interface Reservable {
    void reserveItem(String borrowerName);
    String checkAvailability();
}

// Book Class
class Book extends LibraryItem implements Reservable {
    private boolean reserved;

    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
        this.reserved = false;
    }

    @Override
    public int getLoanDuration() {
        return 21; // 21 days
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (!reserved) {
            reserved = true;
            setBorrower(borrowerName);
            System.out.println("Book reserved by " + borrowerName);
        } else {
            System.out.println("Book is already reserved.");
        }
    }

    @Override
    public String checkAvailability() {
        return reserved ? "Not Available" : "Available";
    }
}

// Magazine Class
class Magazine extends LibraryItem implements Reservable {
    private boolean reserved;

    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
        this.reserved = false;
    }

    @Override
    public int getLoanDuration() {
        return 7; // 1 week
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (!reserved) {
            reserved = true;
            setBorrower(borrowerName);
            System.out.println("Magazine reserved by " + borrowerName);
        } else {
            System.out.println("Magazine is already reserved.");
        }
    }

    @Override
    public String checkAvailability() {
        return reserved ? "Not Available" : "Available";
    }
}

// DVD Class
class DVD extends LibraryItem implements Reservable {
    private boolean reserved;

    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
        this.reserved = false;
    }

    @Override
    public int getLoanDuration() {
        return 3; // 3 days
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (!reserved) {
            reserved = true;
            setBorrower(borrowerName);
            System.out.println("DVD reserved by " + borrowerName);
        } else {
            System.out.println("DVD is already reserved.");
        }
    }

    @Override
    public String checkAvailability() {
        return reserved ? "Not Available" : "Available";
    }
}

// Main Class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();

        Book book1 = new Book("B001", "Java Programming", "James Gosling");
        Magazine mag1 = new Magazine("M101", "Tech World", "Editorial Team");
        DVD dvd1 = new DVD("D202", "Inception", "Christopher Nolan");

        items.add(book1);
        items.add(mag1);
        items.add(dvd1);

        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            if (item instanceof Reservable) {
                Reservable r = (Reservable) item;
                System.out.println("Availability: " + r.checkAvailability());
                r.reserveItem("Alice");
                System.out.println("Availability after res
