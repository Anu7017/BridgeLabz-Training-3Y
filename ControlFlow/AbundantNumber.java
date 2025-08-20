import java.util.Scanner;

public class AbundantNumber {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Step 1: Take user input
        System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Step 2: Initialize sum of divisors
        int sum = 0;

        // Step 3: Find divisors and add them
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }

        // Step 4: Check condition for Abundant Number
        if (sum > number) {
            System.out.println(number + " is an Abundant Number.");
        } else {
            System.out.println(number + " is Not an Abundant Number.");
        }

        input.close();
    }
}
