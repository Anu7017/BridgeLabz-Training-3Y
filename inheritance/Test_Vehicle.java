abstract class Vehicle {
    protected String brand;

    public Vehicle(String brand) {
        this.brand = brand;
    }

    public void start() {  // Concrete method
        System.out.println(brand + " is starting");
    }

    public abstract void fuelType(); // Abstract method (must be implemented by subclasses)
}

class Car extends Vehicle {
    public Car(String brand) {
        super(brand);
    }

    @Override
    public void fuelType() {
        System.out.println("Car uses petrol or diesel");
    }
}

class ElectricCar extends Vehicle {
    public ElectricCar(String brand) {
        super(brand);
    }

    @Override
    public void fuelType() {
        System.out.println("Electric car uses electricity");
    }
}

public class TestVehicle {
    public static void main(String[] args) {
        Vehicle v1 = new Car("Toyota");
        Vehicle v2 = new ElectricCar("Tesla");

        v1.start();        // Output: Toyota is starting
        v1.fuelType();     // Output: Car uses petrol or diesel

        v2.start();        // Output: Tesla is starting
        v2.fuelType();     // Output: Electric car uses electricity
    }
}
