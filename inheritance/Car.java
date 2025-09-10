class Engine {
    void start() { System.out.println("Engine started"); }
}

class Car {
    private Engine engine; // Composition
    public Car(Engine engine) { this.engine = engine; }
    void drive() {
        engine.start();
        System.out.println("Car is driving");
    }
}
