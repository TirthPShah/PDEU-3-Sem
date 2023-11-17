import java.util.*;

public class Java1_7 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("\nNaturalLog\t LogBase10\t Sin\t Cos\t Tan\t StandardExponent\t Power\t HyperbolicsSin\t HyperbolicsCos\t HyperbolicsTan\t");

        System.out.print("\nEnter the opeation to perform: ");
        String oper = sc.next();

        System.out.print("Enter the first arguement: ");
        double a = sc.nextDouble();

        System.out.print("Enter the second arguement (if applicable else 0): ");
        double b = sc.nextDouble();

        switch(oper) {
            case "NaturalLog":
                System.out.println("The natural log of " + a + " is: " + Math.log(a));
                break;
            case "LogBase10":
                System.out.println("The log base 10 of " + a + " is: " + Math.log10(a));
                break;
            case "Sin":
                System.out.println("The sin of " + a + " is: " + Math.sin(a));
                break;
            case "Cos":
                System.out.println("The cos of " + a + " is: " + Math.cos(a));
                break;
            case "Tan":
                System.out.println("The tan of " + a + " is: " + Math.tan(a));
                break;
            case "StandardExponent":
                System.out.println("The standard exponent of " + a + " is: " + Math.exp(a));
                break;
            case "Power":
                System.out.println("The power of " + a + " raised to " + b + " is: " + Math.pow(a, b));
                break;
            case "HyperbolicsSin":
                System.out.println("The hyperbolics sin of " + a + " is: " + Math.sinh(a));
                break;
            case "HyperbolicsCos":
                System.out.println("The hyperbolics cos of " + a + " is: " + Math.cosh(a));
                break;
            case "HyperbolicsTan":
                System.out.println("The hyperbolics tan of " + a + " is: " + Math.tanh(a));
                break;

            default:
                System.out.println("Invalid operation!");
        }

        sc.close();
    }
}
