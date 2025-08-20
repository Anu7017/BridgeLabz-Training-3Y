import java.util.Scanner;

public class DoubleOpt {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take input for two double numbers
        System.out.print("Enter the first number: ");
        double number1 = input.nextDouble();

        System.out.print("Enter the second number: ");
        double number2 = input.nextDouble();

        // Calculate quotient (normal division)
        double quotient = number1 / number2;

        // Calculate remainder using modulus operator (%)
        double remainder = number1 % number2;

        // Print result
        System.out.println("The Quotient is " + quotient + " and Remainder is " + remainder +
                           " of two numbers " + number1 + " and " + number2);

        input.close();
    }
}
