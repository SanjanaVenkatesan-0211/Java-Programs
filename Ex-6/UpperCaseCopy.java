import java.io.*;

public class UpperCaseCopy {
    public static void main(String[] args) throws Exception {

        FileReader fr = new FileReader("input2.txt");
        FileWriter fw = new FileWriter("output2.txt");

        int ch;

        while ((ch = fr.read()) != -1) {
            fw.write(Character.toUpperCase((char) ch));
        }

        fr.close();
        fw.close();

        System.out.println("File copied successfully.");
    }
}