import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompting user for input
        System.out.print("Enter the designation (Manager = 1/Developer = 2/Intern 3): ");
        int designation = scanner.nextInt();

        System.out.print("Enter years of experience: ");
        int experience = scanner.nextInt();

        double baseSalary = 0;
        double bonus = 0;
        double finalSalary;

        // Determine base salary based on designation
        switch (designation) {
            case 1:
                baseSalary = 50000;
                break;
            case 2:
                baseSalary = 30000;
                break;
            case 3:
                baseSalary = 15000;
                break;
            default:
                System.out.println("Invalid designation! Please enter Manager 1, Developer 2, or Intern 3.");
                scanner.close();
                return;
        }
        // Calculate bonus based on experience
        if (experience >= 3 && experience <= 5) {
            bonus = 0.10 * baseSalary;
        } else if (experience > 5) {
            bonus = 0.20 * baseSalary;
        }
        // Calculate final salary
        finalSalary = baseSalary + bonus;
        System.out.println("\nEmployee Details   :");
        System.out.println("Designation            :" + ((designation == 1) ? "Manager"
                : (designation == 2) ? "Developer" : (designation == 3) ? "Intern" : "Unknown"));
        System.out.println("Experience             : " + experience + " years");
        System.out.println("Base Salary            : " + baseSalary + "₹");
        System.out.println("Bonus                  :" + bonus + " ₹");
        System.out.println("Final Salary           : " + finalSalary + "₹");

        scanner.close();
    }
}