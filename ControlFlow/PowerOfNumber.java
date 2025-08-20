import java.util.Scanner;

public class PowerOfNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get inputs from user
        System.out.print("Enter the base number: ");
        int number = input.nextInt();

        System.out.print("Enter the power: ");
        int power = input.nextInt();

        // Check for positive integers
        if (number >= 0 && power >= 0) {
            int result = 1;

            // Loop to calculate power
            for (int i = 1; i <= power; i++) {
                result = result * number;
            }

            System.out.println(number + " raised to the power " + power + " is: " + result);
        } else {
            System.out.println("Please enter positive integers for base and power.");
        }

        input.close();
    }
}
