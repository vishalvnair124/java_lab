import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter a number
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();

        int reversed = 0, original = num;

        while (num > 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }

        System.out.println(original == reversed ? "Palindrome" : "Not a Palindrome");

        scanner.close();
    }
}
