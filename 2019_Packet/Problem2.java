// NOTE: This is an incorrect solution produced within the time limit
// Months are handled incorrectly

import java.util.ArrayList;

public class Problem2 {
    public static void main(String[] args) {
        run("7.2 4.0 2.7 4.6 5.7 -1.0 4.9 5.1 4.9 5.6 4.9 0.3 1.1 -1.0 7.1 2.9 1.8 0.9 5.9 5.8 4.9 -1.0 4.4 4.8 5.3 6.2 4.2 1.2 1.7 -1.0 2.3 4.3 1.9 0.4 3.5 -2.0 5.2 1.1 -1.0 1.6 2.2 4.2 5.0 1.7 5.9 0.9 -1.0 3.3 2.0 4.9 5.1 4.9 5.6 4.9 -1.0 1.1 2.9 1.8 0.9 5.9 5.8 4.9 -1.0 9.8 3.4 4.8 5.3 6.2 -2.0 4.7 5.1 -1.0 1.3 3.0 3.1 3.1 4.9 5.6 4.6 -1.0 4.1 3.0 -1.0 -3.0");
    }

    private static void run(String input) {
        String[] tokens = input.split(" ");
        float[] values = new float[tokens.length];
        for (int i = 0; i < tokens.length; ++i)
            values[i] = Float.parseFloat(tokens[i]);
        
        ArrayList<Float> currentYear = new ArrayList<>();
        int monthNumber = 1;
        ArrayList<Float> currentMonth = new ArrayList<>();
        int weekNumber = 1;
        ArrayList<Float> currentWeek = new ArrayList<>();
        int dayNumber = 1;
        for (float value : values) {
            if (value == -1F) {
                printStats("Week", weekNumber++, currentWeek);

                currentMonth.addAll(currentWeek);
                currentWeek.clear();
            } else if (value == -2F) {
                printStats("Month", monthNumber++, currentMonth);

                currentYear.addAll(currentMonth);
                currentMonth.clear();
            } else if (value == -3F) {
                printStats("Week", weekNumber++, currentWeek);
                currentMonth.addAll(currentWeek);
                printStats("Month", monthNumber++, currentMonth);
                currentYear.addAll(currentMonth);
                System.out.println("Year to Date for " + dayNumber + " days = " + average(currentYear) + "mi.");
            } else {
                currentWeek.add(value);

                ++dayNumber;
            }
        }
    }

    private static void printStats(String kind, int number, ArrayList<Float> data) {
        System.out.println(kind + " #" + number + " = " + average(data) + "mi.");
    }

    private static float average(ArrayList<Float> numbers) {
        if (numbers.isEmpty())
            return 0F;
        
        float acc = 0F;
        for (Float number : numbers)
            acc += number;
        return acc / (float) numbers.size();
    }
}