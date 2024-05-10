package Aula2;

import java.util.Scanner;

public class Exer6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type your time in seconds: ");
        int time = sc.nextInt();

        int hours = time / 3600;
        int minutes = (time % 3600) / 60;
        int seconds = (time % 3600) % 60;

        System.out.printf("The time is %d:%d:%d", hours, minutes, seconds);
        sc.close();
    }
}