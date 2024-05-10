package Aula5;

import java.util.Scanner;

public class Exer1 {
    public static void main(String[] Args) {
        int input;
        Scanner sc = new Scanner(System.in);
        DateYMD date = new DateYMD(1, 1, 1);

        do {
            System.out.println("");
            System.out.println("Date operations: ");
            System.out.println("1 - Create new date");
            System.out.println("2 - Show current date");
            System.out.println("3 - Increment day");
            System.out.println("4 - Decrement day");
            System.out.println("5 - Increment month");
            System.out.println("6 - Decrement month");
            System.out.println("7 - Increment year");
            System.out.println("8 - Decrement year");
            System.out.println("0 - Exit");
            System.out.print("Enter option: ");

            input = sc.nextInt();

            switch (input) {
                case 1:
                    System.out.print("\nEnter day: ");
                    int day = sc.nextInt();
                    System.out.print("\nEnter month: ");
                    int month = sc.nextInt();
                    System.out.print("\nEnter year: ");
                    int year = sc.nextInt();
                    date = new DateYMD(day, month, year);
                    break;
                case 2:
                    System.out.println("\nCurrent date: " + date);
                    break;
                case 3:
                    System.out.println("\nIncrement date by: ");
                    int increment = sc.nextInt();
                    date.incrementDay(increment);
                    break;
                case 4:
                    System.out.println("\nDecrement date by: ");
                    int decrement = sc.nextInt();
                    date.decrementDay(decrement);
                    break;
                case 5:
                    System.out.println("\nIncrement month by: ");
                    int incrementMonth = sc.nextInt();
                    date.incrementMonth(incrementMonth);
                    break;
                case 6:
                    System.out.println("\nDecrement month by: ");
                    int decrementMonth = sc.nextInt();
                    date.decrementMonth(decrementMonth);
                    break;
                case 7:
                    System.out.println("\nIncrement year by: ");
                    int incrementYear = sc.nextInt();
                    date.incrementYear(incrementYear);
                    break;
                case 8:
                    System.out.println("\nDecrement year by: ");
                    int decrementYear = sc.nextInt();
                    date.decrementYear(decrementYear);
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
