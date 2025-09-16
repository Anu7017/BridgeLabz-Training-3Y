import java.util.ArrayList;
import java.util.List;

// Abstract Class
abstract class Product {
    private int productId;
    private String name;
    private double price;

    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract double calculateDiscount();

    public void displayDetails() {
        System.out.println("ID: " + productId + ", Name: " + name + ", Price: " + price);
    }
}

// Interface
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Electronics Class
class Electronics extends Product implements Taxable {
    private double warrantyFee;

    public Electronics(int productId, String name, double price, double warrantyFee) {
        super(productId, name, price);
        this.warrantyFee = warrantyFee;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10; // 10% discount
    }

    @Override
    public double calculateTax() {
        return (getPrice() - calculateDiscount()) * 0.18; // 18% GST
    }

    @Override
    public String getTaxDetails() {
        return "GST (18%) applied on Electronics.";
    }
}

// Clothing Class
class Clothing extends Product implements Taxable {
    private String size;

    public Clothing(int productId, String name, double price, String size) {
        super(productId, name, price);
        this.size = size;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.20; // 20% discount
    }

    @Override
    public double calculateTax() {
        return (getPrice() - calculateDiscount()) * 0.05; // 5% VAT
    }

    @Override
    public String getTaxDetails() {
        return "VAT (5%) applied on Clothing.";
    }
}

// Groceries Class
class Groceries extends Product {
    private double weight;

    public Groceries(int productId, String name, double price, double weight) {
        super(productId, name, price);
        this.weight = weight;
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }
}

// Main Class
public class ECommercePlatform {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        Electronics laptop = new Electronics(101, "Laptop", 60000, 2000);
        Clothing tshirt = new Clothing(102, "T-Shirt", 1500, "L");
        Groceries rice = new Groceries(103, "Rice", 2000, 10);

        products.add(laptop);
        products.add(tshirt);
        products.add(rice);

        for (Product p : products) {
            p.displayDetails();
            double discount = p.calculateDiscount();
            System.out.println("Discount: " + discount);
            double finalPrice = p.getPrice() - discount;

            if (p instanceof Taxable) {
                Taxable t = (Taxable) p;
                double tax = t.calculateTax();
                System.out.println(t.getTaxDetails());
                System.out.println("Tax: " + tax);
                finalPrice += tax;
            }

            System.out.println("Final Price: " + finalPrice);
            System.out.println("-----------------------------");
        }
    }
}
