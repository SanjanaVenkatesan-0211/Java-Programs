import java.io.*;
import java.util.Scanner;

public class DecodeAnswers {

    public static void main(String[] args) throws Exception {

        Scanner scan = new Scanner(new File("CodedAnswerKey.txt"));

        String answers = "";

        while (scan.hasNextLine()) {

            String line = scan.nextLine();

            if (line.matches("[a-fA-F]")) {
                answers += line;
            }
        }

        scan.close();

        System.out.println("Decoded answers: " + answers);
    }
}
