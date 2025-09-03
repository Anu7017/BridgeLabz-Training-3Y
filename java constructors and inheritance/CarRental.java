class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    double ratePerDay = 1000;

    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    double calculateCost() {
        return rentalDays * ratePerDay;
    }

    void display() {
        System.out.println("Customer: " + customerName + ", Car: " + carModel + ", Days: " + rentalDays + ", Total Cost: " + calculateCost());
    }

    public static void main(String[] args) {
        CarRental rental = new CarRental("Rahul", "Hyundai i20", 5);
        rental.display();
    }
}
