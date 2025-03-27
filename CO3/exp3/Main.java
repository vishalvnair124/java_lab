
// Custom exception for invalid grades
class InvalidGradeException extends Exception {
    public InvalidGradeException(String message) {
        super(message);
    }
}

public class Main {
    // Validates if the grade is between 'A' and 'F'
    public static void validateGrade(char grade) throws InvalidGradeException {
        if (grade < 'A' || grade > 'F') {
            throw new InvalidGradeException("Invalid grade! Grade must be between 'A' and 'F'.");
        }
    }

    public static void main(String[] args) {
        try {
            validateGrade('G'); // Example of an invalid grade
        } catch (InvalidGradeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}