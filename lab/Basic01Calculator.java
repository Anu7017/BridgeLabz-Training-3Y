import java.util.Scanner;

public class Basic01Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take user input for two floating-point numbers
        System.out.print("Enter the first number: ");
        double number1 = input.nextDouble();

        System.out.print("Enter the second number: ");
        double number2 = input.nextDouble();

        // Perform arithmetic operations
        double addition = number1 + number2;
        double subtraction = number1 - number2;
        double multiplication = number1 * number2;
        double division = 0;

        if (number2 != 0) {
            division = number1 / number2;
        }

        // Print results in required format
        if (number2 != 0) {
            System.out.println("The addition, subtraction, multiplication, and division value of 2 numbers " 
                + number1 + " and " + number2 + " is " 
                + addition + ", " + subtraction + ", " + multiplication + ", and " + division);
        } else {
            System.out.println("The addition, subtraction, multiplication value of 2 numbers " 
                + number1 + " and " + number2 + " is " 
                + addition + ", " + subtraction + ", " + multiplication + 
                ". Division is not possible (division by zero).");
        }

        input.close();
    }
}
