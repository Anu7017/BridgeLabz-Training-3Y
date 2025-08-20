import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Step 1: Get input from the user
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Step 2: Initialize variables
        int originalNumber = number;
        int sum = 0;

        // Step 3: Loop through each digit using while
        while (originalNumber != 0) {
            // Get the last digit
            int digit = originalNumber % 10;

            // Add cube of the digit to sum
            sum = sum + (digit * digit * digit);

            // Remove the last digit
            originalNumber = originalNumber / 10;
        }

        // Step 4: Check Armstrong condition
        if (sum == number) {
            System.out.println(number + " is an Armstrong Number.");
        } else {
            System.out.println(number + " is NOT an Armstrong Number.");
        }

        input.close();
    }
}
