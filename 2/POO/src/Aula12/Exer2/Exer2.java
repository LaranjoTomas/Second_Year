package Aula12.Exer2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Exer2 {
    public static void main(String[] args) {
        String path = "./Aula12/Exer2/A_cidade_e_as_serras.txt"; // Substitua pelo caminho do seu arquivo de texto
        String outputPath = "./Aula12/Exer2/output.txt"; // Substitua pelo caminho do arquivo de saída
        try {
            Map<Character, Map<String, Integer>> wordCountsByInitial = countWordsByInitial(path);
            writeWordCountsByInitialToFile(wordCountsByInitial, outputPath);
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }

    public static Map<Character, Map<String, Integer>> countWordsByInitial(String filePath) throws IOException {
        Map<Character, Map<String, Integer>> wordCountsByInitial = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.toLowerCase().split("[^a-zA-Zá-úÀ-Ú0-9']+");

                for (String word : words) {
                    if (word.length() >= 3) {
                        char initial = word.charAt(0);
                        wordCountsByInitial.putIfAbsent(initial, new HashMap<>());
                        Map<String, Integer> wordCounts = wordCountsByInitial.get(initial);
                        wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
                    }
                }
            }
        }

        return wordCountsByInitial;
    }

    public static void writeWordCountsByInitialToFile(Map<Character, Map<String, Integer>> wordCountsByInitial,
            String outputFilePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
            for (char initial : wordCountsByInitial.keySet()) {
                Map<String, Integer> wordCounts = wordCountsByInitial.get(initial);
                List<String> sortedWords = new ArrayList<>(wordCounts.keySet());
                Collections.sort(sortedWords);

                writer.write("Palavras iniciadas com '" + initial + "':\n");

                for (String word : sortedWords) {
                    int count = wordCounts.get(word);
                    writer.write(word + " - " + count + "\n");
                }

                writer.write("\n");
            }
        }
    }
}
