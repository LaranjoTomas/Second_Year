package Aula7.Exer2;

// Construa uma nova classe DateND em que a data é representada internamente como 
//sendo a distância (em número de dias) a 1 de Janeiro de 2000. Esta classe deve descender de 
//Date e implementar todos os serviços públicos necessários

public class DateND extends Data {

    private int days;

    public int getDays() {
        return days;
    }

    public static boolean validDays(int days) {
        return days >= 0;
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

    public static int yearDays(int year) {
        if (year % 4 == 0) {
            return 366;
        } else {
            return 365;
        }
    }

    public static boolean validDate(int day, int month, int year) {
        if (validMonth(month) && validDay(day) && validYear(year)) {
            if (day <= monthDays(month, year)) {
                return true;
            }
        }
        return false;
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

    public DateND(int day, int month, int year) {
        if (validDate(day, month, year)) {
            int days = 0;
            for (int i = 2000; i < year; i++) {
                days += yearDays(i);
            }
            for (int i = 1; i < month; i++) {
                days += monthDays(i, year);
            }
            days += day;
            this.days = days;
        } else {
            System.out.println("Invalid date");
        }
    }

    public int getDay() {
        int day = 0;
        int year = 2000;
        int month = 1;
        while (days > 0) {
            if (days > yearDays(year)) {
                days -= yearDays(year);
                year++;
            } else if (days > monthDays(month, year)) {
                days -= monthDays(month, year);
                month++;
            } else {
                day = days;
                days = 0;
            }
        }
        return day;
    }

    public int getMonth() {
        int month = 0;
        int year = 2000;
        while (days > 0) {
            if (days > yearDays(year)) {
                days -= yearDays(year);
                year++;
            } else if (days > monthDays(month, year)) {
                days -= monthDays(month, year);
                month++;
            } else {
                days = 0;
            }
        }
        return month;
    }

    public void set(int day, int month, int year) {
        if (validDate(day, month, year)) {
            int days = 0;
            for (int i = 2000; i < year; i++) {
                days += yearDays(i);
            }
            for (int i = 1; i < month; i++) {
                days += monthDays(i, year);
            }
            days += day;
            this.days = days;
        } else {
            System.out.println("Invalid date");
        }
    }

    public void increment() {
        this.days++;
    }

    public void decrement() {
        this.days--;
    }

    public int getYear() {
        int year = 2000;
        while (days > 0) {
            if (days > yearDays(year)) {
                days -= yearDays(year);
                year++;
            } else {
                days = 0;
            }
        }
        return year;
    }

    @Override
    public String toString() {
        return getDay() + "/" + getMonth() + "/" + getYear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if ((o == null) || (this.getClass() != o.getClass())) {
            return false;
        }
        DateND d = (DateND) o;
        return (this.days == d.days);
    }

    public int compareTo(DateND d) {
        if (this.days < d.days) {
            return -1;
        } else if (this.days == d.days) {
            return 0;
        } else {
            return 1;
        }
    }

    public void nextDay() {
        this.days++;
    }

    public void previousDay() {
        this.days--;
    }

    public void addDays(int days) {
        this.days += days;
    }

    public void subDays(int days) {
        this.days -= days;
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
