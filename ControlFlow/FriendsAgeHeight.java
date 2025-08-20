import java.util.Scanner;

public class FriendsAgeHeight {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take ages
        System.out.print("Enter Amar's age: ");
        int amarAge = input.nextInt();
        System.out.print("Enter Akbar's age: ");
        int akbarAge = input.nextInt();
        System.out.print("Enter Anthony's age: ");
        int anthonyAge = input.nextInt();

        // Take heights
        System.out.print("Enter Amar's height (in cm): ");
        int amarHeight = input.nextInt();
        System.out.print("Enter Akbar's height (in cm): ");
        int akbarHeight = input.nextInt();
        System.out.print("Enter Anthony's height (in cm): ");
        int anthonyHeight = input.nextInt();

        // Find youngest
        if (amarAge < akbarAge && amarAge < anthonyAge) {
            System.out.println("Amar is the youngest.");
        } else if (akbarAge < amarAge && akbarAge < anthonyAge) {
            System.out.println("Akbar is the youngest.");
        } else if (anthonyAge < amarAge && anthonyAge < akbarAge) {
            System.out.println("Anthony is the youngest.");
        } else {
            System.out.println("Two or more friends have the same youngest age.");
        }

        // Find tallest
        if (amarHeight > akbarHeight && amarHeight > anthonyHeight) {
            System.out.println("Amar is the tallest.");
        } else if (akbarHeight > amarHeight && akbarHeight > anthonyHeight) {
            System.out.println("Akbar is the tallest.");
        } else if (anthonyHeight > amarHeight && anthonyHeight > akbarHeight) {
            System.out.println("Anthony is the tallest.");
        } else {
            System.out.println("Two or more friends have the same tallest height.");
        }

        input.close();
    }
}
