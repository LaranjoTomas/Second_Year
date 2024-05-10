package Aula2;

import java.util.Scanner;

public class Exer9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o seu número, tem de ser positivo: ");
        int number = sc.nextInt();

        if (number < 0) {
            System.out.println("Must be positive");
            sc.close();
            return;
        }

        for (int i = number - 1; i >= 0; i--) {
            if (i % 10 == 0) {
                System.out.println(i + ", " + "\n");
            } else {
                System.out.print(i + ", ");
            }
        }

        sc.close();
    }
}
