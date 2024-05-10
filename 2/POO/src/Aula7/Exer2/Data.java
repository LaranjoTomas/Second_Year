package Aula7.Exer2;

public abstract class Data implements Comparable<Data> {
    public static boolean validMonth(int month) {
        return month >= 1 && month <= 12;
    }

    public static int monthDays(int month, int year) {
        if (month == 2) {
            if (leapYear(year))
                return 29;
            return 28;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }

        return 31;
    }

    public static boolean leapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public static boolean valid(int day, int month, int year) {
        return validMonth(month) && day >= 1 && day <= monthDays(month, year);
    }

    public abstract void set(int day, int month, int year);

    public abstract int getDay();

    public abstract int getMonth();

    public abstract int getYear();

    public abstract void increment();

    public abstract void decrement();

    public void increment(int days) {
        for (int i = 0; i < days; i++)
            increment();
    }

    public void decrement(int days) {
        for (int i = 0; i < days; i++)
            decrement();
    }

    @Override
    public String toString() {
        return String.format("%04d-%02d-%02d", this.getYear(), this.getMonth(), this.getDay());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + getDay();
        result = prime * result + getMonth();
        result = prime * result + getYear();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        return this.getDay() == this.getDay() && this.getMonth() == this.getMonth()
                && this.getYear() == this.getYear();
    }

    public int compareTo(Data d) {
        if (this.getYear() != d.getYear())
            return this.getYear() - d.getYear();
        if (this.getMonth() != d.getMonth())
            return this.getMonth() - d.getMonth();
        return this.getDay() - d.getDay();
    }
}
