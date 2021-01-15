import java.util.Scanner;
public class Problem4
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        final int CASE = Integer.parseInt(input.nextLine());
        double[][] result = new double[CASE][2];
        for (int i = 0; i < CASE; i++)
        {
            int[] pair = toPair(input.nextLine());
            double x = pair[0];
            double y = pair[1];
            result[i][0] = 2 * (x + Math.pow((x * x) - y, 0.5));
            result[i][1] = 2 * (x - Math.pow((x * x) - y, 0.5));
        }
        for (int i = 0; i < CASE; i++)
        {
            System.out.printf("Case %d:  The slopes are %.2f and %.2f\n", i + 1, result[i][0], result[i][1]);
        }
    }
    static int[] toPair(String s)
    {
        String[] input = s.split(" ");
        int[] result = new int[input.length];
        StringBuilder sb1 = new StringBuilder(input[0]);
        StringBuilder sb2 = new StringBuilder(input[1]);
        sb1.deleteCharAt(0);
        sb1.deleteCharAt(sb1.length() - 1);
        sb2.deleteCharAt(sb2.length() - 1);
        result[0] = Integer.parseInt(sb1.toString());
        result[1] = Integer.parseInt(sb2.toString());
        return result;
    }
}
