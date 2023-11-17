import java.util.*;

class Printer {

    boolean isOdd = false;
    
    public synchronized void printOdd(int i) {

        while (isOdd) {
            
            try {
                wait();
            } 
            
            catch (Exception e) {
                System.out.println(e);
            }
        }

        System.out.println("Odd: " + i);
        isOdd = true;
        notify();

    }

    public synchronized void printEven(int i) {

        while (!isOdd) {

            try {
                wait();
            }

            catch (Exception e) {
                System.out.println(e);
            }
        }

        System.out.println("Even: " + i);
        isOdd = false;
        notify();

    }

}

class PrintEven extends Thread {
    
    Printer p;
    int num;

    public PrintEven (Printer p, int num) {
        this.p = p;
        this.num = num;
    }

    public void run() {

        for(int i = 2; i <= num; i = i + 2) {   
            p.printEven(i);
        }

    }
}

class PrintOdd extends Thread {
    
    Printer p;
    int num;

    public PrintOdd(Printer p, int num) {
        this.p = p;
        this.num = num;
    }

    public void run() {

        for(int i = 1; i <= num; i = i + 2) {
            p.printOdd(i);
        }

    }
}
public class Java3_11 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner (System.in);

        Printer p = new Printer();

        System.out.print("Enter the number of elements you want to print: ");
        int n = sc.nextInt();

        PrintEven pe = new PrintEven(p, n);
        PrintOdd po = new PrintOdd(p, n);

        po.start();
        pe.start();
        
        try {
            sc.close();
        }

        catch (Exception e) {
            System.out.println(e);
        }
        
    }
}