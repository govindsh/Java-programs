import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Parameters;

public class TestArea {
	
	@Test(groups = {"rectangleTests"}) // - Perimeter of rectangle
	public void TestRectanglePerimeter() {
		System.out.println("Running Test for Rectangle Shape - perimeter");
		ShapesArea shapeRectangle = new Rectangle(3.0,4.0);
		double perimeter = shapeRectangle.perimeter();
		System.out.println(perimeter);
		Assert.assertEquals(14.0,perimeter);
	}
	
	@Test(groups = {"triangleTests"}) // - Area of Triangle
	public void TestAreaTriangle() {
		System.out.println("Running test for Triangle Shape - Area");
		ShapesArea shapeTriangle = new Triangle(5.0,6.0,8.0);
		double areaTriangle = shapeTriangle.area();
		System.out.println(areaTriangle);
		Assert.assertEquals(15.0, areaTriangle);
	}
	
	@Test(groups = {"squareTests"}) // - Area of Square
	public void TestSquareArea() {
		System.out.println("Running Test for Square Shape - Area");
		ShapesArea shapeSquare = new Square(4.0);
		double areaSquare = shapeSquare.area();
		System.out.println(areaSquare);
		Assert.assertEquals(16.0,areaSquare);
	}
	
	@Test(enabled = false) // - Area of circle
	public void TestCircleArea() {
		System.out.println("Running Test for Circle Shape - Area");
		double radius = 2.5;
		ShapesArea shapeCircle = new Circle(radius);
		double area = shapeCircle.area();
		System.out.println(area);
		Assert.assertEquals(19.635,area,0.05);
	}
	@Test // - Circumference of circle
	@Parameters("radius")
	public void TestCircleCircumference() {
		System.out.println("Running Test for Circle Shape - Area");
		double radius = 2.5;
		ShapesArea shapeCircle = new Circle(radius);
		double circumference = shapeCircle.circumference();
		System.out.println(circumference);
		Assert.assertEquals(15.708,circumference,0.05);
	}
	
	@Test(groups = {"squareTests"}) // - Perimeter of Square
	public void TestSquarePerimeter() {
		System.out.println("Running Test for Square Shape - Perimeter");
		ShapesArea shapeSquare = new Square(2.0);
		double perimeterSquare = shapeSquare.perimeter();
		System.out.println(perimeterSquare);
		Assert.assertEquals(8.0,perimeterSquare);
	}
	
	@Test(groups = {"triangleTests"}) // - Perimeter of Triangle
	public void TestPerimeterTriangle() {
		System.out.println("Running test for Triangle Shape - Perimeter");
		ShapesArea shapeTriangle = new Triangle(5.0,6.0,8.0);
		double perimeterTriangle = shapeTriangle.perimeter();
		System.out.println(perimeterTriangle);
		Assert.assertEquals(19.0, perimeterTriangle);
	}
	
	@Test(groups = {"rectangleTests"}) // - Diagnol of rectangle
	public void TestRectangleDiagnol() {
		System.out.println("Running Test for Rectangle Shape - diagnol");
		ShapesArea shapeRectangle = new Rectangle(3.0,4.0);
		double diagnol = shapeRectangle.diagnol();
		System.out.println(diagnol);
		Assert.assertEquals(5.0,diagnol);
	}
}