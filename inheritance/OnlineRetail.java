package com.bridgelabz.oops.inheritance;

import java.time.LocalDate;

// Base class
class Order {
    protected String orderId;
    protected LocalDate orderDate;

    public Order(String orderId, LocalDate orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public void getOrderStatus() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Status: Order Placed");
    }
}

// Subclass
class ShippedOrder extends Order {
    protected String trackingNumber;

    public ShippedOrder(String orderId, LocalDate orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    public void getOrderStatus() {
        super.getOrderStatus();
        System.out.println("Tracking Number: " + trackingNumber);
        System.out.println("Status: Shipped");
    }
}

// Subclass extending ShippedOrder
class DeliveredOrder extends ShippedOrder {
    private LocalDate deliveryDate;

    public DeliveredOrder(String orderId, LocalDate orderDate, String trackingNumber, LocalDate deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    public void getOrderStatus() {
        super.getOrderStatus();
        System.out.println("Delivery Date: " + deliveryDate);
        System.out.println("Status: Delivered");
    }
}

// Main class
public class OnlineRetail {
    public static void main(String[] args) {
        Order order1 = new Order("ORD101", LocalDate.of(2025, 9, 10));
        ShippedOrder order2 = new ShippedOrder("ORD102", LocalDate.of(2025, 9, 9), "TRK12345");
        DeliveredOrder order3 = new DeliveredOrder("ORD103", LocalDate.of(2025, 9, 8), "TRK67890", LocalDate.of(2025, 9, 10));

        order1.getOrderStatus();
        System.out.println();
        order2.getOrderStatus();
        System.out.println();
        order3.getOrderStatus();
    }
}
