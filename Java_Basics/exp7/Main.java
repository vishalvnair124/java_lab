import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int num, original, sum = 0, count = 0;

        // Get user input
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        num = sc.nextInt();
        original = num;

        // Count the number of digits
        int temp;
        for (temp = num; temp > 0; count++, temp /= 10)
            ;

        // Calculate the sum of each digit raised to the power of count
        temp = num;
        while (temp > 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, count);
            temp /= 10;
        }

        // Check if it is an Armstrong number
        System.out.println(original == sum ? "Armstrong Number" : "Not an Armstrong Number");

        sc.close();
    }
}
