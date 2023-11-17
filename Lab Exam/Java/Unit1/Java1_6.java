import java.util.*;

public class Java1_6 {

    public static double getArea(double a, double b) {
        return a*b;
    }

    public static double getArea(double a) {
        return Math.PI * a * a;
    }

    public static double getArea(double a, double b, String s) {
        
        if(s.equals("Ellipse")) {
            return Math.PI * a * b;
        }

        if(s.equals("Triangle")) {
            return 0.5 * a * b;
        }

        else {
            return -1;
        }
    }

    public static double getArea(double a, double b, double c) {
        return a * (b+c) * 0.5;
    }

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println();

        System.out.print("Enter the name of the shape: ");
        String shape = sc.next();

        System.out.print("Enter the length of height: ");
        double a = sc.nextDouble();

        System.out.print("Enter the length of base: ");
        double b = sc.nextDouble();

        System.out.print("Enter the another parallel side (Only in case of trapezium): ");
        double c = sc.nextDouble();

        
        if(shape.equals("Rectangle")) {
            System.out.println("The area of the rectangle is: " + getArea(a, b));
        }

        else if(shape.equals("Circle")) {
            System.out.println("The area of the circle is: " + getArea(a));
        }

        else if(shape.equals("Trapezium")) {
            System.out.println("The area of the trapezium is: " + getArea(a, b, c));
        }

        else if(shape.equals("Triangle")) {
            System.out.println("The area of the triangle is: " + getArea(a, b, shape));
        }

        else if(shape.equals("Ellipse")) {
            System.out.println("The area of the ellipse is: " + getArea(a, b, shape));
        }

        sc.close();
    }
}