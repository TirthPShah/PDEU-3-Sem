class Store {

    public boolean[] isProduced;
    public int capacity = 0;

    public Store (int capacity) {
        this.capacity = capacity;
        this.isProduced = new boolean[capacity];
    }

    public synchronized void produce() {

        if(isFull()) {

            try {
                wait();
            }

            catch (Exception e) {
                System.out.println(e);
            }
        }

        while(!isFull()) {

            for(int i = 0; i < capacity; i++) {

                if(!isProduced[i]) {
                    isProduced[i] = true;
                    System.out.println("Produced at: " + i);
                }

            }

        }

        notify();

    }

    public synchronized void consume() {

        if(isEmpty()) {

            try {
                wait();
            }

            catch (Exception e) {
                System.out.println(e);
            }
        }

        while(!isEmpty()) {

            for(int i = 0; i < capacity; i++) {

                if(isProduced[i]) {
                    isProduced[i] = false;
                    System.out.println("Consumed at: " + i);
                }

            }
        }

        notify();

    }

    public boolean isFull() {

        for(int i = 0; i < capacity; i++) {
            
            if(!isProduced[i]) {
                return false;
            }

        }

        return true;
    }

    public boolean isEmpty() {

        for(int i = 0; i < capacity; i++) {
            
            if(isProduced[i]) {
                return false;
            }

        }

        return true;
    }
}

class Producer extends Thread {

    private Store s;

    public Producer(Store s) {
        this.s = s;
    }

    public void run() {
        s.produce();
    }

}

class Consumer extends Thread {

    private Store s;

    public Consumer(Store s) {
        this.s = s;
    }

    public void run() {
        s.consume();
    }

}
public class Java3_10 {
    
    public static void main(String[] args) {
        
        Store s1 = new Store(10);
        Producer p1 = new Producer(s1);
        Consumer c1 = new Consumer(s1);

        p1.start();
        c1.start();

    }
}