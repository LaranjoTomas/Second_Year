package Aula5;

import java.util.Scanner;

public class Exer2 {
    public static void main(String[] Args) {
        int input;
        Scanner sc = new Scanner(System.in);
        Calendar calendar = new Calendar(2023, 1);

        do {
            System.out.println("");
            System.out.println("Calendar operations: ");
            System.out.println("1 - create new calendar");
            System.out.println("2 - print calendar month");
            System.out.println("3 - print calendar");
            System.out.println("0 - Exit");
            System.out.print("Enter option: ");

            input = sc.nextInt();

            switch (input) {
                case 1:
                    System.out.print("\nEnter the weekday the year started, (1-Sunday to 7-Saturday): ");
                    int weekday = sc.nextInt();
                    System.out.print("\nEnter year: ");
                    int year = sc.nextInt();
                    calendar = new Calendar(year, weekday);
                    break;
                case 2:
                    if (calendar == null) {
                        System.out.println("Calendar not created");
                        break;
                    }
                    System.out.print("\nEnter month: ");
                    int month = sc.nextInt();
                    calendar.printMonth(month);
                    break;
                case 3:
                    if (calendar == null) {
                        System.out.println("Calendar not created");
                        break;
                    }
                    calendar.toString();
                    break;
                case 0:
                    System.out.println("\nExiting...");
                    break;
            }
        } while (input != 0);
        System.out.println();
        sc.close();
    }
}
