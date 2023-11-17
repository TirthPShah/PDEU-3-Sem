package PDEU.Drawing;

public class Square extends Shape implements Resizable  {
    
    public double length;

    public Square(String colour, String pattern, double length) {
        this.color = colour;
        this.pattern = pattern;
        this.length = length;
    }

    @Override
    public double calculateArea() {
        return length * length;
    }

    @Override
    public double calculatePerimeter() {
        return 4 * length;
    }

    @Override
    public void resize(int factor) {
        // Adjust the side length based on the resizing factor.
        this.length *= factor;
    }

    public String toString() {
        return "Square:\nColor: " + this.color + " Pattern: " + this.pattern + " Length: " + this.length;
    }
}
