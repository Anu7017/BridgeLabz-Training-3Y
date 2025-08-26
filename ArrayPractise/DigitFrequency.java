import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number
        System.out.print("Enter a number: ");
        long number = sc.nextLong();

        // Handle negative numbers by converting to positive
        number = Math.abs(number);

        // Convert number to digits
        String numStr = Long.toString(number);
        int length = numStr.length();
        int[] digits = new int[length];

        for (int i = 0; i < length; i++) {
            digits[i] = numStr.charAt(i) - '0';  // store each digit
        }

        // Frequency array for digits 0–9
        int[] freq = new int[10];

        // Count frequency
        for (int d : digits) {
            freq[d]++;
        }

        // Display result
        System.out.println("\nDigit Frequency:");
        for (int i = 0; i < 10; i++) {
            if (freq[i] > 0) {
                System.out.println("Digit " + i + " occurs " + freq[i] + " times");
            }
        }

        sc.close();
    }
}
