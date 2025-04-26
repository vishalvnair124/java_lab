import java.sql.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class EmployeeManagementSystem {

    static final String DB_URL = "jdbc:mysql://localhost:3306/javaapp";
    static final String USER = "root";
    static final String PASS = "";

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        int choice;
        do {
            System.out.println("\n1. Add Employee\n2. View All\n3. Update by ID\n4. Delete by ID\n5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1 -> addEmployee(conn);
                case 2 -> viewEmployees(conn);
                case 3 -> updateEmployee(conn);
                case 4 -> deleteEmployee(conn);
            }
        } while (choice != 5);

        conn.close();
    }

    static void addEmployee(Connection conn) throws SQLException {
        System.out.print("Name: ");
        sc.nextLine();
        String name = sc.nextLine();

        String email;
        while (true) {
            System.out.print("Email: ");
            email = sc.nextLine();
            if (Pattern.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", email))
                break;
            else
                System.out.println("Invalid email format.");
        }

        System.out.print("Salary: ");
        double salary = sc.nextDouble();

        String query = "INSERT INTO employees (name, email, salary) VALUES (?, ?, ?)";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, name);
        pst.setString(2, email);
        pst.setDouble(3, salary);
        pst.executeUpdate();
        System.out.println("Employee added.");
    }

    static void viewEmployees(Connection conn) throws SQLException {
        ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM employees");
        System.out.printf("%-5s %-20s %-25s %-10s\n", "ID", "Name", "Email", "Salary");
        System.out.println("-----------------------------------------------------------");
        while (rs.next()) {
            System.out.printf("%-5d %-20s %-25s %-10.2f\n",
                    rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getDouble("salary"));
        }
    }

    static void updateEmployee(Connection conn) throws SQLException {
        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("New Name: ");
        String name = sc.nextLine();

        String email;
        while (true) {
            System.out.print("New Email: ");
            email = sc.nextLine();
            if (Pattern.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", email))
                break;
            else
                System.out.println("Invalid email format.");
        }

        System.out.print("New Salary: ");
        double salary = sc.nextDouble();

        String query = "UPDATE employees SET name=?, email=?, salary=? WHERE id=?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setString(1, name);
        pst.setString(2, email);
        pst.setDouble(3, salary);
        pst.setInt(4, id);
        int rows = pst.executeUpdate();
        System.out.println(rows > 0 ? "Employee updated." : "Employee not found.");
    }

    static void deleteEmployee(Connection conn) throws SQLException {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();

        String query = "DELETE FROM employees WHERE id=?";
        PreparedStatement pst = conn.prepareStatement(query);
        pst.setInt(1, id);
        int rows = pst.executeUpdate();
        System.out.println(rows > 0 ? "Employee deleted." : "Employee not found.");
    }
}
