import java.util.Random;

class NumberThread extends Thread {
    public void run() {
        Random r = new Random();

        for (int i = 1; i <= 10; i++) {
            int num = r.nextInt(100);

            System.out.println("Generated Number: " + num);

            if (num % 2 == 0) {
                new SquareThread(num).start();
            } else {
                new CubeThread(num).start();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}

class SquareThread extends Thread {
    int num;

    SquareThread(int num) {
        this.num = num;
    }

    public void run() {
        System.out.println("Square = " + (num * num));
    }
}

class CubeThread extends Thread {
    int num;

    CubeThread(int num) {
        this.num = num;
    }

    public void run() {
        System.out.println("Cube = " + (num * num * num));
    }
}

public class Ex5Q3 {
    public static void main(String[] args) {
        new NumberThread().start();
    }
}