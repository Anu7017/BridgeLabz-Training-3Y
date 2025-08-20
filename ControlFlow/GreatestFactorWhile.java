import java.util.Scanner;

public class GreatestFactorWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get user input
        System.out.print("Enter a positive integer: ");
        int number = input.nextInt();

        int greatestFactor = 1; // initialize with 1

        if (number > 1) {
            int counter = number - 1; // start from number-1

            while (counter >= 1) {
                if (number % counter == 0) {
                    greatestFactor = counter;
                    break; // stop once the greatest factor is found
                }
                counter--;
            }

            System.out.println("The greatest factor of " + number + " (other than itself) is: " + greatestFactor);
        } else {
            System.out.println("Please enter an integer greater than 1.");
        }

        input.close();
    }
}
