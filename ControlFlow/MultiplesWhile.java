import java.util.Scanner;

public class MultiplesWhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take user input
        System.out.print("Enter a positive integer less than 100: ");
        int number = input.nextInt();

        // Check condition
        if (number > 0 && number < 100) {
            int counter = 1; // Start from 1

            System.out.println("Multiples of " + number + " below 100 are:");

            // While loop
            while (counter < 100) {
                if (counter % number == 0) {
                    System.out.print(counter + " ");
                }
                counter++;
            }
        } else {
            System.out.println("Please enter a positive integer less than 100.");
        }

        input.close();
    }
}
