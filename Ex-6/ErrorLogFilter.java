import java.io.*;

public class ErrorLogFilter {

    public static void main(String[] args) {

        int count = 0;

        try (
                BufferedReader br = new BufferedReader(new FileReader("server.log"));

                BufferedWriter bw = new BufferedWriter(new FileWriter("error_logs.txt"))) {

            String line;

            while ((line = br.readLine()) != null) {

                if (line.contains("ERROR")) {
                    bw.write(line);
                    bw.newLine();
                    count++;
                }
            }

            System.out.println("Total ERROR lines found: " + count);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}