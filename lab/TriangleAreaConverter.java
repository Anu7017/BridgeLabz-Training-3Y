import java.util.Scanner;

public class TriangleAreaConverter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take input for base and height in centimeters
        System.out.print("Enter the base of the triangle (in cm): ");
        double base = input.nextDouble();

        System.out.print("Enter the height of the triangle (in cm): ");
        double height = input.nextDouble();

        // Area formula: 1/2 * base * height (in cm²)
        double areaCm = 0.5 * base * height;

        // Convert cm² to in²
        // 1 inch = 2.54 cm → 1 in² = (2.54 × 2.54) cm² = 6.4516 cm²
        double areaInches = areaCm / 6.4516;

        // Print result
        System.out.println("The Area of the triangle in sq in is " + String.format("%.2f", areaInches) +
                           " and sq cm is " + String.format("%.2f", areaCm));

        input.close();
    }
}
