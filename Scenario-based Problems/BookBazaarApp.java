import java.util.*;

// Interface for discountable items
interface IDiscountable {
    double applyDiscount();
}

// ------------------- Book Base Class -------------------
abstract class Book implements IDiscountable {
    private String title;
    private String author;
    protected double price;
    private int stock;

    // Constructor
    public Book(String title, String author, double price, int stock) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.stock = stock;
    }

    // Encapsulation: stock updated only through methods
    public boolean reduceStock(int qty) {
        if (qty <= stock) {
            stock -= qty;
            return true;
        }
        return false;
    }

    public void increaseStock(int qty) {
        stock += qty;
    }

    public int getStock() { return stock; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public double getPrice() { return price; }

    // Abstract discount method (will be overridden)
    public abstract double applyDiscount();

    public void display() {
        System.out.println("📖 " + title + " by " + author +
                " | Price: " + price + " | Stock: " + stock);
    }
}

// ------------------- EBook Subclass -------------------
class EBook extends Book {
    public EBook(String title, String author, double price, int stock) {
        super(title, author, price, stock);
    }

    @Override
    public double applyDiscount() {
        return price * 0.90; // 10% discount
    }
}

// ------------------- PrintedBook Subclass -------------------
class PrintedBook extends Book {
    public PrintedBook(String title, String author, double price, int stock) {
        super(title, author, price, stock);
    }

    @Override
    public double applyDiscount() {
        return price * 0.85; // 15% discount
    }
}

// ------------------- Order Class -------------------
class Order {
    private String userName;
    private Map<Book, Integer> items; // Book -> Quantity
    private String status; // Access restricted

    public Order(String userName) {
        this.userName = userName;
        this.items = new HashMap<>();
        this.status = "Pending"; // Default
    }

    // Add book to order
    public void addBook(Book book, int qty) {
        if (book.reduceStock(qty)) {
            items.put(book, items.getOrDefault(book, 0) + qty);
            System.out.println("✅ Added " + qty + " x " + book.getTitle() + " to " + userName + "'s order.");
        } else {
            System.out.println("❌ Not enough stock for " + book.getTitle());
        }
    }

    // Compute total cost (price × qty – discount)
    public double computeTotal() {
        double total = 0;
        for (Map.Entry<Book, Integer> entry : items.entrySet()) {
            Book book = entry.getKey();
            int qty = entry.getValue();
            double discountedPrice = book.applyDiscount();
            total += discountedPrice * qty;
        }
        return total;
    }

    // Encapsulation: Only internal methods can update status
    private void setStatus(String status) {
        this.status = status;
    }

    public void confirmOrder() {
        setStatus("Confirmed");
        System.out.println("🛒 Order confirmed for " + userName);
    }

    public void cancelOrder() {
        setStatus("Cancelled");
        System.out.println("❌ Order cancelled for " + userName);
    }

    public void displayOrder() {
        System.out.println("\n📦 Order Summary for " + userName + ":");
        for (Map.Entry<Book, Integer> entry : items.entrySet()) {
            Book book = entry.getKey();
            int qty = entry.getValue();
            System.out.println("   " + book.getTitle() + " x " + qty + " @ " + book.applyDiscount() + " each");
        }
        System.out.println("Total Cost: " + computeTotal());
        System.out.println("Order Status: " + status);
    }
}

// ------------------- Main Class -------------------
public class BookBazaarApp {
    public static void main(String[] args) {
        // Create inventory
        Book ebook1 = new EBook("Java Programming", "James Gosling", 500, 10);
        Book ebook2 = new EBook("Python Basics", "Guido van Rossum", 400, 8);
        Book printed1 = new PrintedBook("Clean Code", "Robert C. Martin", 700, 5);
        Book printed2 = new PrintedBook("The Hobbit", "J.R.R. Tolkien", 600, 3);

        List<Book> inventory = new ArrayList<>();
        inventory.add(ebook1);
        inventory.add(ebook2);
        inventory.add(printed1);
        inventory.add(printed2);

        System.out.println("📚 Available Books:");
        for (Book b : inventory) {
            b.display();
        }

        // Create Order
        Order order1 = new Order("Alice");
        order1.addBook(ebook1, 2);
        order1.addBook(printed1, 1);

        order1.displayOrder();
        order1.confirmOrder();

        // Another order
        Order order2 = new Order("Bob");
        order2.addBook(printed2, 4); // exceeds stock
        order2.addBook(ebook2, 2);

        order2.displayOrder();
        order2.cancelOrder();
    }
}
