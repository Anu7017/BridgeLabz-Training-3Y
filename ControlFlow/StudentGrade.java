import java.util.Scanner;

public class StudentGrade {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input marks
        System.out.print("Enter marks in Physics: ");
        int physics = input.nextInt();

        System.out.print("Enter marks in Chemistry: ");
        int chemistry = input.nextInt();

        System.out.print("Enter marks in Maths: ");
        int maths = input.nextInt();

        // Compute average
        double average = (physics + chemistry + maths) / 3.0;

        // Display average
        System.out.println("\nAverage Percentage: " + average + "%");

        // Determine Grade and Remarks
        if (average >= 90) {
            System.out.println("Grade: A+");
            System.out.println("Remarks: Excellent Performance!");
        } else if (average >= 80) {
            System.out.println("Grade: A");
            System.out.println("Remarks: Very Good Work!");
        } else if (average >= 70) {
            System.out.println("Grade: B");
            System.out.println("Remarks: Good, Keep Improving!");
        } else if (average >= 60) {
            System.out.println("Grade: C");
            System.out.println("Remarks: Fair, You Can Do Better!");
        } else if (average >= 50) {
            System.out.println("Grade: D");
            System.out.println("Remarks: Needs More Effort!");
        } else {
            System.out.println("Grade: F");
            System.out.println("Remarks: Fail, Work Harder Next Time!");
        }

        input.close();
    }
}
