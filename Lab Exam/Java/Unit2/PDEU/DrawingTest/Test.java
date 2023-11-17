package PDEU.DrawingTest;

import PDEU.Drawing.*;

public class Test {

    public static void highestArea(Shape[] shapes) {

        double max = 0;
        int currIndex = 0;
        int maxIndex = 0;

        for (Shape shape : shapes) {

            if (shape.calculateArea() > max) {
                max = shape.calculateArea();
                maxIndex = currIndex;
            }

            currIndex++;

        }

        System.out.println("Shape with highest area:\n" + shapes[maxIndex]);

    }

    public static void resizableShapes(Shape[] shapes) {

        for (Shape shape : shapes) {
            if (shape instanceof Resizable) {
                System.out.println(shape + "\n");
            }
        }

    }

    public static double totalDecorativeMaterialForCircle(Shape[] shapes) {

        double total = 0;
        double costPerMeter = 10;

        for (Shape shape : shapes) {
            if (shape instanceof Circle) {
                total += (costPerMeter * shape.calculatePerimeter());
            }
        }

        return total;

    }
    public static void main(String[] args) {

        Rectangle r = new Rectangle("Yellow", "Rect", 10, 20);
        Triangle t = new Triangle("Yellow", "Tri", 10, 20, 30);
        Circle c = new Circle("Yellow", "Cir", 20);
        Square s = new Square("Yellow", "Square", 20);

        Shape[] shapes = { r, t, c, s };

        System.out.println("\n\n- - - - Printing the details of the shape with highest area - - - -\n");
        highestArea(shapes);

        System.out.println("\n\n- - - - Printing the details of all the shapes which are resizable - - - -\n");
        resizableShapes(shapes);

        System.out.println("\n\n- - - - Printing the total decorative material required for all the circles - - - -\n");
        System.out.println("Total Decorative Material For Circle: Rs." + totalDecorativeMaterialForCircle(shapes) + "\n");
    }
}
