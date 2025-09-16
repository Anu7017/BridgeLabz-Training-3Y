import java.util.ArrayList;

class Faculty {
    private String name;
    private String specialization;

    public Faculty(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }

    public String getName() {
        return name;
    }

    public void showInfo() {
        System.out.println("Faculty: " + name + " | Specialization: " + specialization);
    }
}

class Department {
    private String name;
    private ArrayList<Faculty> faculties = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public void showDepartment() {
        System.out.println("Department: " + name);
        for (Faculty f : faculties) {
            f.showInfo();
        }
    }
}

class University {
    private String name;
    private ArrayList<Department> departments = new ArrayList<>();
    private ArrayList<Faculty> faculties = new ArrayList<>();

    public University(String name) {
        this.name = name;
    }

    public void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public void assignFacultyToDepartment(String deptName, Faculty faculty) {
        for (Department d : departments) {
            if (d.getName().equals(deptName)) {
                d.addFaculty(faculty);
            }
        }
    }

    public void showUniversity() {
        System.out.println("University: " + name);
        for (Department d : departments) {
            d.showDepartment();
        }
        System.out.println("Independent Faculties:");
        for (Faculty f : faculties) {
            f.showInfo();
        }
    }

    public void closeUniversity() {
        departments.clear();
        System.out.println("University " + name + " is closed. All departments deleted.");
    }
}

public class Main {
    public static void main(String[] args) {
        University uni = new University("Global University");

        Faculty f1 = new Faculty("Alice", "Mathematics");
        Faculty f2 = new Faculty("Bob", "Physics");
        Faculty f3 = new Faculty("Charlie", "Computer Science");

        uni.addFaculty(f1);
        uni.addFaculty(f2);

        uni.addDepartment("Science");
        uni.addDepartment("Engineering");

        uni.assignFacultyToDepartment("Science", f1);
        uni.assignFacultyToDepartment("Engineering", f3);

        uni.showUniversity();

        uni.closeUniversity();
        uni.showUniversity();
    }
}
