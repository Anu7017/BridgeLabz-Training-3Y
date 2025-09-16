import java.util.ArrayList;
import java.util.List;

// Abstract Class
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public abstract double calculateTotalPrice();

    public void getItemDetails() {
        System.out.println("Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity);
    }
}

// Interface
interface Discountable {
    double applyDiscount(double percentage);
    String getDiscountDetails();
}

// VegItem Class
class VegItem extends FoodItem implements Discountable {

    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public double applyDiscount(double percentage) {
        double discountAmount = calculateTotalPrice() * percentage / 100;
        setPrice(getPrice() - (discountAmount / getQuantity()));
        return discountAmount;
    }

    @Override
    public String getDiscountDetails() {
        return "Vegetarian items get 10% discount!";
    }
}

// NonVegItem Class
class NonVegItem extends FoodItem implements Discountable {
    private double extraCharge = 50; // e.g., extra charge per item

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() + extraCharge) * getQuantity();
    }

    @Override
    public double applyDiscount(double percentage) {
        double discountAmount = calculateTotalPrice() * percentage / 100;
        setPrice(getPrice() - (discountAmount / getQuantity()));
        return discountAmount;
    }

    @Override
    public String getDiscountDetails() {
        return "Non-Veg items get 5% discount!";
    }
}

// Main Class
public class FoodDeliverySystem {
    public static void main(String[] args) {
        List<FoodItem> order = new ArrayList<>();

        VegItem paneer = new VegItem("Paneer Butter Masala", 200, 2);
        NonVegItem chicken = new NonVegItem("Chicken Biryani", 250, 3);

        order.add(paneer);
        order.add(chicken);

        for (FoodItem item : order) {
            item.getItemDetails();
            System.out.println("Total Price: " + item.calculateTotalPrice());

            if (item instanceof Discountable) {
                Discountable discountItem = (Discountable) item;
                System.out.println(discountItem.getDiscountDetails());
                double discount = discountItem.applyDiscount(item instanceof VegItem ? 10 : 5);
                System.out.println("Discount Applied: " + discount);
                System.out.println("Price after Discount: " + item.calculateTotalPrice());
            }

            System.out.println("-----------------------------");
        }
    }
}
