import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take inputs
        System.out.print("Enter the base of the triangle (in inches): ");
        double base = input.nextDouble();

        System.out.print("Enter the height of the triangle (in inches): ");
        double height = input.nextDouble();

        // Area formula: 1/2 * base * height
        double areaInInches = 0.5 * base * height;

        // Convert area from square inches to square centimeters
        // 1 inch = 2.54 cm, so 1 sq. inch = (2.54 * 2.54) sq. cm = 6.4516 sq. cm
        double areaInCm = areaInInches * 6.4516;

        // Print result
        System.out.println("The area of the triangle is " + String.format("%.2f", areaInInches) + " square inches");
        System.out.println("The area of the triangle is " + String.format("%.2f", areaInCm) + " square centimeters");

        input.close();
    }
}
