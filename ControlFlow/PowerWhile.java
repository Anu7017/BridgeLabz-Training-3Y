import java.util.Scanner;

public class PowerWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter the number: ");
        int number = input.nextInt();

        System.out.print("Enter the power: ");
        int power = input.nextInt();

        // Initialize result
        int result = 1;
        int counter = 0;

        // While loop till counter == power
        while (counter < power) {
            result = result * number;
            counter++;
        }

        // Display result
        System.out.println(number + " raised to the power " + power + " is: " + result);

        input.close();
    }
}
