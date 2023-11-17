package PDEU.Drawing;

public class Circle extends Shape implements Resizable {
    
    public double radius;

    public Circle(String colour, String pattern, double radius) {
        this.color = colour;
        this.pattern = pattern;
        this.radius = radius;
    }
    
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    public void resize(int factor) {
        this.radius *= factor;
    }

    public String toString() {
        return "Circle:\nColor: " + this.color + " Pattern: " + this.pattern + " Radius: " + this.radius;
    }
}
