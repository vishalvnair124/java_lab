
import java.util.Scanner;

public class Main {

    // Method palindrome
    public static boolean isPalindrome(String s) {

        // string to lowercase
        s = s.toLowerCase();

        // Reverse the string
        String rev = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            rev = rev + s.charAt(i);
        }

        // Compare the string
        return s.equals(rev);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // user Input
        System.out.println("Enter a string: ");
        String s = sc.nextLine();

        // Check if the string is a palindrome
        boolean res = isPalindrome(s);
        if (res) {
            System.out.println("\"" + s + "\" is a palindrome.");
        } else {
            System.out.println("\"" + s + "\" is not a palindrome.");
        }
    }
}
