import java.util.Scanner;

public class NameValidation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter full name: ");
        String name = sc.nextLine();

        if (name.matches("[A-Za-z]+ [A-Za-z]+")) {
            System.out.println("Valid name");
        } else {
            System.out.println("Incorrect format for name");
        }

        sc.close();
    }
}