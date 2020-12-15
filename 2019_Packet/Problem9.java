// Problem 9: Day of the Year

import java.util.Scanner;

public class Problem9 {
    private static class NumericalDate {
        public final int month;
        public final int day;
        public final int year;

        public NumericalDate(final int month, final int day, final int year) {
            this.month = month;
            this.day = day;
            this.year = year;
        }
    }

    public static void main(String[] args) {
        NumericalDate[] dates = takeInput(new Scanner(System.in));

        for (NumericalDate date : dates) {
            int dayOfYear = 0;
            for (int month = 1; month < date.month; ++month)
                dayOfYear += getDaysPerMonth(month, date.year);
            dayOfYear += date.day;

            String weekday = getWeekday(date);

            System.out.printf("%d/%d/%d is a %s and the %d%s day of the year.\n",
                    date.month, date.day, date.year, weekday, dayOfYear, getNumberSuffix(dayOfYear));
        }
    }

    private static String getNumberSuffix(int number) {
        int lowestDigit = number % 10;

        switch (lowestDigit) {
            case 1:
                return "st";
            case 2:
                return "nd";
            case 3:
                return "rd";
            default:
                return "th";
        }
    }

    private static String getWeekday(NumericalDate date) {
        int year, month;
        switch (date.month) {
            case 1:
            case 2:
                year = date.year - 1;
                month = 12 + date.month;
                break;
            default:
                year = date.year;
                month = date.month;
                break;
        }
        
        int j = year / 100;
        int k = year % 100;
        int m = month;
        int q = date.day;
        int h = (q + 26*(m+1)/10 + k + k/4 + j/4 + 5*j) % 7;

        switch (h) {
            case 0:
                return "Saturday";
            case 1:
                return "Sunday";
            case 2:
                return "Monday";
            case 3:
                return "Tuesday";
            case 4:
                return "Wednesday";
            case 5:
                return "Thursday";
            case 6:
            default:
                return "Friday";
        }
    }

    private static int getDaysPerMonth(int month, int year) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
            default:
                return 28 + (isLeapYear(year) ? 1 : 0);
        }
    }

    private static boolean isLeapYear(int year) {
        // leap year as defined by the packet
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0); 
    }

    private static NumericalDate[] takeInput(Scanner scanner) {
        int dateCount = Integer.parseInt(scanner.nextLine());
        NumericalDate[] dates = new NumericalDate[dateCount];

        for (int i = 0; i < dateCount; ++i) {
            String[] dateStrings = scanner.nextLine().split("/");

            dates[i] = new NumericalDate(
                Integer.parseInt(dateStrings[0]),
                Integer.parseInt(dateStrings[1]),
                Integer.parseInt(dateStrings[2])
            );
        }

        return dates;
    }
}