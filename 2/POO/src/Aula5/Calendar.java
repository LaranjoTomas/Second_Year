package Aula5;

public class Calendar {
    // um construtor que recebe o ano e o dia da semana (entre 1-domingo e 7-sábado)
    // em que começa o ano
    private String[][] calendar = new String[12][31];
    private int weekday;
    private int year;

    public Calendar(int year, int weekday) {
        this.weekday = weekday;
        this.year = year;
    }

    // um método que recebe uma data e um evento e registra o evento para a data
    // indicada
    // A classe deve fazer uso da classe DateYMD para representar as datas.
    public void addEvent(DateYMD date, String event) {
        int month = date.getMonth();
        int day = date.getDay();
        calendar[month][day] = event;
    }

    public void RemoveEvent(DateYMD date) {
        int month = date.getMonth();
        int day = date.getDay();
        calendar[month][day] = null;
    }

    public int firstWeekdayOfYear() {
        return this.weekday;
    }

    public int getYear() {
        return this.year;
    }

    public int firstWeekdayOfMonth(int month) {
        int firstWeekday = this.weekday;
        for (int i = 1; i < month; i++) {
            firstWeekday += DateYMD.monthDays(i, this.year);
        }
        return firstWeekday % 7 == 0 ? 7 : firstWeekday % 7;
    }

    public void printMonth(int month) {
        int firstWeekday = this.firstWeekdayOfMonth(month);
        int monthDays = DateYMD.monthDays(month, this.year);
        String monthName = monthName(month);

        int monthNameLength = monthName.length();
        int yearLength = String.valueOf(year).length();
        int padding = (20 - monthNameLength - yearLength) / 2;
        String paddingString = "";
        for (int i = 0; i < padding; i++)
            paddingString += " ";

        System.out.println(paddingString + monthName + " " + year + paddingString);
        System.out.println("Su Mo Tu We Th Fr Sa");

        for (int i = 1; i < firstWeekday; i++) {
            System.out.print("   ");
        }

        for (int i = 1; i <= monthDays; i++) {
            System.out.printf("%2d ", i);
            if ((i + firstWeekday - 1) % 7 == 0 || i == monthDays)
                System.out.println();
        }
    }

    public String monthName(int month) {
        String monthName = "";
        switch (month) {
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "February";
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
                break;
        }
        return monthName;
    }

    @Override
    public String toString() {
        for (int i = 1; i <= 12; i++) {
            printMonth(i);
            if (i != 12)
                System.out.println();
        }

        return "Calendar: " + this.year;
    }

}
