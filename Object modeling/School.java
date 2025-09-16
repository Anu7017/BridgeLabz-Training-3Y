import java.util.ArrayList;

class Course {
    private String name;
    private ArrayList<Student> students = new ArrayList<>();

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void enrollStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            student.addCourse(this);
        }
    }

    public void showStudents() {
        System.out.println("Course: " + name + " | Enrolled Students:");
        for (Student s : students) {
            System.out.println("- " + s.getName());
        }
    }
}

class Student {
    private String name;
    private ArrayList<Course> courses = new ArrayList<>();

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    public void viewCourses() {
        System.out.println("Student: " + name + " | Courses Enrolled:");
        for (Course c : courses) {
            System.out.println("- " + c.getName());
        }
    }
}

class School {
    private String name;
    private ArrayList<Student> students = new ArrayList<>();

    public School(String name) {
        this.name = name;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void showStudents() {
        System.out.println("School: " + name + " | Students:");
        for (Student s : students) {
            System.out.println("- " + s.getName());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        School school = new School("Greenwood High");

        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");
        Student s3 = new Student("Charlie");

        school.addStudent(s1);
        school.addStudent(s2);
        school.addStudent(s3);

        Course c1 = new Course("Mathematics");
        Course c2 = new Course("Science");

        c1.enrollStudent(s1);
        c1.enrollStudent(s2);
        c2.enrollStudent(s2);
        c2.enrollStudent(s3);

        school.showStudents();
        s1.viewCourses();
        s2.viewCourses();
        s3.viewCourses();
        c1.showStudents();
        c2.showStudents();
    }
}
