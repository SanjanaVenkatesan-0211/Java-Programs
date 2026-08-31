class BankAccount {
    private int balance = 1000;

    public synchronized void deposit(int amount) {
        balance += amount;
        System.out.println(Thread.currentThread().getName()
                + " Deposited: " + amount
                + " Balance: " + balance);
    }

    public synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(Thread.currentThread().getName()
                    + " Withdrawn: " + amount
                    + " Balance: " + balance);
        } else {
            System.out.println(Thread.currentThread().getName()
                    + " Insufficient Balance");
        }
    }
}

class DepositThread extends Thread {
    BankAccount account;

    DepositThread(BankAccount account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            account.deposit(500);
        }
    }
}

class WithdrawThread extends Thread {
    BankAccount account;

    WithdrawThread(BankAccount account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            account.withdraw(300);
        }
    }
}

public class Ex5Q5 {
    public static void main(String[] args) throws Exception {

        BankAccount account = new BankAccount();

        DepositThread d1 = new DepositThread(account);
        WithdrawThread w1 = new WithdrawThread(account);
        DepositThread d2 = new DepositThread(account);
        WithdrawThread w2 = new WithdrawThread(account);

        d1.setName("Depositor-1");
        d2.setName("Depositor-2");
        w1.setName("Withdrawer-1");
        w2.setName("Withdrawer-2");

        d1.start();
        w1.start();
        d2.start();
        w2.start();

        d1.join();
        d2.join();
        w1.join();
        w2.join();

        System.out.println("Transaction Completed");
    }
}