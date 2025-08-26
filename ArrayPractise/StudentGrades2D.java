import java.util.Scanner;

public class StudentGrades2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of students
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        // 2D array for marks: rows = students, cols = 3 subjects
        int[][] marks = new int[n][3];
        double[] percentage = new double[n];
        char[] grade = new char[n];

        // Take input
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter marks for Student " + (i + 1) + " (Physics, Chemistry, Maths):");
            for (int j = 0; j < 3; j++) {
                int mark;
                do {
                    mark = sc.nextInt();
                    if (mark < 0 || mark > 100) {
                        System.out.println("Invalid! Marks should be between 0 and 100. Re-enter:");
                    }
                } while (mark < 0 || mark > 100);
                marks[i][j] = mark;
            }
        }

        // Calculate percentage & grade
        for (int i = 0; i < n; i++) {
            int to
