import java.util.Scanner;

// Main
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter details for Full-Time Employee:");
        System.out.print("ID: ");
        int fullTimeId = scanner.nextInt();
        scanner.nextLine(); // delete buffer
        System.out.print("Name: ");
        String fullTimeName = scanner.nextLine();
        System.out.print("Monthly Salary: ");
        double monthlySalary = scanner.nextDouble();
        Employee fullTimeEmployee = new FullTimeEmployee(fullTimeName, fullTimeId, monthlySalary);

        System.out.println("\nEnter details for Part-Time Employee:");
        System.out.print("ID: ");
        int partTimeId = scanner.nextInt();
        scanner.nextLine(); // delete buffer
        System.out.print("Name: ");
        String partTimeName = scanner.nextLine();
        System.out.print("Hourly Rate: ");
        double hourlyRate = scanner.nextDouble();
        System.out.print("Hours Worked: ");
        int hoursWorked = scanner.nextInt();
        Employee partTimeEmployee = new PartTimeEmployee(partTimeName, partTimeId, hourlyRate, hoursWorked);

        // Display employee details
        System.out.println("\nEmployee Details:");
        fullTimeEmployee.displayDetails();
        System.out.println();
        partTimeEmployee.displayDetails();

        scanner.close();
    }
}

// Abstract class Employee
abstract class Employee {
    protected String name;
    protected int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Abstract method to calculate salary
    public abstract double calculateSalary();

    public void displayDetails() {
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + calculateSalary());
    }
}

// Subclass FullTimeEmployee
class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

// Subclass PartTimeEmployee
class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(String name, int id, double hourlyRate, int hoursWorked) {
        super(name, id);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}
