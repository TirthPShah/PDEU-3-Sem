import java.util.*;

class ChildThread1 extends Thread{

    int n1;

    public ChildThread1(int n1) {
        this.n1 = n1;
    }

    public void run() {

        for(int i = 1; i <= 10; i++) {
            
            System.out.println(n1 + " * " + i + " = " + (n1 * i));
            
            try {
                Thread.sleep(500);
            }

            catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

class ChildThread2 extends Thread {

    int n2;
    Thread ct1;

    public ChildThread2(int n2, Thread ct1) {
        this.ct1 = ct1;
        this.n2 = n2;
    }


    public void run() {

        try {
            ct1.join();
        }

        catch (Exception e) {
            System.out.println(e);
        }

        for(int i = 1; i <= 10; i++) {
            System.out.println(n2 + " * " + i + " = " + (n2 * i));
        }

    }
}

public class Java3_8 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number for child thread 1: ");
        int n1 = sc.nextInt();

        System.out.print("Enter the number for child thread 2: ");
        int n2 = sc.nextInt();

        System.out.print("Enter the number for child thread 3: ");
        int n3 = sc.nextInt();

        ChildThread1 ct1 = null;
        ChildThread2 ct2 = null;
        
        try {
            ct1 = new ChildThread1(n1);
            ct2 = new ChildThread2(n2, ct1);
        }

        catch (Exception e) {
            System.out.println(e);
        }

        ct1.start();
        ct2.start();

        try {
            ct1.join();
            ct2.join();
        }

        catch (Exception e) {
            System.out.println(e);
        }

        for(int i = 1; i <= 10; i++) {
            System.out.println(n3 + " * " + i + " = " + (n3 * i));
        }

        try {
            sc.close();
        }

        catch (Exception e) {
            System.out.println(e);
        }

    }
    
}