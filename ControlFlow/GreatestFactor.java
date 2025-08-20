import java.util.Scanner;

public class GreatestFactor {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get user input
        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();

        int greatestFactor = 1; // initialize with 1

        if (number > 1) {
            // Loop from number-1 down to 1
            for (int i = number - 1; i >= 1; i--) {
                if (number % i == 0) {
                    greatestFactor = i;
                    break; // exit once greatest factor is found
                }
            }

            System.out.println("The greatest factor of " + number + " (other than itself) is: " + greatestFactor);
        } else {
            System.out.println("Please enter an integer greater than 1.");
        }

        input.close();
    }
}
