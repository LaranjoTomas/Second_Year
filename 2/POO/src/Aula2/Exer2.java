package Aula2;

import java.util.Scanner;

public class Exer2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a sua temperatura em Célsius: ");
        double C = sc.nextDouble();

        double F = (C * 1.8) + 32;

        System.out.printf("A sua temperatura em Farenheit é %.2f em Farenheit.", F);
        sc.close();
    }
}