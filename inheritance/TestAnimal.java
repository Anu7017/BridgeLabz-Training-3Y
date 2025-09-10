class Animal {
    public void makeSound() {
        System.out.println("Some generic animal sound");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() { // Correctly overriding
        System.out.println("Bark");
    }
}

public class TestAnimal {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.makeSound(); // Output: Bark
    }
}
