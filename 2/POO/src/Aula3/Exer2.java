package Aula3;

import java.util.Scanner;

public class Exer2 {
    public static void main(String[] args) throws Exception {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Type your Positive Number: ");
            int number = sc.nextInt();

            if (number < 0 || number > 20) {
                return;
            }

            for (; number >= 0; number--) {
                System.out.println(number);
            }

            sc.close();
        }
    }
}
