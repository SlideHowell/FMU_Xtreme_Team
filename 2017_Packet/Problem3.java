// Problem 3: Number Convert

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Problem3 {
    private static final HashMap<Character, Integer> VALUES = createValuesMap();

    public static void main(String[] args) {
        for (String line : takeInput(new Scanner(System.in))) {
            int value = 0;

            for (char ch : line.toCharArray())
                value += VALUES.get(ch);
            
            System.out.printf("%s = %d\n", line, value);
        }
    }

    private static ArrayList<String> takeInput(Scanner scanner) {
        ArrayList<String> input = new ArrayList<>();

        for (String line = scanner.nextLine(); !line.equals("-1"); line = scanner.nextLine())
            input.add(line);

        return input;
    }

    private static HashMap<Character, Integer> createValuesMap() {
        HashMap<Character, Integer> values = new HashMap<>();

        final int MAX_MAGNITUDE = 100000;

        int magnitude = 1;
        int value = 1;
        char ch = 'a';
        while (magnitude <= MAX_MAGNITUDE) {
            values.put(ch, value * magnitude);

            // handle transitions
            if (ch == 'z')
                ch = '?';
            else if (ch == '?')
                ch = 'A';
            else if (ch == 'Z')
                ch = 'Z';
            else
                ++ch;

            if (++value == 10) {
                value = 1;
                magnitude *= 10;
            }
        }

        return values;
    }
}
