import java.util.ArrayList;
import java.util.List;

// Abstract Class
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public void setRatePerKm(double ratePerKm) {
        this.ratePerKm = ratePerKm;
    }

    public abstract double calculateFare(double distance);

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId + ", Driver: " + driverName + ", Rate per Km: " + ratePerKm);
    }
}

// Interface
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Car Class
class Car extends Vehicle implements GPS {
    private String currentLocation;

    public Car(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = currentLocation;
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance;
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

// Bike Class
class Bike extends Vehicle implements GPS {
    private String currentLocation;

    public Bike(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = currentLocation;
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance * 0.8; // 20% cheaper than car
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

// Auto Class
class Auto extends Vehicle implements GPS {
    private String currentLocation;

    public Auto(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = currentLocation;
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance * 0.7; // 30% cheaper than car
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
    }
}

// Main Class
public class RideHailingApp {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();

        Car car1 = new Car("C001", "Alice", 20, "Downtown");
        Bike bike1 = new Bike("B101", "Bob", 15, "Uptown");
        Auto auto1 = new Auto("A201", "Charlie", 10, "Central");

        vehicles.add(car1);
        vehicles.add(bike1);
        vehicles.add(auto1);

        double distance = 10; // kms

        for (Vehicle v : vehicles) {
            v.getVehicleDetails();
            System.out.println("Current Location: " + ((GPS) v).getCurrentLocation());
            System.out.println("Fare for " + distance + " km: " + v.calculateFare(distance));
            ((GPS) v).updateLocation("New Location");
            System.out.println("Updated Location: " + ((GPS) v).getCurrentLocation());
            System.out.println("-----------------------------");
        }
    }
}
