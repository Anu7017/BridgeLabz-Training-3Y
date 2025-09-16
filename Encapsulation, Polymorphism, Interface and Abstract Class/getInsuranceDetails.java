import java.util.ArrayList;
import java.util.List;

// Abstract Class
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(double rentalRate) {
        this.rentalRate = rentalRate;
    }

    public abstract double calculateRentalCost(int days);

    public void displayDetails() {
        System.out.println("Vehicle No: " + vehicleNumber + ", Type: " + type + ", Rate per Day: " + rentalRate);
    }
}

// Interface
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Car Class
class Car extends Vehicle implements Insurable {
    private String policyNumber;

    public Car(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Car", rentalRate);
        this.policyNumber = policyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days; // simple daily cost
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.10; // 10% of rate as insurance
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance Policy: " + policyNumber;
    }
}

// Bike Class
class Bike extends Vehicle implements Insurable {
    private String policyNumber;

    public Bike(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Bike", rentalRate);
        this.policyNumber = policyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 0.8; // 20% discount for bikes
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.05; // 5% of rate
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance Policy: " + policyNumber;
    }
}

// Truck Class
class Truck extends Vehicle implements Insurable {
    private String policyNumber;

    public Truck(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Truck", rentalRate);
        this.policyNumber = policyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return (getRentalRate() * days) + 500; // extra service charge
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.15; // 15% of rate
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance Policy: " + policyNumber;
    }
}

// Main Class
public class VehicleRentalSystem {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();

        Car car1 = new Car("CAR123", 2000, "POL12345");
        Bike bike1 = new Bike("BIKE101", 500, "POL67890");
        Truck truck1 = new Truck("TRUCK555", 5000, "POL24680");

        vehicles.add(car1);
        vehicles.add(bike1);
        vehicles.add(truck1);

        int days = 5;

        for (Vehicle v : vehicles) {
            v.displayDetails();
            double rentalCost = v.calculateRentalCost(days);
            System.out.println("Rental Cost for " + days + " days: " + rentalCost);

            if (v instanceof Insurable) {
                Insurable ins = (Insurable) v;
                double insurance = ins.calculateInsurance();
                System.out.println(ins.getInsuranceDetails());
                System.out.println("Insurance Cost: " + insurance);
            }

            System.out.println("-----------------------------");
        }
    }
}
