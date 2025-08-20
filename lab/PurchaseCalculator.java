import java.util.Scanner;

public class PurchaseCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take input for unit price and quantity
        System.out.print("Enter the unit price of the item (INR): ");
        double unitPrice = input.nextDouble();

        System.out.print("Enter the quantity to be bought: ");
        int quantity = input.nextInt();

        // Calculate total purchase price
        double totalPrice = unitPrice * quantity;

        // Print result
        System.out.println("The total purchase price is INR " + totalPrice +
                           " if the quantity is " + quantity +
                           " and unit price is INR " + unitPrice);

        input.close();
    }
}
