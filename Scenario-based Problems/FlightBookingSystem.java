import java.util.*;

// Flight class
class Flight {
    private String flightNumber;
    private String source;
    private String destination;
    private int seatsAvailable;

    // Constructor
    public Flight(String flightNumber, String source, String destination, int seatsAvailable) {
        this.flightNumber = flightNumber;
        this.source = source;
        this.destination = destination;
        this.seatsAvailable = seatsAvailable;
    }

    public String getFlightNumber() { return flightNumber; }
    public String getSource() { return source; }
    public String getDestination() { return destination; }
    public int getSeatsAvailable() { return seatsAvailable; }

    public boolean bookSeat() {
        if (seatsAvailable > 0) {
            seatsAvailable--;
            return true;
        }
        return false;
    }

    public void displayFlight() {
        System.out.println("Flight: " + flightNumber +
                " | " + source + " -> " + destination +
                " | Seats Available: " + seatsAvailable);
    }
}

// Booking class
class Booking {
    private String passengerName;
    private Flight flight;

    public Booking(String passengerName, Flight flight) {
        this.passengerName = passengerName;
        this.flight = flight;
    }

    public void displayBooking() {
        System.out.println("Passenger: " + passengerName +
                " | Flight: " + flight.getFlightNumber() +
                " | Route: " + flight.getSource() + " -> " + flight.getDestination());
    }
}

// Flight Booking System class
class FlightBookingSystemCore {
    private Flight[] flights;
    private List<Booking> bookings;

    // Constructor
    public FlightBookingSystemCore(Flight[] flights) {
        this.flights = flights;
        this.bookings = new ArrayList<>();
    }

    // Search flights by source/destination (case-insensitive)
    public List<Flight> searchFlights(String keyword) {
        List<Flight> results = new ArrayList<>();
        for (Flight flight : flights) {
            if (flight.getSource().toLowerCase().contains(keyword.toLowerCase()) ||
                flight.getDestination().toLowerCase().contains(keyword.toLowerCase())) {
                results.add(flight);
            }
        }
        return results;
    }

    // Book a flight
    public boolean bookFlight(String passengerName, Flight flight) {
        if (flight.bookSeat()) {
            bookings.add(new Booking(passengerName, flight));
            return true;
        }
        return false;
    }

    // Display all bookings
    public void displayBookings() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings yet.");
        } else {
            System.out.println("\n📒 All Bookings:");
            for (Booking booking : bookings) {
                booking.displayBooking();
            }
        }
    }
}

// Main class
public class FlightBookingSystem {
    public static void main(String[] args) {
        // Flight data stored in an Array
        Flight[] flightArray = {
            new Flight("AI101", "Delhi", "Mumbai", 2),
            new Flight("AI202", "Delhi", "Bangalore", 3),
            new Flight("AI303", "Mumbai", "Chennai", 1),
            new Flight("AI404", "Bangalore", "Delhi", 0) // no seats
        };

        FlightBookingSystemCore system = new FlightBookingSystemCore(flightArray);

        // Display all flights
        System.out.println("✈️ Available Flights:");
        for (Flight flight : flightArray) {
            flight.displayFlight();
        }

        // Search flights
        System.out.println("\n🔍 Searching flights with keyword 'Delhi':");
        List<Flight> searchResults = system.searchFlights("Delhi");
        for (Flight f : searchResults) {
            f.displayFlight();
        }

        // Book a flight
        System.out.println("\n➡️ Booking Flight AI101 for Alice:");
        if (system.bookFlight("Alice", flightArray[0])) {
            System.out.println("✅ Booking Successful!");
        } else {
            System.out.println("❌ Booking Failed. No seats available.");
        }

        // Try booking the same flight again
        System.out.println("\n➡️ Booking Flight AI101 for Bob:");
        if (system.bookFlight("Bob", flightArray[0])) {
            System.out.println("✅ Booking Successful!");
        } else {
            System.out.println("❌ Booking Failed. No seats available.");
        }

        // Try booking again (should fail if seats are exhausted)
        System.out.println("\n➡️ Booking Flight AI101 for Charlie:");
        if (system.bookFlight("Charlie", flightArray[0])) {
            System.out.println("✅ Booking Successful!");
        } else {
            System.out.println("❌ Booking Failed. No seats available.");
        }

        // Display all bookings
        system.displayBookings();
    }
}
