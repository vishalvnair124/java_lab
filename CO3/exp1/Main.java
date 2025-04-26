import java.util.Scanner;

// Main class to 
public class Main {

    // Method to validate the password

    public static void validatePassword(String password) throws InvalidPasswordException {
        // Check if the password is at least 8 characters long
        if (password.length() < 8) {
            throw new InvalidPasswordException("Password must be at least 8 characters long.");
        }
        // Check if at least one numeric character.
        else if (!password.matches(".*\\d.*")) {
            throw new InvalidPasswordException("Password must contain at least one number.");
        }
        // Check if at least one special character ($, #, &)
        else if (!password.matches(".*[#$&].*")) {
            throw new InvalidPasswordException("Password must contain at least one special character ($, #, &).");
        } else {
            System.out.print("Password ok");
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            // Attempt to validate a sample password

            System.out.print("Enter a passwword : ");
            String password = sc.nextLine();
            validatePassword(password);
        } catch (InvalidPasswordException e) {
            // Handle the exception and print the error message
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}

// Custom exception class for invalid passwords.
class InvalidPasswordException extends Exception {
    // Constructor
    public InvalidPasswordException(String message) {
        super(message);
    }
}
