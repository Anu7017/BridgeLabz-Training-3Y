public class KmToMiles {
    public static void main(String[] args) {
        double kilometers = 10.8;
        double conversionFactor = 1.6; // 1 km = 1.6 miles
        double miles = kilometers * conversionFactor;

        System.out.println("The distance " + kilometers + " km in miles is " + miles);
    }
}
