import java.util.ArrayList;
import java.util.List;

// Abstract Class
abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public abstract double calculateBill();

    public void getPatientDetails() {
        System.out.println("ID: " + patientId + ", Name: " + name + ", Age: " + age);
    }
}

// Interface
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// InPatient Class
class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyRate;
    private List<String> records;

    public InPatient(String patientId, String name, int age, int daysAdmitted, double dailyRate) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyRate = dailyRate;
        this.records = new ArrayList<>();
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyRate;
    }

    @Override
    public void addRecord(String record) {
        records.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records for " + getName() + ":");
        for (String r : records) {
            System.out.println("- " + r);
        }
    }
}

// OutPatient Class
class OutPatient extends Patient implements MedicalRecord {
    private int consultationFee;
    private List<String> records;

    public OutPatient(String patientId, String name, int age, int consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
        this.records = new ArrayList<>();
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }

    @Override
    public void addRecord(String record) {
        records.add(record);
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records for " + getName() + ":");
        for (String r : records) {
            System.out.println("- " + r);
        }
    }
}

// Main Class
public class HospitalPatientManagement {
    public static void main(String[] args) {
        List<Patient> patients = new ArrayList<>();

        InPatient ip = new InPatient("P1001", "Alice", 30, 5, 2000);
        OutPatient op = new OutPatient("P2001", "Bob", 25, 500);

        patients.add(ip);
        patients.add(op);

        ip.addRecord("Surgery performed on 10-Sep");
        ip.addRecord("Prescribed antibiotics");
        op.addRecord("Routine check-up");

        for (Patient p : patients) {
            p.getPatientDetails();
            System.out.println("Bill: " + p.calculateBill());

            if (p instanceof MedicalRecord) {
                MedicalRecord mr = (MedicalRecord) p;
                mr.viewRecords();
            }

            System.out.println("-----------------------------");
        }
    }
}
