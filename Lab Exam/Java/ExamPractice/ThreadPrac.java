class Printer {
    public synchronized void print(int n) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + n + " * " + i + " = " + (n * i));
        }
    }
}

class ThreadA extends Thread {
    private Printer printer;
    private int n;

    public ThreadA(Printer printer, int n) {
        this.printer = printer;
        this.n = n;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((long) (Math.random() * 1000)); // Introduce a random delay
            synchronized (printer) {
                printer.print(n);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class ThreadB extends Thread {
    private Printer printer;
    private int n;

    public ThreadB(Printer printer, int n) {
        this.printer = printer;
        this.n = n;
    }

    @Override
    public void run() {
        try {
            synchronized (printer) {
                printer.print(n);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class ThreadPrac {
    public static void main(String[] args) {
        Printer printer = new Printer();

        ThreadA threadA = new ThreadA(printer, 5);
        ThreadB threadB = new ThreadB(printer, 7);

        threadA.start();
        threadB.start();
    }
}
