class BankAccount {
    private int balance = 1000;

    public synchronized void deposit(int amount) {
        balance += amount;

        System.out.println(
                Thread.currentThread().getName()
                        + " Deposited: " + amount
                        + " Balance: " + balance);

        notifyAll(); // Wake up waiting threads
    }

    public synchronized void withdraw(int amount) {

        while (balance < amount) {
            System.out.println(
                    Thread.currentThread().getName()
                            + " Waiting for deposit...");

            try {
                wait(); // Release lock and wait
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        balance -= amount;

        System.out.println(
                Thread.currentThread().getName()
                        + " Withdrawn: " + amount
                        + " Balance: " + balance);
    }
}

class Depositor extends Thread {
    BankAccount account;

    Depositor(BankAccount account, String name) {
        super(name);
        this.account = account;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            account.deposit(500);

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }
}

class Withdrawer extends Thread {
    BankAccount account;

    Withdrawer(BankAccount account, String name) {
        super(name);
        this.account = account;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            account.withdraw(700);

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
            }
        }
    }
}

public class Ex5Q5_IPC {
    public static void main(String[] args) throws Exception {

        BankAccount account = new BankAccount();

        Depositor d1 = new Depositor(account, "Depositor-1");

        Withdrawer w1 = new Withdrawer(account, "Withdrawer-1");

        d1.start();
        w1.start();

        d1.join();
        w1.join();

        System.out.println("Transaction Completed");
    }
}