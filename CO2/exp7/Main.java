
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // get user input for the original string, search word, and replacement word
        System.out.print("Enter the original string: ");
        String original = scanner.nextLine();

        System.out.print("Enter the word to search: ");
        String search = scanner.nextLine();

        System.out.print("Enter the replacement word: ");
        String replace = scanner.nextLine();

        // replace all occurrences of the search word with the replacement word
        String updatedString = original.replaceAll(search, replace);

        // display the original and updated strings
        System.out.println("\nOriginal String: " + original);
        System.out.println("\nUpdated String: " + updatedString);

        scanner.close();
    }
}