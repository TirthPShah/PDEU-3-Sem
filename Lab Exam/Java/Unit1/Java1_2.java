import java.util.*;

public class Java1_2 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the first number: ");
        double a = sc.nextDouble();

        System.out.println();
        
        System.out.print("Enter the second number: ");
        double b = sc.nextDouble();

        System.out.println("\nAdd\t Subtract\t Multiply\t Divide\t Modulo\t Power");

        System.out.println();

        System.out.print("Enter your choice: ");
        String choice = sc.next();

        switch (choice) {

            case "Add":
                System.out.println("\nThe sum of the given numbers is: " + (a+b));
                break;

            case "Subtract":
                System.out.println("\nThe difference of the given numbers is: " + (a-b));
                break;

            case "Multiply":
                System.out.println("\nThe product of the given numbers is: " + (a*b));
                break;

            case "Divide":
                System.out.println("\nThe quotient of the given numbers is: " + (a/b));
                break;

            case "Modulo":
                System.out.println("\nThe remainder of the given numbers is: " + (a%b));
                break;

            case "Power":
                System.out.println("\nThe power of the given numbers is: " + Math.pow(a, b));
                break;
        
            default:
                System.out.println("\nInvalid operator provided");
                break;
        }
        
        System.out.println();

        sc.close();
    }
}