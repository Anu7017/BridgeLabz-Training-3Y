import java.util.Scanner;

public class SumNaturalNumbersForLoop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a natural number: ");
        int n = input.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a natural number (greater than 0).");
        } else {
            // Formula method
            int formulaSum = n * (n + 1) / 2;

            // For loop method
            int loopSum = 0;
            for (int i = 1; i <= n; i++) {
                loopSum += i;
            }

            // Display results
            System.out.println("Sum using formula: " + formulaSum);
            System.out.println("Sum using for loop: " + loopSum);

            // Compare results
            if (formulaSum == loopSum) {
                System.out.println("✅ Both results are the same.");
            } else {
                System.out.println("❌ The results are different.");
            }
        }

        input.close();
    }
}
