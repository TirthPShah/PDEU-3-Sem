import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

class Order {
    private String customerName;
    private String coffeeType;

    Order(String customerName, String coffeeType) {
        this.customerName = customerName;
        this.coffeeType = coffeeType;
    }

    String getCustomerName() {
        return customerName;
    }

    String getCoffeeType() {
        return coffeeType;
    }
}

class Producer extends Thread {
    private SharedOrderQueue sharedOrderQueue;
    private boolean[] producedElements;

    Producer(SharedOrderQueue sharedOrderQueue, boolean[] producedElements) {
        this.sharedOrderQueue = sharedOrderQueue;
        this.producedElements = producedElements;
    }

    public void run() {
        for (int i = 0; i < producedElements.length; i++) {
            synchronized (sharedOrderQueue) {
                while (producedElements[i]) {
                    try {
                        sharedOrderQueue.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

                Order order = new Order("Customer " + (i + 1), "Coffee");
                sharedOrderQueue.addOrder(order, i);
                System.out.println("Order placed: " + order.getCoffeeType());

                producedElements[i] = true;
                sharedOrderQueue.notifyAll();
            }

            try {
                sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class Consumer extends Thread {
    private SharedOrderQueue sharedOrderQueue;
    private boolean[] producedElements;

    Consumer(SharedOrderQueue sharedOrderQueue, boolean[] producedElements) {
        this.sharedOrderQueue = sharedOrderQueue;
        this.producedElements = producedElements;
    }

    public void run() {
        for (int i = 0; i < producedElements.length; i++) {
            synchronized (sharedOrderQueue) {
                while (!producedElements[i]) {
                    try {
                        sharedOrderQueue.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }

                Order order = sharedOrderQueue.processOrder(i);
                System.out.println("Order processed: " + order.getCoffeeType());

                producedElements[i] = false;
                sharedOrderQueue.notifyAll();
            }

            try {
                sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}

class SharedOrderQueue {
    private Order[] orders;
    private boolean[] producedElements;

    SharedOrderQueue() {
        orders = new Order[10];
        producedElements = new boolean[10];
    }

    synchronized void addOrder(Order order, int index) {
        orders[index] = order;
    }

    synchronized Order processOrder(int index) {
        return orders[index];
    }

    synchronized boolean[] getProducedElements() {
        return producedElements;
    }

    synchronized void notifyProducer() {
        notifyAll();
    }
}

public class BaristaOperates {
    public static void main(String[] args) {
        SharedOrderQueue sharedOrderQueue = new SharedOrderQueue();
        Producer producer = new Producer(sharedOrderQueue, sharedOrderQueue.getProducedElements());
        Consumer consumer = new Consumer(sharedOrderQueue, sharedOrderQueue.getProducedElements());

        producer.start();
        consumer.start();
    }
}