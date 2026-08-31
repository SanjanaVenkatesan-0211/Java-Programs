import java.io.*;
import java.util.*;

public class WordFrequency {
    public static void main(String[] args) throws Exception {

        FileInputStream fis = new FileInputStream("input.txt");

        StringBuilder content = new StringBuilder();
        int ch;

        while ((ch = fis.read()) != -1) {
            content.append((char) ch);
        }

        fis.close();

        String[] words = content.toString()
                .toLowerCase()
                .replaceAll("[^a-z ]", "")
                .split("\\s+");

        Map<String, Integer> map = new TreeMap<>();

        for (String word : words) {
            if (!word.isEmpty()) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        FileOutputStream fos = new FileOutputStream("output.txt");
        PrintWriter pw = new PrintWriter(fos);

        pw.println("WORDS IN ALPHABETICAL ORDER");
        pw.println("--------------------------");

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            pw.println(entry.getKey() + " : " + entry.getValue());
        }

        pw.println("\nSORTED BY FREQUENCY");
        pw.println("------------------");

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

        list.sort((a, b) -> b.getValue() - a.getValue());

        for (Map.Entry<String, Integer> entry : list) {
            pw.println(entry.getKey() + " : " + entry.getValue());
        }

        pw.close();

        System.out.println("Output written to output.txt");
    }
}