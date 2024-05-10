package Aula2;

import java.util.Scanner;

public class Exer1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a sua distância em kilómetros: ");
        double km = sc.nextDouble();

        double Milhas = km / 1.609;

        System.out.println("A sua distância em milhas é " + Milhas + " em milhas.");
        sc.close();
    }
}
