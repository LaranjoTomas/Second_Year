package Aula2;

import java.util.Scanner;

public class Exer4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type your Montante, must be positive and multiple of 1000: ");
        double montante = sc.nextDouble();

        if (montante < 0 || montante % 1000 != 0) {
            System.out.println("Invalid number, try again.");
            sc.close();
            return;
        }

        System.out.println("Type your swears monthly, between 0% and 5%: ");
        double swearsmonthly = sc.nextDouble();

        if (swearsmonthly < 0.0 || swearsmonthly > 5.0) {
            System.out.println("Invalid number, try again.");
            sc.close();
            return;
        }

        for (int i = 0; i < 3; i++) {
            montante += montante * (swearsmonthly / 100);
            System.out.printf("Balanço ao final do mês número %d: %.3f\n", (i + 1), montante);
        }

        sc.close();
    }
}
