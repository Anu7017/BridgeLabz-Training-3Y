class Engine {
    void start() {
        System.out.println("Engine started");
    }
}

class Car extends Engine { // Car "is-a" Engine? Not really!
    void drive() {
        System.out.println("Car is driving");
    }
}

public class TestCar {
    public static void main(String[] args) {
        Car car = new Car();
        car.start();
        car.drive();
    }
}
