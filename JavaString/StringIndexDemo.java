import java.util.Scanner;

public class StringIndexDemo {
    public static void generateException(String text) {
        System.out.println(text.charAt(text.length() + 1)); // Out of bounds
    }

    public static void handleException(String text) {
        try {
            System.out.println(text.charAt(text.length() + 1));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("Caught StringIndexOutOfBoundsException!");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.next();
        
        // generateException(text);  
        handleException(text);
    }
}
