package Aula2;

import java.util.Scanner;

public class Exer8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type the value of the side of the triangle (not the hypotenuse): ");
        double side = sc.nextDouble();
        System.out.println("Type the value of the other side of the triangle (not the hypotenuse): ");
        double otherSide = sc.nextDouble();

        double hypotenuse = Math.sqrt(Math.pow(side, 2) + Math.pow(otherSide, 2));
        double AngleFirstSide = Math.toDegrees(Math.acos(side / hypotenuse));
        double AngleSecondSide = Math.toDegrees(Math.acos(otherSide / hypotenuse));

        System.out.printf("The hypotenuse is %.2f and the angles are %.2f and %.2f", hypotenuse, AngleFirstSide,
                AngleSecondSide);
        sc.close();
    }
}
