class Animal {
    public void makeSound() {
        System.out.println("Some animal sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() { // Overriding
        System.out.println("Bark");
    }

    public void makeSound(String mood) { // Overloading
        System.out.println("Bark when " + mood);
    }
}

public class TestAnimal {
    public static void main(String[] args) {
        Animal a = new Dog();
        a.makeSound();          // Output: Bark
        // a.makeSound("happy"); // ❌ Compile-time error: method not in Animal
    }
}
