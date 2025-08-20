import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the salary: ");
        double salary = input.nextDouble();

        System.out.print("Enter years of service: ");
        int years = input.nextInt();

        if (years > 5) {
            double bonus = salary * 0.05;
            System.out.println("The bonus amount is: INR " + bonus);
        } else {
            System.out.println("No bonus! Years of service is less than or equal to 5.");
        }

        input.close();
    }
}
