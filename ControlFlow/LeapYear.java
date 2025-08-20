import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take year as input
        System.out.print("Enter a year: ");
        int year = input.nextInt();

        // Check Gregorian calendar condition
        if (year < 1582) {
            System.out.println("Leap year rules do not apply before 1582 (Gregorian calendar).");
        } else {
            // ------------------- Part 1: Multiple if-else statements -------------------
            if (year % 400 == 0) {
                System.out.println(year + " is a Leap Year (checked by multiple if-else).");
            } else if (year % 100 == 0) {
                System.out.println(year + " is NOT a Leap Year (checked by multiple if-else).");
            } else if (year % 4 == 0) {
                System.out.println(year + " is a Leap Year (checked by multiple if-else).");
            } else {
                System.out.println(year + " is NOT a Leap Year (checked by multiple if-else).");
            }

            // ------------------- Part 2: Single if statement with logical operators -------------------
            if ((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)) {
                System.out.println(year + " is a Leap Year (checked by single if with logical operators).");
            } else {
                System.out.println(year + " is NOT a Leap Year (checked by single if with logical operators).");
            }
        }

        input.close();
    }
}
