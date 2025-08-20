import java.util.Scanner;

public class KmToMilesInput {
    public static void main(String[] args) {
        double km, miles;

        Scanner input = new Scanner(System.in);

        System.out.print("Enter distance in kilometers: ");
        km = input.nextDouble();

        miles = km / 1.6; // since 1 mile = 1.6 km

        System.out.println("The total miles is " + miles + " mile for the given " + km + " km");
    }
}
