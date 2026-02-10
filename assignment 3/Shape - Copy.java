abstract class Shape {
    protected double dim1;
    protected double dim2;
    public Shape(double dim1, double dim2) {
        this.dim1 = dim1;
        this.dim2 = dim2;
    }
    abstract double area();
}
class Rectangle extends Shape {
    public Rectangle(double length, double breadth) {
        super(length, breadth);
    }
    @Override
    double area() {
        return dim1 * dim2;
    }
}
class Triangle extends Shape {
    public Triangle(double base, double height) {
        super(base, height);
    }
    @Override
    double area() {
        return 0.5 * dim1 * dim2;
    }
}
public class Main {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(10, 5);
        Shape triangle = new Triangle(8, 6);
        System.out.println("Area of Rectangle: " + rectangle.area());
        System.out.println("Area of Triangle: " + triangle.area());
    }
}
