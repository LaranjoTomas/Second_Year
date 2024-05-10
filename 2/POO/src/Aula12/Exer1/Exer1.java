package Aula12.Exer1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Exer1 {
    public static void main(String[] args) {
        String path = "./Aula12/Exer1/major.txt";

        try {
            FileReader File = new FileReader(path);
            BufferedReader FileBuffed = new BufferedReader(File);

            Set<String> DiffWords = new HashSet<>();
            int Words = 0;
            String line;

            while ((line = FileBuffed.readLine()) != null) {
                String[] words = line.split("\\s+"); // Divide a linha em palavras usando espaços como delimitadores
                for (String word : words) {
                    if (DiffWords.contains(word.toLowerCase())) {
                        Words++;
                    } else {
                        if (!word.isEmpty()) {
                            DiffWords.add(word.toLowerCase()); // Adiciona a palavra ao conjunto de
                                                               // palavras diferentes
                            Words++;
                        }
                    }
                }
            }

            FileBuffed.close();
            File.close();
            int NDiffWords = DiffWords.size();

            System.out.println("Número Total de Palavras: " + Words);
            System.out.println("Número de Diferentes Palavras: " + NDiffWords);

        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao ler o arquivo: " + e.getMessage());
        }
    }
}
