class BankAccount {

    long balance;

    public BankAccount(long balance) {
        this.balance = balance;
    }

    public long getAvailableBalance() {
        return balance;
    }

    public synchronized void withdraw(String user, long amount) {

        if(amount > balance) {
            System.out.println("Transaction failed for " + user + ", because of available funds are less than the funds asked for.\n");
            return;
        }

        System.out.println(user + " trying to withdraw " + amount + ".");

        balance -= amount;

        System.out.println("Transaction successful for " + user + " for " + amount + "." + "\nBalance Available after booking: " + balance + "\n");
    }

}

class JointAccountHolder extends Thread {
    
    BankAccount ba;
    String user;
    long amount;

    public JointAccountHolder(BankAccount ba, String user, long amount) {
        this.ba = ba;
        this.user = user;
        this.amount = amount;
    }

    public void run() {
        ba.withdraw(user, amount);
    }

}

public class Java3_9 {
    public static void main(String[] args) {
        
        BankAccount ba = new BankAccount(10000000);

        System.out.println("Initial Balance: " + ba.getAvailableBalance() + "\n");

        JointAccountHolder h1 = new JointAccountHolder(ba, "Person1", 5000000);
        JointAccountHolder h2 = new JointAccountHolder(ba, "Person2", 3000000);
        JointAccountHolder h3 = new JointAccountHolder(ba, "Person3", 2500000);

        h1.start();
        h2.start();
        h3.start();

        try {
            h1.join();
            h2.join();
            h3.join();
        }

        catch (Exception e) {
            System.out.println(e);
        }

        finally {
            System.out.println("Balance Available After Booking All: " + ba.getAvailableBalance() + "\n");
        }
    }
}