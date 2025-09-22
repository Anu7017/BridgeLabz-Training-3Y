import java.util.*;

// Custom Exception
class InvalidMarkException extends Exception {
    public InvalidMarkException(String message) {
        super(message);
    }
}

// Student Class
class Student {
    private String name;
    private String[] subjects;
    private int[] marks;

    // Constructor
    public Student(String name, String[] subjects, int[] marks) throws InvalidMarkException {
        if (subjects.length != marks.length) {
            throw new InvalidMarkException("Subjects and marks count do not match!");
        }
        for (int mark : marks) {
            if (mark < 0 || mark > 100) {
                throw new InvalidMarkException("Invalid mark: " + mark + ". Marks must be between 0 and 100.");
            }
        }
        this.name = name;
        this.subjects = subjects;
        this.marks = marks;
    }

    // Calculate average
    public double calculateAverage() {
        int total = 0;
        for (int mark : marks) {
            total += mark;
        }
        return (double) total / marks.length;
    }

    // Assign grade
    public String getGrade() {
        double avg = calculateAverage();
        if (avg >= 90) return "A";
        else if (avg >= 75) return "B";
        else if (avg >= 50) return "C";
        else return "D";
    }

    // Display report card
    public void displayReport() {
        System.out.println("========================================");
        System.out.println(" Report Card for: " + name);
        System.out.println("========================================");
        System.out.printf("%-15s %-10s\n", "Subject", "Marks");
        System.out.println("----------------------------------------");
        for (int i = 0; i < subjects.length; i++) {
            System.out.printf("%-15s %-10d\n", subjects[i], marks[i]);
        }
        System.out.println("----------------------------------------");
        System.out.printf("Average: %-10.2f\n", calculateAverage());
        System.out.println("Grade: " + getGrade());
        System.out.println("========================================\n");
    }
}

// Main Class
public class StudentReportGenerator {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        String[] subjects = {"Math", "Science", "English"};

        try {
            students.add(new Student("Alice", subjects, new int[]{95, 88, 92}));
            students.add(new Student("Bob", subjects, new int[]{76, 81, 69}));
            students.add(new Student("Charlie", subjects, new int[]{45, 55, 60}));
            students.add(new Student("David", subjects, new int[]{102, 85, 70})); // invalid mark test
        } catch (InvalidMarkException e) {
            System.out.println("⚠️ Error creating student record: " + e.getMessage());
        }

        // Display all student reports
        for (Student student : students) {
            student.displayReport();
        }
    }
}
