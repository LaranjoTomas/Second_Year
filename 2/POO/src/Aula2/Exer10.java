package Aula2;

import java.util.Scanner;

public class Exer10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type the first number to stop the loop, it will not count for the results.");
        double number = sc.nextDouble();
        double max = -2147483648;
        double min = 2147483647;
        double average = 0;

        for (int i = 0; i < 100; i++) {
            System.out.println("Type your Positive Number: ");
            double number2 = sc.nextDouble();
            if (number2 == number) {
                average = average / i;
                System.out.println("Max number: " + max);
                System.out.println("Min number: " + min);
                System.out.println("Average: " + average);
                System.out.println("Number of numbers typed: " + i);
                break;
            }

            if (number2 > max) {
                max = number2;
            }
            if (number2 < min) {
                min = number2;
            }
            average += number2;

        }

        sc.close();
    }
}
