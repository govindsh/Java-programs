// Geometry Calculator - Finds area, perimeter for different shapes.
// Uses Java concepts like inheritance, loops, Conditional flow, accepting input, regex.

// Java Imports
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.*;
import javax.mail.internet.*;

// Class Declaration
class Area {
    // Main function
    public static void main(String[] args) {
        // Local Variables pertaining to Shapes
        double circleArea, circleCircumference;
        double rectangleArea, rectangleDiagnol, rectanglePerimeter;
        double squareArea, squarePerimeter, squareDiagnol;
        double triangleArea, trianglePerimeter;

        // Other variables
        String optionsMenu;
        String continueChoice = "y";

        // Start the loop
        while (true) {
            // Display the Menu
            System.out.println("***************************");
            System.out.println("\t Geometry Calculator \t");
            System.out.println("***************************");
            System.out.println("Choose a shape to calculate it's different aspects");
            String Menu = "1.Circle\n2.Rectangle\n3.Square\n4.Triangle\n5.Exit";
            System.out.println(Menu);

            // Get user's choice
            System.out.println("Enter your choice - ");
            Scanner inputReader = new Scanner(System.in);
            int choice = inputReader.nextInt(); // Accepts only integer

            // Start switch case based on Input
            switch (choice) {
                case 1:
                    // Shape - Circle
                    double radius;
                    System.out.println("Shape - Circle");

                    // Get the radius from user
                    System.out.println("Please enter the radius");
                    radius = inputReader.nextDouble();

                    // Create instance for shape circle
                    ShapesArea s1 = new Circle(radius);

                    // Display functions
                    optionsMenu = "Calculate:\n1.Circumference\n2.Area";
                    System.out.println(optionsMenu);

                    // Accept the input for function to be performed.
                    int circleChoice = inputReader.nextInt();

                    switch (circleChoice) {
                        // Circle Operations
                        case 1:
                            System.out.println("Let's calculate the circumference");
                            circleCircumference = s1.circumference();
                            System.out.println("Circumference of circle with radius " + radius + " is " + circleCircumference);
                            break;
                        case 2:
                            System.out.println("Let's calculate the Area.");
                            circleArea = s1.area();
                            System.out.println("Area of circle with radius " + radius + " is " + circleArea);
                            break;
                        default:
                            System.out.println("Invalid choice!");
                            break;
                    } // end circleChoice switch
                    break; // end case 1:
                case 2:
                    // Shape - Rectangle
                    double length, breadth;
                    System.out.println("Shape - Rectangle");

                    // Accept input from user for height and breadth
                    System.out.println("Enter the height and breadth:");
                    length = inputReader.nextDouble();
                    breadth = inputReader.nextDouble();

                    // Create instance for Shape - Rectangle
                    ShapesArea s2 = new Rectangle(length, breadth);

                    // Display Options Menu for different functions
                    optionsMenu = "Calculate:\n1.Perimeter\n2.Area\n3.Diagnol";
                    System.out.println(optionsMenu);

                    // Accept users input for function to be performed
                    int rectangleChoice = inputReader.nextInt();

                    // Start switch case based on function
                    switch (rectangleChoice) {
                        case 1:
                            // Rectangle Operations
                            System.out.println("Let's calculate perimeter of rectangle");
                            rectanglePerimeter = s2.perimeter();
                            System.out.println("Perimeter of rectangle with length= " + length + " and breadth= " + breadth + " is " + rectanglePerimeter);
                            break;
                        case 2:
                            System.out.println("Let's calculate the Area of rectangle.");
                            rectangleArea = s2.area();
                            System.out.println("Area of rectangle with length= " + length + " and breadth= " + breadth + " is " + rectangleArea);
                            break;
                        case 3:
                            System.out.println("Let's calculate the diagnol of the rectangle");
                            rectangleDiagnol = s2.diagnol();
                            System.out.println("Diagnol of rectangle with length= " + length + " and breadth= " + breadth + " is " + rectangleDiagnol);
                            break;
                        default:
                            System.out.println("Invalid choice!");
                            break;
                    } // end switch rectangleChoice
                    break; // end case 2
                case 3:
                    // Shape - Square
                    double side;
                    System.out.println("Shape - Square");

                    // Get user input for side
                    System.out.println("Enter the side measurement of the square:");
                    side = inputReader.nextDouble();

                    // Create new shape instance for square
                    ShapesArea s3 = new Square(side);

                    // Display options Menu for square functions
                    optionsMenu = "Calculate:\n1.Perimeter\n2.Area\n3.Diagnol";
                    System.out.println(optionsMenu);

                    // Get choice from user for function to be performed.
                    int squareChoice = inputReader.nextInt();

                    switch (squareChoice) {
                        // Square functions
                        case 1:
                            System.out.println("Let's calculate perimeter of square");
                            squarePerimeter = s3.perimeter();
                            System.out.println("Perimeter of square with side= " + side + " is " + squarePerimeter);
                            break;
                        case 2:
                            System.out.println("Let's calculate the Area of square.");
                            squareArea = s3.area();
                            System.out.println("Area of square with side= " + side + " is " + squareArea);
                            break;
                        case 3:
                            System.out.println("Let's calculate the diagnol of the square");
                            squareDiagnol = s3.diagnol();
                            System.out.println("Diagnol of square with side= " + side + " is " + squareDiagnol);
                            break;
                        default:
                            System.out.println("Invalid choice!");
                            break;
                    } // end switch squareChoice
                    break;
                case 4:
                    // Shape - Triangle
                    double base, height, triangleSide;
                    System.out.println("Shape - Triangle");

                    // Get input for base and height from user.
                    System.out.println("Enter the base and height measurement of the Triangle:");
                    base = inputReader.nextDouble();
                    height = inputReader.nextDouble();
                    System.out.println("Enter the side measurement (needed for calculating perimeter, if not necessary enter 0)- ");
                    triangleSide = inputReader.nextDouble();

                    // Create new shape instance for Triangle
                    ShapesArea s4 = new Triangle(base, height, triangleSide);

                    // Display optionsMenu
                    optionsMenu = "Calculate:\n1.Perimeter\n2.Area";
                    System.out.println(optionsMenu);

                    // Get input from user for function to be performed.
                    int triangleChoice = inputReader.nextInt();

                    // Absorb the next newline since nextInt() doesn't process it.
                    inputReader.nextLine();
                    
                    switch (triangleChoice) {
                        // Triangle Operations
                        case 1:
                            System.out.println("Let's calculate perimeter of Triangle");
                            trianglePerimeter = s4.perimeter();
                            System.out.println("Perimeter of Triangle with side= " + triangleSide + " height= " + height + " and base= " + base + " is " + trianglePerimeter);
                            break;
                        case 2:
                            System.out.println("Let's calculate the Area of Triangle.");
                            triangleArea = s4.area();
                            System.out.println("Area of Triangle with height= " + height + " and base= " + base + " is " + triangleArea);
                            break;
                        default:
                            System.out.println("Invalid choice!");
                            break;
                    }// end switch triangleChoice
                    break;
                case 5:
                    // Option to exit from the calculator
                    System.out.println("Thanks for using my Geometry calculator");
                    System.exit(0);
                    break;
                default:
                    // Default choice
                    System.out.println("Invalid choice!! Please enter anything from 1-5.");
                    break;
            }
            // Continue the program if user selects yes
            System.out.println("Do you want to continue? (y/n)");
            continueChoice = inputReader.next(); // Accepts any token

            // Build the regex. Compile the pattern.
            Pattern p = Pattern.compile("[yY]e?s?");

            // Create a matcher object
            Matcher m = p.matcher(continueChoice);

            // If matches, continue - else exit
            if (m.matches()) {
                continue;
            } else {
                System.out.println("Thanks for using my Geometry calculator");
                System.exit(0);
            }
            inputReader.close();
        }
    }
}