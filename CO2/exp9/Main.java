
//  abstract method calculateArea()

public class Main {
    public static void main(String[] args) {
        // Create instances of Triangle and Rectangle
        Shape triangle = new Triangle(5, 10);
        Shape rectangle = new Rectangle(4, 6);

        // Demonstrate polymorphism by calling calculateArea() on Shape references
        System.out.println("Area of Triangle: " + triangle.calculateArea());
        System.out.println("Area of Rectangle: " + rectangle.calculateArea());
    }
}

interface Shape {
    double calculateArea();
}

// Triangle class
class Triangle implements Shape {
    private double base;
    private double height;

    // Constructor
    public Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    // Override the calculateArea() method to compute the area of the triangle
    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }
}

// Rectangle class
class Rectangle implements Shape {
    private double length;
    private double width;

    // Constructor
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // Override the calculateArea() method to compute the area of the rectangle
    @Override
    public double calculateArea() {
        return length * width;
    }
}
