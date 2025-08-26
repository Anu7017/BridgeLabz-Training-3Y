import java.util.Scanner;

public class TeamBMI {

    // Method to compute BMI and status
    public static String[] calculateBMI(double weight, double heightCm) {
        double heightM = heightCm / 100.0; // convert cm to meters
        double bmi = weight / (heightM * heightM);

        String status;
        if (bmi < 18.5) status = "Underweight";
        else if (bmi < 25) status = "Normal";
        else if (bmi < 30) status = "Overweight";
        else status = "Obese";

        return new String[]{String.format("%.2f", weight), 
                            String.format("%.2f", heightCm), 
                            String.format("%.2f", bmi), 
                            status};
    }

    // Method to process all persons
    public static String[][] processPersons(double[][] personData) {
        String[][] result = new String[personData.length][4];
        for (int i = 0; i < personData.length; i++) {
            result[i] = calculateBMI(personData[i][0], personData[i][1]);
        }
        return result;
    }

    // Method to display in tabular format
    public static void displayResult(String[][] data) {
        System.out.printf("%-10s %-10s %-10s %-15s\n", "Weight", "Height", "BMI", "Status");
        for (String[] row : data) {
            System.out.printf("%-10s %-10s %-10s %-15s\n", row[0], row[1], row[2], row[3]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[][] personData = new double[10][2]; // 10 persons, weight & height

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) for person " + (i+1) + ": ");
            personData[i][0] = sc.nextDouble();
            System.out.print("Enter height (cm) for person " + (i+1) + ": ");
            personData[i][1] = sc.nextDouble();
        }

        String[][] result = processPersons(personData);
        displayResult(result);
    }
}
