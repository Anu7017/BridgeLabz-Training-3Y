import java.util.ArrayList;

class Course {
    private String name;
    private Professor professor;
    private ArrayList<Student> students = new ArrayList<>();

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void assignProfessor(Professor professor) {
        this.professor = professor;
        professor.addCourse(this);
        System.out.println("Professor " + professor.getName() + " assigned to course " + name);
    }

    public void enrollStudent(Student student) {
        if (!students.contains(student)) {
            students.add(student);
            student.addCourse(this);
            System.out.println("Student " + student.getName() + " enrolled in course " + name);
        }
    }

    public void showCourseDetails() {
        System.out.println("Course: " + name);
        if (professor != null) {
            System.out.println("Professor: " + professor.getName());
        }
        System.out.println("Enrolled Students:");
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

    public void enrollCourse(Course course) {
        course.enrollStudent(this);
    }

    public void addCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    public void showCourses() {
        System.out.println("Student: " + name + " | Courses:");
        for (Course c : courses) {
            System.out.println("- " + c.getName());
        }
    }
}

class Professor {
    private String name;
    private ArrayList<Course> courses = new ArrayList<>();

    public Professor(String name) {
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

    public void showCourses() {
        System.out.println("Professor: " + name + " | Teaching Courses:");
        for (Course c : courses) {
            System.out.println("- " + c.getName());
        }
    }
}

class University {
    private String name;
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Professor> professors = new ArrayList<>();
    private ArrayList<Course> courses = new ArrayList<>();

    public University(String name) {
        this.name = name;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addProfessor(Professor professor) {
        professors.add(professor);
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public void showUniversityDetails() {
        System.out.println("University: " + name);
        System.out.println("Students:");
        for (Student s : students) {
            System.out.println("- " + s.getName());
        }
        System.out.println("Professors:");
        for (Professor p : professors) {
            System.out.println("- " + p.getName());
        }
        System.out.println("Courses:");
        for (Course c : courses) {
            System.out.println("- " + c.getName());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        University uni = new University("Tech University");

        Student s1 = new Student("Alice");
        Student s2 = new Student("Bob");
        Professor p1 = new Professor("Dr. Smith");
        Professor p2 = new Professor("Dr. Johnson");
        Course c1 = new Course("Computer Science");
        Course c2 = new Course("Mathematics");

        uni.addStudent(s1);
        uni.addStudent(s2);
        uni.addProfessor(p1);
        uni.addProfessor(p2);
        uni.addCourse(c1);
        uni.addCourse(c2);

        c1.assignProfessor(p1);
        c2.assignProfessor(p2);

        s1.enrollCourse(c1);
        s2.enrollCourse(c1);
        s2.enrollCourse(c2);

        uni.showUniversityDetails();
        s1.showCourses();
        s2.showCourses();
        p1.showCourses();
        p2.showCourses();
        c1.showCourseDetails();
        c2.showCourseDetails();
    }
}
