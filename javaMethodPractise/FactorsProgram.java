import java.util.Scanner;

public class FactorsProgram {

    // Method to find factors and return them in an array
    public static int[] findFactors(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) count++;
        }

        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                factors[index++] = i;
            }
        }
        return factors;
    }

    // Method to calculate sum of factors
    public static int sumFactors(int[] factors) {
        int sum = 0;
        for (int f : factors) {
            sum += f;
        }
        return sum;
    }

    // Method to calculate product of factors
    public static long productFactors(int[] factors) {
        long product = 1;
        for (int f : factors) {
            product *= f;
        }
        return product;
    }

    // Method to calculate sum of squares of factors
    public static int sumOfSquares(int[] factors) {
        int sumSq = 0;
        for (int f : factors) {
            sumSq += Math.pow(f, 2);
        }
        return sumSq;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();

        int[] factors = findFactors(n);

        System.out.print("Factors: ");
        for (int f : factors) {
            System.out.print(f + " ");
        }
        System.out.println();

        System.out.println("Sum of factors = " + sumFactors(factors));
        System.out.println("Sum of squares of factors = " + sumOfSquares(factors));
        System.out.println("Product of factors = " + productFactors(factors));

        sc.close();
    }
}
