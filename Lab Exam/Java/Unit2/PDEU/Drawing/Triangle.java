package PDEU.Drawing;

public class Triangle extends Shape {
    
    public double firstSide;
    public double secondSide;
    public double thirdSide;

    public Triangle(String color, String pattern, double firstSide, double secondSide, double thirdSide) {
        this.color = color;
        this.pattern = pattern;
        this.firstSide = firstSide;
        this.secondSide = secondSide;
        this.thirdSide = thirdSide;
    }

    @Override
    public double calculateArea() {
        
        double s = (firstSide + secondSide + thirdSide) / 2;
        return Math.sqrt(s * (s - firstSide) * (s - secondSide) * (s - thirdSide));
    }

    @Override
    public double calculatePerimeter() {
        return (firstSide + secondSide + thirdSide);
    }

    public String toString() {
        return "Triangle:\nColor: " + this.color + " Pattern: " + this.pattern + " FirstSide: " + this.firstSide + " SecondSide: " + this.secondSide + " ThirdSide: " + this.thirdSide;
    }
}
