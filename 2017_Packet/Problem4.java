import java.util.Scanner;
public class Problem4
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        final int SEGMENT = Integer.parseInt(input.nextLine());
        final int CONSTANT = 6;
        double[] result = new double[SEGMENT];

        for (int i = 0; i < SEGMENT; i++)
        {
            String[] userInput = input.nextLine().split(" ");
            // Parse input into an array of constant
            double[] constant = new double[CONSTANT];
            for (int j = 0; j < CONSTANT; j++)
                constant[j] = Double.parseDouble(userInput[j]);
            // Lowercase constants is the actual constant of the parabolas
            final double a = constant[0];
            final double b = constant[1];
            final double c = constant[2];
            final double d = constant[3];
            final double e = constant[4];
            final double f = constant[5];
            // Uppercase constants is the difference between parabolas constant
            final double A = constant[3] - constant[0];
            final double B = constant[4] - constant[1];
            final double C = constant[5] - constant[2];
            // Find determinant of the difference constant, if its not greater than zero then the area is not bounded
            final double DETERMINANT = Math.pow(B, 2) - 4 * A * C;
            if (DETERMINANT <= 0)
            {
                result[i] = 0.000;
                continue;
            }
            // Find the intersections of the two parabolas
            final double intersection1 = (-B + Math.sqrt(DETERMINANT)) / (2 * A);
            final double intersection2 = (-B - Math.sqrt(DETERMINANT)) / (2 * A);
            // Re-categorize which intersection is the lower and upper limit in the integration
            double lowerLimit, upperLimit;
            if (intersection1 < intersection2)
            {
                lowerLimit = intersection1;
                upperLimit = intersection2;
            }
            else
            {
                lowerLimit = intersection2;
                upperLimit = intersection1;
            }
            double test1 = ((a * Math.pow(lowerLimit, 3)) / 3) +
                           ((b * Math.pow(lowerLimit, 2)) / 2) +
                            (c * lowerLimit);
            double test2 = ((a * Math.pow(upperLimit, 3)) / 3) +
                           ((b * Math.pow(upperLimit, 2)) / 2) +
                            (c * upperLimit);

            double test3 = ((d * Math.pow(lowerLimit, 3)) / 3) +
                           ((e * Math.pow(lowerLimit, 2)) / 2) +
                            (f * lowerLimit);
            double test4 = ((d * Math.pow(upperLimit, 3)) / 3) +
                           ((e * Math.pow(upperLimit, 2)) / 2) +
                            (f * upperLimit);
            double areaA = Math.abs(test1) + Math.abs(test2);
            double areaB = Math.abs(test3) + Math.abs(test4);
            if (areaA < areaB)
                result[i] = areaB - areaA;
            else
                result[i] = areaA - areaB;
        }
        for (int i = 0; i < SEGMENT; i++)
        {
            System.out.printf("Segment %d area is %.3f\n", i + 1, result[i]);
        }
    }
}
