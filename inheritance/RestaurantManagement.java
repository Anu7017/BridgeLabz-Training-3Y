package com.bridgelabz.oops.inheritance;

// Interface
interface Worker {
    void performDuties();
}

// Superclass
class Person {
    protected String name;
    protected int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

// Subclass Chef implementing Worker
class Chef extends Person implements Worker {
    private String specialty;

    public Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is cooking specialty dishes: " + specialty);
    }
}

// Subclass Waiter implementing Worker
class Waiter extends Person implements Worker {
    private String section;

    public Waiter(String name, int id, String section) {
        super(name, id);
        this.section = section;
    }

    @Override
    public void performDuties() {
        System.out.println(name + " is serving customers in section: " + section);
    }
}

// Main class
public class RestaurantManagement {
    public static void main(String[] args) {
        Chef chef1 = new Chef("Gordon", 101, "Italian Cuisine");
        Waiter waiter1 = new Waiter("Alice", 201, "Main Hall");

        chef1.displayInfo();
        chef1.performDuties();
        System.out.println();

        waiter1.displayInfo();
        waiter1.performDuties();
    }
}
