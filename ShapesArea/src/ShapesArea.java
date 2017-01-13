// Public Class containing methods for Shapes
// Java Imports
import java.lang.Math;

// Class declaration
public class ShapesArea {
    // Default constructor method for area.
    public double area (){
        return 0;
    }

    // Default constructor method for circumference.
    public double circumference (){
        return 0;
    }

    // Default constructor method for perimeter.
    public double perimeter(){
        return 0;
    }

    // Default constructor method for diagnol.
    public double diagnol() {
        return 0;
    }
}

// New class circle inheriting ShapesArea (extends keyword is used for inheritance)
class Circle extends ShapesArea {
    private final double PI = Math.PI; // Math constant PI = 3.14
    private double radius;
    // Constructor method
    Circle (double radius) {
        this.radius = radius;
    }

    // Area of circle
    public double area() {
        return PI * radius * radius ;
    }

    // Circumference of circle
    public double circumference() {
        return PI * 2 * radius ;
    }
}

// New class Rectangle inheriting ShapesArea (extends keyword is used for inheritance)
class Rectangle extends ShapesArea {
    private double length;
    private double breadth;
    // Constructor method
    Rectangle (double length, double breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    // Area of rectangle
    public double area() {
        return length * breadth;
    }

    // Perimeter of rectangle
    public double perimeter(){
        return 2 * (length + breadth);
    }

    // Diagnol of rectangle
    public double diagnol(){
        return Math.sqrt((length * length) + (breadth * breadth));
    }
}

// New class Square inheriting ShapesArea (extends keyword is used for inheritance)
class Square extends ShapesArea {
    private double side;

    // Constructor Square
    Square (double side) {
        this.side = side;
    }

    // Area of Square
    public double area(){
        return side * side;
    }

    // Perimeter of Square
    public double perimeter(){
        return 4 * side;
    }

    // Diagnol of Square
    public double diagnol(){
        return Math.sqrt(2) * side;
    }
}

// New class Triangle inheriting ShapesArea (extends keyword is used for inheritance)
class Triangle extends ShapesArea {
    private double base, height, side;
    // Constructor method
    Triangle(double base, double height, double side) {
        this.base = base;
        this.height = height;
        this.side = side;
    }

    // Area of Triangle
    public double area() {
        return 0.5 * base * height;
    }

    // Perimeter of Triangle
    public double perimeter(){
        return base + height + side;
    }
}