package Aula3;

//Exercicio 3.5 do guião 3

import java.util.Scanner;

public class Exer7 {
    public static void main(String[] args) {
        int[] values = readValues();
        drawCalendar(values[0], values[1], values[2]);
    }

    public static int[] readValues() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduza o mês: ");
        int month = sc.nextInt();
        System.out.println("Introduza o ano: ");
        int year = sc.nextInt();
        System.out.println("Introduza o dia da semana: ");
        int weekDay = sc.nextInt();

        sc.close();
        return new int[] { month, year, weekDay };
    }

    public static int numberOfDaysInMonth(int month, int year) {
        if (month == 2) {
            if (isLeapYear(year))
                return 29;
            return 28;
        }
        if (month == 4 || month == 6 || month == 9 || month == 11)
            return 30;
        return 31;
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static void drawCalendar(int month, int year, int weekDay) {

        if (weekDay == 7)
            weekDay = 0;

        int days = numberOfDaysInMonth(month, year);
        String monthName = getMonthName(month);

        int monthNameLength = monthName.length();
        int yearLength = String.valueOf(year).length();
        int padding = (20 - monthNameLength - yearLength) / 2;
        String paddingString = "";
        for (int i = 0; i < padding; i++)
            paddingString += " ";

        System.out.println(paddingString + monthName + " " + year + paddingString);
        System.out.println("Su Mo Tu We Th Fr Sa");

        for (int i = 0; i < weekDay; i++)
            System.out.print("   ");

        for (int i = 1; i <= days; i++) {
            System.out.printf("%2d ", i);
            if ((i + weekDay) % 7 == 0 || i == days)
                System.out.println();
        }
    }

    public static String getMonthName(int month) {
        switch (month) {
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                return "";
        }
    }

}
