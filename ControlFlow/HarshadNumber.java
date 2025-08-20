import java.util.Scanner;

public class HarshadNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Step 1: Take user input
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Step 2: Store original number and initialize sum
        int temp = number;
        int sum = 0;

        // Step 3: Calculate sum of digits
        while (temp > 0) {
            int digit = temp % 10;   // get last digit
            sum += digit;            // add digit to sum
            temp /= 10;              // remove last digit
        }

        // Step 4: Check if number is divisible by sum of digits
        if (number % sum == 0) {
            System.out.println(number + " is a Harshad Number.");
        } else {
            System.out.println(number + " is Not a Harshad Number.");
        }

        input.close();
    }
}
