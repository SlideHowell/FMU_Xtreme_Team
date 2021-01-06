import java.util.Arrays;
import java.util.Scanner;
import java.util.HashSet;
public class Problem2
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        final int BILL = Integer.parseInt(input.nextLine());
        String[] serials = new String[BILL];
        String[] result = new String[BILL];

        for (int i = 0; i < BILL; i++)
        {
            String serial = input.nextLine();
            serials[i] = serial;
            if (solid(serial))
            {
                result[i] = "solid";
                continue;
            }
            if (ladder(serial))
            {
                result[i] = "ladder";
                continue;
            }
            if (low(serial))
            {
                result[i] = "low";
                continue;
            }
            if (high(serial))
            {
                result[i] = "high";
                continue;
            }
            if (radar(serial))
            {
                result[i] = "radar";
                continue;
            }
            if (repeater(serial))
            {
                result[i] = "repeater";
                continue;
            }
            if (sevenRow(serial))
            {
                result[i] = "seven in a row";
                continue;
            }
            if (sevenKind(serial))
            {
                result[i] = "seven of a kind";
                continue;
            }
            result[i] = "no pattern";
        }
        for (int i = 0; i < BILL; i++)
        {
            System.out.println(serials[i] + ":" + result[i]);
        }
    }
    static boolean solid(String s)
    {
        String[] input = s.split("");
        for (String digit : input)
        {
            if (!digit.equals(input[0]))
                return false;
        }
        return true;
    }
    static boolean ladder(String s)
    {
        int[] input = toIntArray(s);
        if (input[0] - input[1] == 1)
            for (int i = 1; i < input.length; i++)
            {
                if (!(input[i - 1] - input[i] == 1))
                    return false;
            }
        else if (input[0] - input[1] == -1)
            for (int i = 1; i < input.length; i++)
            {
                if (!(input[i - 1] - input[i] == -1))
                    return false;
            }
        else
            return false;
        return true;
    }
    static boolean low(String s)
    {
        int input = Integer.parseInt(s);
        return input <= 100;
    }
    static boolean high(String s)
    {
        int input = Integer.parseInt(s);
        return input >= 99999900;
    }
    static boolean radar(String s)
    {
        String reversed = new StringBuilder(s).reverse().toString();
        return s.equals(reversed);
    }
    static boolean repeater(String s)
    {
        return s.substring(0, 4).equals(s.substring(4));
    }
    static boolean sevenRow(String s)
    {
        String[] input1 = s.substring(1).split("");
        String[] input2 = s.substring(0, 7).split("");
        HashSet<String> set = new HashSet<>();

        set.addAll(Arrays.asList(input1));
        if (set.size() == 1)
            return true;

        set.clear();

        set.addAll(Arrays.asList(input2));
        if (set.size() == 1)
            return true;

        return false;
    }
    static boolean sevenKind(String s)
    {
        String[] input = s.split("");
        String digit1 = input[0], digit2 = null;
        int first = 0, second = 1;
        for (String digit : input)
        {
            if (!digit.equals(digit1) && digit2.equals(null))
                digit2 = digit;
            if (digit.equals(digit1))
                ++first;
            else if (digit.equals(digit2))
                ++second;
            else
                return false;
        }
        return (first == 7 || second == 7);
    }
    static int[] toIntArray(String s)
    {
        String[] input = s.split("");
        int[] result = new int[s.length()];
        for (int i = 0; i < input.length; i++)
            result[i] = Integer.parseInt(input[i]);
        return result;
    }
}
