class HelloThread extends Thread {
    public void run() {
        while (true) {
            System.out.println("Hello!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
    }
}

class HolidayThread extends Thread {
    public void run() {
        while (true) {
            System.out.println("Happy Holidays!");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {}
        }
    }
}

class EnjoyThread extends Thread {
    public void run() {
        while (true) {
            System.out.println("Enjoy!");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {}
        }
    }
}

public class Ex5Q1 {
    public static void main(String[] args) {
        new HelloThread().start();
        new HolidayThread().start();
        new EnjoyThread().start();
    }
}