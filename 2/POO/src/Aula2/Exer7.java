package Aula2;

import java.util.Scanner;

public class Exer7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Type the x value the point: ");
        double x1 = sc.nextDouble();
        System.out.println("Type the y value the point: ");
        double y1 = sc.nextDouble();

        System.out.println("Type the x value the point:");
        double x2 = sc.nextDouble();
        System.out.println("Type the y value the point: ");
        double y2 = sc.nextDouble();

        double distance = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));

        System.out.printf("The distance between the points is %.2f", distance);
        sc.close();
    }
}
