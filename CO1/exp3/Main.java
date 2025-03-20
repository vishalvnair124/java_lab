import java.util.Scanner;

class Main {

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for multiple students
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();

        Student[] students = new Student[numStudents];

        for (int i = 0; i < numStudents; i++) {
            System.out.println("\nEnter details for Student " + (i + 1) + ":");
            System.out.print("Student ID: ");
            int studentId = scanner.nextInt();
            scanner.nextLine(); // clear buffer
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Marks: ");
            double marks = scanner.nextDouble();

            students[i] = new Student(studentId, name, marks);
        }

        // Displaying student details
        System.out.println("\n-----Student Details----");
        for (Student student : students) {
            student.displayDetails();
            System.out.println();
        }

        scanner.close();
    }
}

class Student {
    private int studentId;
    private String name;
    private double marks;

    // Constructor to initialize all fields
    public Student(int studentId, String name, double marks) {
        this.studentId = studentId;
        this.name = name;
        this.marks = marks;
    }

    // Method to display student details
    public void displayDetails() {
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Marks: " + marks);
        System.out.println("Pass Status: " + (isPassed() ? "Passed" : "Failed"));
    }

    // Method to check if the student has passed
    public boolean isPassed() {
        return marks >= 40;
    }

}
