package Aula5;

public class DateYMD {
    private int day;
    private int month;
    private int year;

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public static boolean validMonth(int month) {
        return month >= 1 && month <= 12;
    }

    public static boolean validDay(int day) {
        return day >= 1 && day <= 31;
    }

    public static boolean validYear(int year) {
        return year >= 0;
    }

    public DateYMD(int day, int month, int year) {
        if (validDate(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            System.out.println("Invalid date");
        }
    }

    // um método inteiro que devolva o número de dias de um determinado mês, num
    // determinado ano: monthDays(int month, int year)

    public static int monthDays(int month, int year) {
        int days = 0;
        switch (month) {
            case 1:
                days = 31;
                break;
            case 2:
                if (year % 4 == 0) {
                    days = 29;
                } else {
                    days = 28;
                }
                break;
            case 3:
                days = 31;
                break;
            case 4:
                days = 30;
                break;
            case 5:
                days = 31;
                break;
            case 6:
                days = 30;
                break;
            case 7:
                days = 31;
                break;
            case 8:
                days = 31;
                break;
            case 9:
                days = 30;
                break;
            case 10:
                days = 31;
                break;
            case 11:
                days = 30;
                break;
            case 12:
                days = 31;
                break;
        }
        return days;
    }

    // um método booleano que indique se um ano é bissexto: leapYear(int year)
    public boolean leapYear(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return true;
        } else {
            return false;
        }
    }

    // um método booleano que indique se uma data é válida: validDate(int day, int
    // month, int year)
    public static boolean validDate(int day, int month, int year) {
        if (validMonth(month) && validDay(day) && validYear(year)) {
            if (monthDays(month, year) >= day) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    // definir uma data: set(int day, int month, int year);

    public void set(int day, int month, int year) {
        if (validDate(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            System.out.println("Invalid date");
        }
    }

    // incrementar a data (increment);
    public void incrementDay(int x) {
        if (validDate(day + x, month, year)) {
            this.day += x;
        } else {
            System.out.println("Invalid date");
        }
    }

    public void decrementDay(int x) {
        if (validDate(day - x, month, year)) {
            this.day -= x;
        } else {
            System.out.println("Invalid date");
        }
    }

    public void incrementMonth(int x) {
        if (validDate(day, month + x, year)) {
            this.month += x;
        } else {
            System.out.println("Invalid date");
        }
    }

    public void decrementMonth(int x) {
        if (validDate(day, month - x, year)) {
            this.month -= x;
        } else {
            System.out.println("Invalid date");
        }
    }

    public void incrementYear(int x) {
        if (validDate(day, month, year + x)) {
            this.year += x;
        } else {
            System.out.println("Invalid date");
        }
    }

    public void decrementYear(int x) {
        if (validDate(day, month, year - x)) {
            this.year -= x;
        } else {
            System.out.println("Invalid date");
        }
    }

    public boolean equals(DateYMD Date) {
        if (this.day == Date.day && this.month == Date.month && this.year == Date.year) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    public long getTime() {
        return 0;
    }
}
