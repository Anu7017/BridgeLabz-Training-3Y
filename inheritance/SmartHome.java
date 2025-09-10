package com.bridgelabz.oops.inheritance;

// Superclass
class Device {
    protected String deviceId;
    protected boolean status; // true = ON, false = OFF

    public Device(String deviceId, boolean status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    public void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + (status ? "ON" : "OFF"));
    }
}

// Subclass
class Thermostat extends Device {
    private double temperatureSetting;

    public Thermostat(String deviceId, boolean status, double temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }

    @Override
    public void displayStatus() {
        super.displayStatus();
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
    }
}

// Main class
public class SmartHome {
    public static void main(String[] args) {
        Thermostat thermostat1 = new Thermostat("T1001", true, 22.5);
        Thermostat thermostat2 = new Thermostat("T1002", false, 19.0);

        thermostat1.displayStatus();
        System.out.println();
        thermostat2.displayStatus();
    }
}
