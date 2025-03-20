import java.util.Scanner;

// Main class 
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of teachers: ");
        int n = scanner.nextInt();
        Teacher[] teachers = new Teacher[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Teacher " + (i + 1) + ":");

            scanner.nextLine(); // Delete buffer
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Gender: ");
            String gender = scanner.nextLine();
            System.out.print("Address: ");
            String address = scanner.nextLine();
            System.out.print("Age: ");
            int age = scanner.nextInt();

            System.out.print("Employee ID: ");
            int empId = scanner.nextInt();
            scanner.nextLine(); // Delete buffer
            System.out.print("School Name: ");
            String schoolName = scanner.nextLine();
            System.out.print("Qualification: ");
            String qualification = scanner.nextLine();
            System.out.print("Salary: ");
            double salary = scanner.nextDouble();

            scanner.nextLine(); // Delete buffer
            System.out.print("Subject: ");
            String subject = scanner.nextLine();
            System.out.print("Department: ");
            String department = scanner.nextLine();
            System.out.print("Teacher ID: ");
            int teacherId = scanner.nextInt();

            teachers[i] = new Teacher(name, gender, address, age, empId, schoolName, qualification, salary, subject,
                    department, teacherId);
        }

        System.out.println("\n------------Teacher Details-------------");
        for (Teacher teacher : teachers) {
            teacher.displayDetails();
        }

        scanner.close();
    }
}

// class Person
class Person {
    protected String name;
    protected String gender;
    protected String address;
    protected int age;

    public Person(String name, String gender, String address, int age) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.age = age;
    }
}

// Employee class inheriting from Person
class Employee extends Person {
    protected int empId;
    protected String schoolName;
    protected String qualification;
    protected double salary;

    public Employee(String name, String gender, String address, int age, int empId, String schoolName,
            String qualification, double salary) {
        super(name, gender, address, age);
        this.empId = empId;
        this.schoolName = schoolName;
        this.qualification = qualification;
        this.salary = salary;
    }
}

// Teacher class inheriting from Employee
class Teacher extends Employee {
    private String subject;
    private String department;
    private int teacherId;

    public Teacher(String name, String gender, String address, int age, int empId, String schoolName,
            String qualification, double salary, String subject, String department, int teacherId) {
        super(name, gender, address, age, empId, schoolName, qualification, salary);
        this.subject = subject;
        this.department = department;
        this.teacherId = teacherId;
    }

    public void displayDetails() {
        System.out.println("Teacher ID: " + teacherId);
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);
        System.out.println("Address: " + address);
        System.out.println("Age: " + age);
        System.out.println("Employee ID: " + empId);
        System.out.println("School: " + schoolName);
        System.out.println("Qualification: " + qualification);
        System.out.println("Salary: " + salary);
        System.out.println("Subject: " + subject);
        System.out.println("Department: " + department);
        System.out.println("--------------------------------");
    }
}
