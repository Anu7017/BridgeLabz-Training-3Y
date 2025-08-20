import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Step 1: Take user input
        System.out.print("Enter your weight in kg: ");
        double weight = input.nextDouble();

        System.out.print("Enter your height in cm: ");
        double heightCm = input.nextDouble();

        // Step 2: Convert height to meters
        double heightM = heightCm / 100;

        // Step 3: Calculate BMI
        double bmi = weight / (heightM * heightM);

        // Step 4: Print BMI
        System.out.printf("Your BMI is: %.2f%n", bmi);

        // Step 5: Determine weight status
        if (bmi < 18.5) {
            System.out.println("You are Underweight.");
        } else if (bmi >= 18.5 && bmi < 24.9) {
            System.out.println("You have Normal weight.");
        } else if (bmi >= 25 && bmi < 29.9) {
            System.out.println("You are Overweight.");
        } else {
            System.out.println("You are Obese.");
        }

        input.close();
    }
}
