package PDEU.Drawing;

public class Rectangle extends Shape {
    
    double length;
    double width;

    public Rectangle(String colour, String pattern, double length, double width) {
        this.color = colour;
        this.pattern = pattern;
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
    
    public String toString() {
        return "Rectangle:\nColor: " + this.color + " Pattern: " + this.pattern + " Length: " + this.length + " Width: " + this.width;
    }
}
