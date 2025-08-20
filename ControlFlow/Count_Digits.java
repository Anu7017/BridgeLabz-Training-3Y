import java.util.Scanner;

public class CountDigits {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Step 1: Get integer input
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Handle negative numbers by converting to positive
        number = Math.abs(number);

        // Special case: if number is 0, it has 1 digit
        if (number == 0) {
            System.out.println("The number of digits = 1");
            return;
        }

        // Step 2: Initialize count
        int count = 0;

        // Step 3: Loop until number becomes 0
        while (number != 0) {
            number = number / 10;  // Remove last digit
            count++;               // Increment count
        }

        // Step 4: Display result
        System.out.println("The number of digits = " + count);

        input.close();
    }
}
