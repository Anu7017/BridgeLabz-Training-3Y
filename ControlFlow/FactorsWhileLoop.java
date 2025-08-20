import java.util.Scanner;

public class FactorsWhileLoop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get user input
        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();

        // Check if the input is a positive integer
        if (number > 0) {
            System.out.println("Factors of " + number + " are:");

            int i = 1; // counter variable

            // Run while loop
            while (i <= number) {
                if (number % i == 0) {
                    System.out.println(i);
                }
                i++; // increment counter
            }
        } else {
            System.out.println("Please enter a positive integer.");
        }

        input.close();
    }
}
