class Vehicle {
    public int speed; // Public field, unsafe
}

class Car extends Vehicle {
    void accelerate() {
        speed += 10; // Direct access, no control
    }
}
