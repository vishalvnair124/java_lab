import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the limit
        System.out.print("Enter the limit: ");
        int limit = scanner.nextInt();

        int a = 0, b = 1;

        System.out.print(a + " " + b);
        for (int i = 2; i < limit; i++) {
            int c = a + b;
            System.out.print(" " + c);
            a = b;
            b = c;
        }

        scanner.close();
    }
}
