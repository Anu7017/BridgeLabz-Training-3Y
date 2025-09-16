import java.util.ArrayList;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Order {
    private int orderId;
    private ArrayList<Product> products = new ArrayList<>();
    private Customer customer;

    public Order(int orderId, Customer customer) {
        this.orderId = orderId;
        this.customer = customer;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void showOrderDetails() {
        System.out.println("Order ID: " + orderId + " | Customer: " + customer.getName());
        double total = 0;
        for (Product p : products) {
            System.out.println("- " + p.getName() + " : $" + p.getPrice());
            total += p.getPrice();
        }
        System.out.println("Total: $" + total);
    }
}

class Customer {
    private String name;
    private ArrayList<Order> orders = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void placeOrder(Order order) {
        orders.add(order);
        System.out.println(name + " placed Order ID: " + order.hashCode());
    }

    public void showOrders() {
        System.out.println("Customer: " + name + " | Orders:");
        for (Order o : orders) {
            o.showOrderDetails();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 1200.0);
        Product p2 = new Product("Smartphone", 800.0);
        Product p3 = new Product("Headphones", 150.0);

        Customer c1 = new Customer("Alice");
        Customer c2 = new Customer("Bob");

        Order o1 = new Order(101, c1);
        o1.addProduct(p1);
        o1.addProduct(p3);

        Order o2 = new Order(102, c2);
        o2.addProduct(p2);

        c1.placeOrder(o1);
        c2.placeOrder(o2);

        c1.showOrders();
        c2.showOrders();
    }
}
