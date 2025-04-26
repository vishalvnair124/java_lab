
// Custom exception for invalid grades

import java.util.Scanner;

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
        } else {
            System.out.print("Aowsome grade");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Enter a grade :");
            String grade = sc.nextLine();
            validateGrade(grade.charAt(0)); // Example of an invalid grade
        } catch (InvalidGradeException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}