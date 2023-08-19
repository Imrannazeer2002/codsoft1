import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Word Counting Program");
        System.out.print("Enter 'text' to input text manually or 'file' to provide a file: ");
        String inputType = scanner.nextLine();

        String text = "";

        if (inputType.equalsIgnoreCase("text")) {
            System.out.print("Enter the text: ");
            text = scanner.nextLine();
        } else if (inputType.equalsIgnoreCase("file")) {
            System.out.print("Enter the path to the file: ");
            String filePath = scanner.nextLine();

            try {
                text = readFile(filePath);
            } catch (IOException e) {
                System.out.println("Error reading the file.");
                return;
            }
        } else {
            System.out.println("Invalid input.");
            return;
        }

        String[] words = text.split("[\\s\\p{Punct}]+");
        int totalWordCount = words.length;

        // Ignoring common words
        String[] commonWords = {"the", "and", "is", "in", "it", "of", "to", "a"};
        Map<String, Integer> wordFrequency = new HashMap<>();

        for (String word : words) {
            word = word.toLowerCase();
            if (!Arrays.asList(commonWords).contains(word)) {
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }

        System.out.println("Total word count: " + totalWordCount);
        System.out.println("Unique word count: " + wordFrequency.size());

        // Display word frequencies
        System.out.println("Word Frequencies:");
        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    private static String readFile(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        }

        return content.toString();
     }
}