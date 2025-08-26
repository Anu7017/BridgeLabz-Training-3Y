import java.util.Scanner;

public class AthleteRounds {
    public static double calculateRounds(double a, double b, double c) {
        double perimeter = a + b + c;
        double distance = 5000; // 5 km = 5000 m
        return distance / perimeter;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter side1 of triangle: ");
        double a = sc.nextDouble();

        System.out.print("Enter side2 of triangle: ");
        double b = sc.nextDouble();

        System.out.print("Enter side3 of triangle: ");
        double c = sc.nextDouble();

        System.out.println("Number of rounds needed: " + calculateRounds(a, b, c));
    }
}
