package Aula2;

import java.util.Scanner;

public class Exer3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a massa da água (kg): ");
        double Massa = sc.nextDouble();

        System.out.println("Digite a temperatura inicial da água (C): ");
        double TI = sc.nextDouble();
        System.out.println("Digite a temperatura final da água (C): ");
        double TF = sc.nextDouble();

        double Q = Massa * (TF - TI) * 4184;

        System.out.printf("A quantidade de energia necessária para aquecer a água é %.2f J.", Q);
        sc.close();

    }
}
