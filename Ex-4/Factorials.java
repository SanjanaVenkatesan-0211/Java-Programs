import java.util.Scanner;

class MathUtils {
    public static int factorial(int n) throws IllegalArgumentException {

        if (n < 0) {
            throw new IllegalArgumentException(
                    "Factorial is not defined for negative numbers");
        }

        if (n > 16) {
            throw new IllegalArgumentException(
                    "Factorial is only defined up to 16 for int type");
        }

        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }

        return fact;
    }
}

public class Factorials {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("Enter an integer (-1 to stop): ");
            int n = sc.nextInt();

            if (n == -1)
                break;

            try {
                System.out.println("Factorial = " + MathUtils.factorial(n));
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        sc.close();
    }
}