class AscendingThread extends Thread {
    public void run() {
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            System.out.print(ch + " ");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
        System.out.println();
    }
}

class DescendingThread extends Thread {
    public void run() {
        for (char ch = 'Z'; ch >= 'A'; ch--) {
            System.out.print(ch + " ");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
        }
        System.out.println();
    }
}

public class Ex5Q4 {
    public static void main(String[] args) throws Exception {

        AscendingThread t1 = new AscendingThread();
        DescendingThread t2 = new DescendingThread();

        t1.start();

        t1.join(); // wait until first thread completes

        t2.start();

        t2.join();

        System.out.println("\nAll threads completed.");
    }
}