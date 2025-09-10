class Bird {
    public void fly() {
        System.out.println("This bird can fly");
    }
}

class Sparrow extends Bird {
    @Override
    public void fly() {
        System.out.println("Sparrow is flying");
    }
}

public class TestBird {
    public static void makeItFly(Bird bird) {
        bird.fly();
    }

    public static void main(String[] args) {
        Bird bird = new Sparrow(); // LSP holds
        makeItFly(bird);
    }
}
