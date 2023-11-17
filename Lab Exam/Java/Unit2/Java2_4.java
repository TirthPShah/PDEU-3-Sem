class Rectangle {
    int length;
    int breadth;

    public Rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }
}

public class Java2_4 {

    public static void main(String[] args) {
        
        // Passing by value

        int a = 5;
        System.out.println("Before: a = " + a);
        modifyValue(a);
        System.out.println("After: a = " + a + "\n");

        // Returning values

        int result = add(3, 4);
        System.out.println("Sum: " + result + "\n");

        // Returning objects

        Rectangle r1 = createRectangle(10, 20);
        System.out.println("r1: Length: " + r1.length + ", Breadth: " + r1.breadth + "\n");

        // Passing object's items by reference

        Rectangle r2 = new Rectangle(30, 40);
        System.out.println("Before (r2): Length: " + r2.length + ", Breadth: " + r2.breadth);
        modifyObject(r2);
        System.out.println("After (r2): Length: " + r2.length + ", Breadth: " + r2.breadth);
    }

    // Passing by value
    static void modifyValue(int a) {
        a = a * 2;
        System.out.println("Inside method: a = " + a);
    }

    // Returning values
    static int add(int a, int b) {
        return a + b;
    }

    // Returning objects
    static Rectangle createRectangle(int length, int breadth) {
        return new Rectangle(length, breadth);
    }

    // Passing objects by reference (reference passed by value)
    static void modifyObject(Rectangle r) {
        r.length = r.length * 2;
        r.breadth = r.breadth * 2;
        System.out.println("Inside method: Length: " + r.length + ", Breadth: " + r.breadth);
    }
}