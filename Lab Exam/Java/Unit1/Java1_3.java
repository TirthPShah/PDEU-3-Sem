import java.util.*;

public class Java1_3 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.print("\nEnter the marks of first subject: ");
        double a = sc.nextDouble();

        System.out.print("\nEnter the marks of second subject: ");
        double b = sc.nextDouble();

        System.out.print("\nEnter the marks of third subject: ");
        double c = sc.nextDouble();

        System.out.print("\nEnter the marks of fourth subject: ");
        double d = sc.nextDouble();

        System.out.print("\nEnter the marks of fifth subject: ");
        double e = sc.nextDouble();

        System.out.print("\nEnter the marks of sixth subject: ");
        double f = sc.nextDouble();

        double ans = (a+b+c+d+e+f)/6;

        System.out.println("\nFinal Percentage: " + String.format("%.2f", ans) + "%.");

        System.out.println();

        sc.close();
    }
}
