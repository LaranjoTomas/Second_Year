package Aula2;

import java.util.Scanner;

public class Exer5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type your initial velocity: ");
        double v1 = sc.nextDouble();
        System.out.println("Type your terminal velocity: ");
        double v2 = sc.nextDouble();
        System.out.println("Type your distance in the first path:  ");
        double d1 = sc.nextDouble();
        System.out.println("Type your distance in the second path: ");
        double d2 = sc.nextDouble();

        double VM = ((d1 + d2) / ((d1 / v1) + (d2 / v2)));

        System.out.printf("The average velocity is %.2f m/s.", VM);
        sc.close();
    }
}
