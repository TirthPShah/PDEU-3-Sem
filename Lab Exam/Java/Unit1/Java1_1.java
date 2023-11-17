import java.util.*;

public class Java1_1 {
    
    public static boolean isPrime(int n) {
       
        for(int i=2; i<n; i++) {
            if(n%i == 0) {
                return false;
            }
        }
        
        return true;
    }
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number n for first n prime numbers: ");
        int count = sc.nextInt();

        int i=2;

        while(count != 0) {
            if(isPrime(i)) {
                System.out.print(i + " ");
                count--;
            }
            i++;
        }

        System.out.println();

        sc.close();
    }
}