import java.util.Scanner;

public class LeapYearSingleIf {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take year as input
        System.out.print("Enter a year: ");
        int year = input.nextInt();

        // Check Gregorian calendar condition
        if (year >= 1582) {
            // Single if condition using logical operators
            if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
                System.out.println(year + " is a Leap Year.");
            } else {
                System.out.println(year + " is NOT a Leap Year.");
            }
        } else {
            System.out.println("Leap year rules do not apply before 1582 (Gregorian calendar).");
        }

        input.close();
    }
}
