import java.util.Scanner;

public class RocketLaunch {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int counter = input.nextInt();

        while (counter >= 1) {
            System.out.println(counter);
            counter--;
        }

        System.out.println("Liftoff!");

        input.close();
    }
}
