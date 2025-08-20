import java.util.Scanner;

public class SumOfNaturalNumbers {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a natural number n: ");
        int n = input.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a valid natural number (greater than 0).");
        } else {
            // Compute sum using while loop
            int sumWhile = 0;
            int i = 1;
            while (i <= n) {
                sumWhile += i;
                i++;
            }

            // Compute sum using formula
            int sumFormula = n * (n + 1) / 2;

            // Print results
            System.out.println("Sum using while loop: " + sumWhile);
            System.out.println("Sum using formula: " + sumFormula);

            // Compare results
            if (sumWhile == sumFormula) {
                System.out.println("✅ Both computations are correct!");
            } else {
                System.out.println("❌ Results do not match.");
            }
        }

        input.close();
    }
}
