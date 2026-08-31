import java.io.*;
import java.util.Scanner;

public class Warning {

    public static void main(String[] args) {

        try {

            Scanner scan = new Scanner(new File("students.dat"));
            PrintWriter outFile = new PrintWriter(new FileWriter("warning.dat"));

            while (scan.hasNext()) {

                String name = scan.next();
                int hours = scan.nextInt();
                double qualityPoints = scan.nextDouble();

                double gpa = qualityPoints / hours;

                boolean warning = false;

                if (hours < 30 && gpa < 1.5)
                    warning = true;
                else if (hours < 60 && gpa < 1.75)
                    warning = true;
                else if (hours >= 60 && gpa < 2.0)
                    warning = true;

                if (warning) {
                    outFile.printf("%s %d %.2f%n", name, hours, gpa);
                }
            }

            outFile.close();
            scan.close();

            System.out.println(
                    "Academic warning list created successfully.");

        } catch (FileNotFoundException e) {

            System.out.println(
                    "Error: Input file students.dat not found.");

        } catch (NumberFormatException e) {

            System.out.println(
                    "Error: Invalid number format in input file.");

        } catch (IOException e) {

            System.out.println(
                    "Error: Problem reading or writing the file.");
        }
    }
}