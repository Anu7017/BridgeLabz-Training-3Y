class Vehicle {
    void start() {
        System.out.println("Vehicle started");
    }
}

class Car extends Vehicle { // Car "is-a" Vehicle
    void drive() {
        System.out.println("Car is driving");
    }
}

public class TestVehicle {
    public static void main(String[] args) {
        Car car = new Car();
        car.start(); // inherited from Vehicle
        car.drive();
    }
}
