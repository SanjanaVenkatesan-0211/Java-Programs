import java.util.Scanner;

public class FinalAnswerKey {

    public static String finalAnswers(String answers) {

        answers = answers.replace('e', 'b');
        answers = answers.replace('E', 'A');
        answers = answers.replace('f', 'c');
        answers = answers.replace('F', 'D');

        answers = answers.toLowerCase();

        return answers;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter decoded answer string:");
        String answers = sc.nextLine();
        String result = finalAnswers(answers);

        // String answers = "aBcFeD";

        System.out.println(
                "Final Answers: " + result);
        sc.close();
    }
}
