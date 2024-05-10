package Aula7.Exer2;

public class DateYMD extends Data {
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

    public void set(int day, int month, int year) {
        if (validDate(day, month, year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            System.out.println("Invalid date");
        }
    }

    public void incrementDay(int x) {
        int newDay = day + x;
        while (newDay > daysInMonth(month, year)) {
            newDay -= daysInMonth(month, year);
            if (++month > 12) {
                month = 1;
                year++;
            }
        }
        day = newDay;
    }

    public void decrementDay(int x) {
        int newDay = day - x;
        while (newDay < 1) {
            if (--month < 1) {
                month = 12;
                year--;
            }
            newDay += daysInMonth(month, year);
        }
        day = newDay;
    }

    public void incrementMonth(int x) {
        int newMonth = month + x;
        while (newMonth > 12) {
            newMonth -= 12;
            year++;
        }
        month = newMonth;
    }

    public void decrementMonth(int x) {
        int newMonth = month - x;
        while (newMonth < 1) {
            newMonth += 12;
            year--;
        }
        month = newMonth;
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

    public void increment() {
        if (validDate(day + 1, month, year)) {
            this.day += 1;
        } else {
            if (validDate(1, month + 1, year)) {
                this.day = 1;
                this.month += 1;
            } else {
                if (validDate(1, 1, year + 1)) {
                    this.day = 1;
                    this.month = 1;
                    this.year += 1;
                } else {
                    System.out.println("Invalid date");
                }
            }
        }
    }

    public void decrement() {
        if (validDate(day - 1, month, year)) {
            this.day -= 1;
        } else {
            if (validDate(monthDays(month - 1, year), month - 1, year)) {
                this.day = monthDays(month - 1, year);
                this.month -= 1;
            } else {
                if (validDate(monthDays(12, year - 1), 12, year - 1)) {
                    this.day = monthDays(12, year - 1);
                    this.month = 12;
                    this.year -= 1;
                } else {
                    System.out.println("Invalid date");
                }
            }
        }
    }

    private int daysInMonth(int month, int year) {
        switch (month) {
            case 2:
                return isLeapYear(year) ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }

    private boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }

    @Override
    public String toString() {
        return String.format("%04d-%02d-%02d", year, month, day);
    }

    public long getTime() {
        long time = 0;
        for (int i = 0; i < year; i++) {
            if (i % 4 == 0) {
                time += 366;
            } else {
                time += 365;
            }
        }
        for (int i = 1; i < month; i++) {
            time += monthDays(i, year);
        }
        time += day;
        return time;
    }

    public int compareTo(DateYMD date2) {
        if (this.getYear() < date2.getYear())
            return -1;
        else if (this.getYear() > date2.getYear())
            return 1;

        if (this.getMonth() < date2.getMonth())
            return -1;
        else if (this.getMonth() > date2.getMonth())
            return 1;

        if (this.getDay() < date2.getDay())
            return -1;
        else if (this.getDay() > date2.getDay())
            return 1;

        return 0;
    }
}
