import java.util.ArrayList;

class Employee {
    private String name;
    private String role;

    public Employee(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public void showInfo() {
        System.out.println("Employee: " + name + " | Role: " + role);
    }
}

class Department {
    private String name;
    private ArrayList<Employee> employees = new ArrayList<>();

    public Department(String name) {
        this.name = name;
    }

    public void addEmployee(String name, String role) {
        employees.add(new Employee(name, role));
    }

    public void showEmployees() {
        System.out.println("Department: " + name);
        for (Employee e : employees) {
            e.showInfo();
        }
    }
}

class Company {
    private String name;
    private ArrayList<Department> departments = new ArrayList<>();

    public Company(String name) {
        this.name = name;
    }

    public void addDepartment(String deptName) {
        departments.add(new Department(deptName));
    }

    public Department getDepartment(String deptName) {
        for (Department d : departments) {
            if (d.toString().equals(deptName)) return d;
        }
        return null;
    }

    public void showCompanyStructure() {
        System.out.println("Company: " + name);
        for (Department d : departments) {
            d.showEmployees();
        }
    }

    public void closeCompany() {
        departments.clear();
        System.out.println("Company " + name + " is closed. All departments and employees removed.");
    }
}

public class Main {
    public static void main(String[] args) {
        Company company = new Company("Tech Solutions");

        Department dev = new Department("Development");
        dev.addEmployee("Alice", "Software Engineer");
        dev.addEmployee("Bob", "Senior Developer");

        Department hr = new Department("HR");
        hr.addEmployee("Charlie", "HR Manager");

        company.addDepartment("Development");
        company.addDepartment("HR");

        company.showCompanyStructure();

        company.closeCompany();
    }
}
