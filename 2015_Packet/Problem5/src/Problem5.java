import java.util.Scanner;
public class Problem5
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        final int CASE = Integer.parseInt(input.nextLine());
        int[] result = new int[CASE];
        for (int i = 0; i < CASE; i++)
        {
            int[] time = toTime(input.nextLine());
            int hour = time[0];
            int minute = time[1];
            int second = time[2];

            int secondNeeded;
            if (second == 0)
                secondNeeded = 0;
            else
            {
                secondNeeded = 60 - second;
                ++minute;
            }

            int minuteNeeded;
            if (minute % 10 == 0)
                minuteNeeded = 0;
            else
                minuteNeeded = 10 - (minute % 10);

            result[i] = minuteNeeded * 60 + secondNeeded;
        }
        for (int i = 0; i < result.length; i++)
        {
            System.out.println(result[i]);
        }
    }
    static int[] toTime(String s)
    {
        String[] input = s.split(":");
        int[] result = new int[input.length];
        for (int i = 0; i < result.length; i++)
        {
            result[i] = Integer.parseInt(input[i]);
        }
        return result;
    }
}
