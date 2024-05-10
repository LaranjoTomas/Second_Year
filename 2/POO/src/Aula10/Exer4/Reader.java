package Aula10.Exer4;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.HashMap;

public class Reader {
    public static void main(String[] args) throws IOException {
        HashMap<String, Integer> map = new HashMap<String, Integer>();

        Scanner input = new Scanner(
                new FileReader("C:/Users/Laranjo/Desktop/UNI/SecondYear/2/POO/src/Aula10/Exer4/words.txt"));
        while (input.hasNext()) {
            String word = input.next();
            if (word.matches("[a-zA-Z]+")) {
                if (word.endsWith("s")) {
                    System.out.println(word);
                } else {
                    continue;
                }
                if (word.length() > 2) {
                    map.put(word, word.length());
                }
            }
        }
        input.close();
    }
}
