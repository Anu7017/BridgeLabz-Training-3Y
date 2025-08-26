import java.util.Scanner;

public class TrimSpaces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string with spaces: ");
        String input = sc.nextLine();

        String trimmed = input.trim();

        System.out.println("Original: [" + input + "]");
        System.out.println("Trimmed : [" + trimmed + "]");
    }
}
