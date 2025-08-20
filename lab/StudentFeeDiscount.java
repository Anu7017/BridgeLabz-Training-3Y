import java.util.Scanner;

public class StudentFeeDiscount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take input for student fee
        System.out.print("Enter the student fee (INR): ");
        double fee = input.nextDouble();

        // Take input for university discount in percentage
        System.out.print("Enter the university discount percentage: ");
        double discountPercent = input.nextDouble();

        // Calculate discount amount
        double discount = (fee * discountPercent) / 100;

        // Calculate final fee
        double finalFee = fee - discount;

        // Print results
        System.out.println("The discount amount is INR " + discount + " and final discounted fee is INR " + finalFee);

        input.close();
    }
}
