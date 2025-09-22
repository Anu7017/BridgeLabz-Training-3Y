import java.util.*;

// Custom Exception for invalid salary
class InvalidSalaryException extends Exception {
    public InvalidSalaryException(String message) {
        super(message);
    }
}

// Employee Class
class Employee {
    private String name;
    private int id;
    private String department;
    private double basicSalary;

    // Constructor
    public Employee(String name, int id, String department, double basicSalary) throws InvalidSalaryException {
        if (basicSalary < 0) {
            throw new InvalidSalaryException("❌ Salary cannot be negative for " + name);
        }
        this.name = name;
        this.id = id;
        this.department = department;
        this.basicSalary = basicSalary;
    }

    public String getName() { return name; }
    public int getId() { return id; }
    public String getDepartment() { return department; }
    public double getBasicSalary() { return basicSalary; }

    // Calculate gross salary (basic + allowances, say 20% HRA + 10% DA)
    public double calculateGrossSalary() {
        return basicSalary + (0.2 * basicSalary) + (0.1 * basicSalary);
    }

    // Calculate tax based on salary brackets
    public double calculateTax() {
        double gross = calculateGrossSalary();
        if (gross <= 30000) return 0;
        else if (gross <= 60000) return gross * 0.1;   // 10%
        else return gross * 0.2;                       // 20%
    }

    // Calculate net salary
    public double calculateNetSalary() {
        return calculateGrossSalary() - calculateTax();
    }

    // Annual salary report
    public double calculateAnnualSalary() {
        return calculateNetSalary() * 12;
    }

    public void displaySalaryReport() {
        System.out.println("Employee: " + name + " | ID: " + id + " | Dept: " + department);
        System.out.println("Basic Salary: " + basicSalary);
        System.out.println("Gross Salary: " + calculateGrossSalary());
        System.out.println("Tax Deducted: " + calculateTax());
        System.out.println("Net Salary (Monthly): " + calculateNetSalary());
        System.out.println("Annual Salary: " + calculateAnnualSalary());
        System.out.println("----------------------------------");
    }
}

// Payroll System Class
class PayrollSystem {
    private List<Employee> employees = new ArrayList<>();

    // Add employee
    public void addEmployee(Employee emp) {
        employees.add(emp);
    }

    // Generate report for all employees
    public void generateAnnualReport() {
        if (employees.isEmpty()) {
            System.out.println("❌ No employee records found.");
            return;
        }
        System.out.println("📑 Annual Payroll Report:");
        for (Employee emp : employees) {
            emp.displaySalaryReport();
        }
    }
}

// Main Class
public class EmployeePayrollSystem {
    public static void main(String[] args) {
        PayrollSystem payroll = new PayrollSystem();

        try {
            // Adding employees
            payroll.addEmployee(new Employee("Alice", 101, "IT", 25000));
            payroll.addEmployee(new Employee("Bob", 102, "HR", 40000));
            payroll.addEmployee(new Employee("Charlie", 103, "Finance", 70000));

            // Uncomment below line to test invalid salary
            // payroll.addEmployee(new Employee("David", 104, "Sales", -15000));

        } catch (InvalidSalaryException e) {
            System.out.println(e.getMessage());
        }

        // Generate report
        payroll.generateAnnualReport();
    }
}
