import java.util.Scanner;

public class Marks2D {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] marks = new int[n][3]; 
        double[] percent = new double[n];
        char[] grade = new char[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Enter Physics, Chemistry, Maths marks for student " + (i+1) + ": ");
            marks[i][0] = sc.nextInt();
            marks[i][1] = sc.nextInt();
            marks[i][2] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            double total = marks[i][0] + marks[i][1] + marks[i][2];
            percent[i] = total / 3.0;

            if (percent[i] >= 80) grade[i] = 'A';
            else if (percent[i] >= 60) grade[i] = 'B';
            else if (percent[i] >= 40) grade[i] = 'C';
            else grade[i] = 'F';
        }

        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s\n", 
                          "Physics", "Chemistry", "Maths", "Total", "Percent", "Grade");

        for (int i = 0; i < n; i++) {
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            System.out.printf("%-10d %-10d %-10d %-10d %-10.2f %-10c\n", 
                              marks[i][0], marks[i][1], marks[i][2], total, percent[i], grade[i]);
        }
    }
}
