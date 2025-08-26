import java.util.Scanner;

public class SubstringCompare {
    public static String substringUsingCharAt(String text, int start, int end) {
        String result = "";
        for (int i = start; i < end; i++) {
            result += text.charAt(i);
        }
        return result;
    }

    public static boolean compareUsingCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.next();
        System.out.print("Enter start index: ");
        int start = sc.nextInt();
        System.out.print("Enter end index: ");
        int end = sc.nextInt();

        String userDefined = substringUsingCharAt(text, start, end);
        String builtIn = text.substring(start, end);

        System.out.println("User-defined substring: " + userDefined);
        System.out.println("Built-in substring: " + builtIn);
        System.out.println("Are they same? " + compareUsingCharAt(userDefined, builtIn));
    }
}
