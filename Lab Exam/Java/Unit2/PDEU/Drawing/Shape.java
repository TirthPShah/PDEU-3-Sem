package PDEU.Drawing;

public abstract class Shape {
    
    String color;
    String pattern;
    static int count;

    {
        count++;
    }

    public abstract double calculateArea();

    public abstract double calculatePerimeter();

    static int countshapes() {
        return count;
    }

}