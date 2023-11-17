class ChildThread1 extends Thread {

    public void run() {

        for (int i = 1; i <= 250; i++) {

            System.out.println(Thread.currentThread().getName() + " " +i);

        }
    }

}

class ChildThread2 implements Runnable {

    public void run() {

        for (int i = 251; i <= 500; i++) {

            System.out.println(Thread.currentThread().getName() + " " +i);

        }
    }
    
}

public class Java3_7 {

    public static void main(String[] args) {
        
        ChildThread1 ct1 = new ChildThread1();
        Thread ct2 = new Thread(new ChildThread2());
        
        Thread.currentThread().setName("Main Thread"); 
        ct1.setName("Child Thread 1");
        ct2.setName("Child Thread 2");

        ct1.start();
        ct2.start();

        for (int i = 501; i <= 750; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }

    }
    
}