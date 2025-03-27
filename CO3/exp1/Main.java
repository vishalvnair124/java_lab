
// Main class to 
public class Main {

    // Method to validate the password

    public static void validatePassword(String password) throws InvalidPasswordException {
        // Check if the password is at least 8 characters long
        if (password.length() < 8) {
            throw new InvalidPasswordException("Password must be at least 8 characters long.");
        }
        // Check if at least one numeric character.
        if (!password.matches(".*\\d.*")) {
            throw new InvalidPasswordException("Password must contain at least one number.");
        }
        // Check if at least one special character ($, #, &)
        if (!password.matches(".*[#$&].*")) {
            throw new InvalidPasswordException("Password must contain at least one special character ($, #, &).");
        }
    }

    public static void main(String[] args) {
        try {
            // Attempt to validate a sample password
            validatePassword("Pass#12");
        } catch (InvalidPasswordException e) {
            // Handle the exception and print the error message
            System.out.println("Error: " + e.getMessage());
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
