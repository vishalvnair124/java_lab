
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
        }
    }

    public static void main(String[] args) {
        try {
            validatePhoneNumber("98765432"); // Example of an invalid phone number
        } catch (InvalidPhoneNumberException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}