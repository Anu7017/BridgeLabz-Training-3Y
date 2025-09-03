package com.bridgelabz.oops.levelthree;

class Product {
    // Instance variables
    private String productName;
    private double price;

    // Class variable (shared among all objects)
    private static int totalProducts = 0;

    // Constructor
    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++; // increment count when a new product is created
    }

    // Instance method to display product details
    public void displayProductDetails() {
        System.out.println("Product Name: " + productName + ", Price: " + price);
    }

    // Class method to display total products created
    public static void displayTotalProducts() {
        System.out.println("Total Products Created: " + totalProducts);
    }

    // Main method to test
    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 55000);
        Product p2 = new Product("Mobile", 20000);
        Product p3 = new Product("Headphones", 2500);

        // Display product details
        p1.displayProductDetails();
        p2.displayProductDetails();
        p3.displayProductDetails();

        // Display total products
        Product.displayTotalProducts();
    }
}
