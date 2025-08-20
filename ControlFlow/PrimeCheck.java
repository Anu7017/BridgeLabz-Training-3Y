import java.util.Scanner;

public class PrimeCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter an integer greater than 1: ");
        int number = input.nextInt();

        if (number <= 1) {
            System.out.println("Please enter a number greater than 1 to check for primality.");
        } else {
            boolean isPrime = true;

            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.println(number + " is a Prime Number.");
            } else {
                System.out.println(number + " is NOT a Prime Number.");
            }
        }

        input.close();
    }
}
