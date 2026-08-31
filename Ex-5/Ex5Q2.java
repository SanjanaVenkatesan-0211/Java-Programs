class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + " is running");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
        }
    }
}

public class Ex5Q2 {
    public static void main(String[] args) throws Exception {

        MyThread t1 = new MyThread("Thread-1");
        MyThread t2 = new MyThread("Thread-2");
        MyThread t3 = new MyThread("Thread-3");
        MyThread t4 = new MyThread("Thread-4");
        MyThread t5 = new MyThread("Thread-5");

        t1.setPriority(Thread.MIN_PRIORITY); // 1
        t2.setPriority(3);
        t3.setPriority(5);
        t4.setPriority(Thread.MAX_PRIORITY); // 10
        t5.setPriority(Thread.MAX_PRIORITY); // 10

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        t4.sleep(2000);
        t5.sleep(2000);

        System.out.println("T1 Alive: " + t1.isAlive());
        System.out.println("T2 Alive: " + t2.isAlive());
        System.out.println("T3 Alive: " + t3.isAlive());
        System.out.println("T4 Alive: " + t4.isAlive());
        System.out.println("T5 Alive: " + t5.isAlive());

        t1.join();
        t2.join();
        t3.join();
        t4.join();
        t5.join();

        System.out.println("Longest lasting thread: Thread-4 and Thread-5");
    }
}