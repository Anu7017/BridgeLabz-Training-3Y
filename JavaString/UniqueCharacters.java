import java.util.Scanner;

public class UniqueCharacters {

    public static void findUnique(String str) {
        String unique = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (unique.indexOf(ch) == -1) {
                unique += ch;
            }
        }
        System.out.println("Unique characters: " + unique);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        findUnique(str);
    }
}
