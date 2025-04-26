import java.util.Scanner;

// Custom exception for invalid phone numbers
class InvalidPhoneNumberException extends Exception {
    public InvalidPhoneNumberException(String message) {
        super(message);
    }
}

public class Main {
    // Validates if the phone number has exactly 10 digits
    public static void validatePhoneNumber(String phoneNumber) throws InvalidPhoneNumberException {
        if (!phoneNumber.matches("\\d{10}")) {
            throw new InvalidPhoneNumberException("Phone number must have exactly 10 digits.");
        } else {
            System.out.println("Phone number have exactly 10 digits.");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter a mobile number :");
            String phone = sc.nextLine();
            validatePhoneNumber(phone); // Example of an invalid phone number
        } catch (InvalidPhoneNumberException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}